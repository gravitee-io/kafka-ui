package io.kafbat.ui.model.gravitee.security.sasl.scramsha256;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScramSha256SaslMechanism extends SaslMechanism {

    public ScramSha256SaslMechanism() {
        super(SaslMechanismType.SCRAM_SHA_256);
    }

    private String username;

    private String password;
}
