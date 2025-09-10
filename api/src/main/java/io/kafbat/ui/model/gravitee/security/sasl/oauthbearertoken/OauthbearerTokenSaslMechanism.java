package io.kafbat.ui.model.gravitee.security.sasl.oauthbearertoken;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OauthbearerTokenSaslMechanism extends SaslMechanism {

    public OauthbearerTokenSaslMechanism() {
        super(SaslMechanismType.OAUTHBEARER_TOKEN);
    }

    private String token;
}
