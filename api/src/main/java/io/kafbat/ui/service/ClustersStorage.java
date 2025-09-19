package io.kafbat.ui.service;

import com.google.common.collect.ImmutableMap;
import io.kafbat.ui.config.ClustersProperties;
import io.kafbat.ui.model.KafkaCluster;
import io.kafbat.ui.model.gravitee.Cluster;
import io.kafbat.ui.model.gravitee.ClustersResponse;
import io.kafbat.ui.model.gravitee.security.SecurityProtocol;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.awsmskiam.AwsMskIamSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.gsapi.GsapiSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.oauthbearer.OauthbearerSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.plain.PlainSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.scramsha256.ScramSha256SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.scramsha512.ScramSha512SaslMechanism;
import io.kafbat.ui.util.WebClientConfigurator;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.security.oauthbearer.OAuthBearerLoginCallbackHandler;
import org.apache.kafka.common.security.oauthbearer.OAuthBearerLoginModule;
import org.apache.kafka.common.security.plain.PlainLoginModule;
import org.apache.kafka.common.security.scram.ScramLoginModule;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import javax.security.auth.spi.LoginModule;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.apache.kafka.common.config.SaslConfigs.SASL_JAAS_CONFIG;
import static org.apache.kafka.common.config.SaslConfigs.SASL_LOGIN_CALLBACK_HANDLER_CLASS;
import static org.apache.kafka.common.config.SaslConfigs.SASL_MECHANISM;
import static org.apache.kafka.common.config.SaslConfigs.SASL_OAUTHBEARER_TOKEN_ENDPOINT_URL;

@Component
@Slf4j
public class ClustersStorage {

  private final ImmutableMap<String, KafkaCluster> kafkaClusters;

  public ClustersStorage(ClustersProperties properties, KafkaClusterFactory factory) {
    var builder = ImmutableMap.<String, KafkaCluster>builder();

    WebClientConfigurator webClientConfigurator = new WebClientConfigurator().configureBaseUrl(properties.getGravitee().getManagementApiUrl());

    String token = properties.getGravitee().getManagementApiOrgAdminToken();
    if(token != null && !token.isBlank()) {
      webClientConfigurator.configureBearerAuthentication(token);
    } else {
      webClientConfigurator.configureBasicAuth(properties.getGravitee().getManagementApiOrgAdminUsername(),
          properties.getGravitee().getManagementApiOrgAdminPassword());
    }
    WebClient httpClient = webClientConfigurator.build();

    getKafkaClusters(httpClient, properties, factory).forEach(c -> builder.put(c.getName(), create(properties, factory, c)));
    this.kafkaClusters = builder.build();
  }

  public Collection<KafkaCluster> getKafkaClusters() {
    return kafkaClusters.values();
  }

  public Optional<KafkaCluster> getClusterByName(String clusterName) {
    return Optional.ofNullable(kafkaClusters.get(clusterName));
  }

  private List<Cluster> getKafkaClusters(WebClient httpClient, ClustersProperties properties, KafkaClusterFactory factory) {
    // Call Clusters resources
    return httpClient
        .get()
        .uri("/clusters")
        .retrieve()
        .bodyToMono(ClustersResponse.class)
        .flatMapIterable(ClustersResponse::getData)
        .collectList()
        .block();
  }

  private KafkaCluster create(ClustersProperties properties, KafkaClusterFactory factory, Cluster apimCluster) {
    ClustersProperties.Cluster cluster = new ClustersProperties.Cluster();
    cluster.setName(apimCluster.getName());
    cluster.setBootstrapServers(apimCluster.getConfiguration().getBootstrapServers());
    SecurityProtocol protocol = apimCluster.getConfiguration().getSecurity().getProtocol();
    if(protocol == SecurityProtocol.SASL_SSL || protocol == SecurityProtocol.SASL_PLAINTEXT) {
      SaslMechanism saslMechanism = apimCluster.getConfiguration().getSecurity().getSasl().getMechanism();
      Map<String, Object> saslConfig = createProperties(saslMechanism);
      saslConfig.put("security.protocol", protocol.name());
      saslConfig.put(SASL_MECHANISM, saslMechanism.getType().name());
      cluster.setProperties(saslConfig);
    }
    return factory.create(properties, cluster);
  }

