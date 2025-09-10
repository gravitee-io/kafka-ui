package io.kafbat.ui.model.gravitee.security.sasl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.kafbat.ui.model.gravitee.security.sasl.awsmskiam.AwsMskIamSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.gsapi.GsapiSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.none.NoneSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.oauthbearer.OauthbearerSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.oauthbearertoken.OauthbearerTokenSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.plain.PlainSaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.scramsha256.ScramSha256SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.scramsha512.ScramSha512SaslMechanism;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    {
        @JsonSubTypes.Type(names = { "NONE" }, value = NoneSaslMechanism.class),
        @JsonSubTypes.Type(names = { "AWS_MSK_IAM" }, value = AwsMskIamSaslMechanism.class),
        @JsonSubTypes.Type(names = { "GSSAPI" }, value = GsapiSaslMechanism.class),
        @JsonSubTypes.Type(names = { "OAUTHBEARER" }, value = OauthbearerSaslMechanism.class),
        @JsonSubTypes.Type(names = { "OAUTHBEARER_TOKEN" }, value = OauthbearerTokenSaslMechanism.class),
        @JsonSubTypes.Type(names = { "PLAIN" }, value = PlainSaslMechanism.class),
        @JsonSubTypes.Type(names = { "SCRAM-SHA-256" }, value = ScramSha256SaslMechanism.class),
        @JsonSubTypes.Type(names = { "SCRAM-SHA-512" }, value = ScramSha512SaslMechanism.class),
    }
)
@Data
public abstract class SaslMechanism {

    protected SaslMechanismType type;

    protected SaslMechanism(SaslMechanismType type) {
        this.type = type;
    }
}
