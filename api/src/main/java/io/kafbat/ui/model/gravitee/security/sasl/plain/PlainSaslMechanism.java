package io.kafbat.ui.model.gravitee.security.sasl.plain;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlainSaslMechanism extends SaslMechanism {

  public PlainSaslMechanism() {
    super(SaslMechanismType.PLAIN);
  }

  private String username;

  private String password;
}
