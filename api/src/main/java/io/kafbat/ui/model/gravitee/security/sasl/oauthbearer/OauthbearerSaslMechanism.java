package io.kafbat.ui.model.gravitee.security.sasl.oauthbearer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Map;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OauthbearerSaslMechanism extends SaslMechanism {

    public OauthbearerSaslMechanism() {
        super(SaslMechanismType.OAUTHBEARER);
    }

    private String tokenUrl;

    private String clientId;

    private String clientSecret;

    private String scopes;

    @JsonDeserialize(using = ExtensionsDeserializer.class)
    private Map<String, String> saslExtensions;
}