  private static Map<String, Object> createProperties(SaslMechanism saslMechanism) {
    final Map<String, Object> config = new HashMap<>();

    if (saslMechanism == null) {
      return config;
    }

    switch (saslMechanism.getType()) {
      case AWS_MSK_IAM:
        config.put(SASL_JAAS_CONFIG, ((AwsMskIamSaslMechanism) saslMechanism).getSaslJaasConfig());
        break;
      case GSSAPI:
        config.put(SASL_JAAS_CONFIG, ((GsapiSaslMechanism) saslMechanism).getSaslJaasConfig());
        break;
      case OAUTHBEARER:
        config.put(SASL_LOGIN_CALLBACK_HANDLER_CLASS, OAuthBearerLoginCallbackHandler.class);
        OauthbearerSaslMechanism oauthBearerSaslMechanism = (OauthbearerSaslMechanism) saslMechanism;
        Map<String, String> jaasConfigMap = new HashMap<>(
            Map.of("clientId", oauthBearerSaslMechanism.getClientId(), "clientSecret", oauthBearerSaslMechanism.getClientSecret())
        );
        if (oauthBearerSaslMechanism.getScopes() != null && !oauthBearerSaslMechanism.getScopes().isEmpty()) {
          jaasConfigMap.put("scope", (oauthBearerSaslMechanism.getScopes()));
        }
        if (oauthBearerSaslMechanism.getSaslExtensions() != null) {
          oauthBearerSaslMechanism.getSaslExtensions().forEach((k, v) -> addExtensionToMap(k, v, jaasConfigMap));
        }
        config.put(SASL_JAAS_CONFIG, buildJaasConfig(OAuthBearerLoginModule.class, jaasConfigMap));
        config.put(SASL_OAUTHBEARER_TOKEN_ENDPOINT_URL, oauthBearerSaslMechanism.getTokenUrl());
        break;
      case OAUTHBEARER_TOKEN:
//        config.put(SASL_LOGIN_CALLBACK_HANDLER_CLASS, OauthbearerCustomTokenCallbackHandler.class);
//        config.put(
//            KAFKA_CHANNEL_CONFIG_GRAVITEE_OAUTHBEARER_CUSTOM_TOKEN,
//            ((OauthbearerTokenSaslMechanism) saslMechanism).getToken()
//        );
//        config.put(SASL_JAAS_CONFIG, buildJaasConfig(OAuthBearerLoginModule.class, Collections.emptyMap()));
        log.warn("OAuthBearerTokenSaslMechanism is not supported yet");
        break;
      case PLAIN:
        PlainSaslMechanism plainSaslMechanism = (PlainSaslMechanism) saslMechanism;
        config.put(
            SASL_JAAS_CONFIG,
            buildJaasConfig(
                PlainLoginModule.class,
                Map.of("username", plainSaslMechanism.getUsername(), "password", plainSaslMechanism.getPassword())
            )
        );
        break;
      case SCRAM_SHA_256:
        ScramSha256SaslMechanism scramSha256SaslMechanism = (ScramSha256SaslMechanism) saslMechanism;
        config.put(
            SASL_JAAS_CONFIG,
            buildJaasConfig(
                ScramLoginModule.class,
                Map.of("username", scramSha256SaslMechanism.getUsername(), "password", scramSha256SaslMechanism.getPassword())
            )
        );
        break;
      case SCRAM_SHA_512:
        ScramSha512SaslMechanism scramSha512SaslMechanism = (ScramSha512SaslMechanism) saslMechanism;
        config.put(
            SASL_JAAS_CONFIG,
            buildJaasConfig(
                ScramLoginModule.class,
                Map.of("username", scramSha512SaslMechanism.getUsername(), "password", scramSha512SaslMechanism.getPassword())
            )
        );
        break;
      case NONE:
      default:
        break;
    }

    return config;
  }

  private static void addExtensionToMap(String key, String value, Map<String, String> jaasConfigMap) {
    var sanitizedKey = key.startsWith("extension_") ? key.replace("extension_", "") : key;
    jaasConfigMap.put("extension_" + sanitizedKey, value);
  }

  private static String buildJaasConfig(Class<? extends LoginModule> loginModule, Map<String, String> properties) {
    StringBuilder builder = new StringBuilder(loginModule.getName()).append(" required");
    properties.forEach((key, value) -> builder.append(' ').append(key).append("=\"").append(value).append("\""));
    return builder.append(';').toString();
  }

}
