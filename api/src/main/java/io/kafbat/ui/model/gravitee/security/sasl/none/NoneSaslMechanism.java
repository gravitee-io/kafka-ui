package io.kafbat.ui.model.gravitee.security.sasl.none;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoneSaslMechanism extends SaslMechanism {

    public NoneSaslMechanism() {
        super(SaslMechanismType.NONE);
    }
}
