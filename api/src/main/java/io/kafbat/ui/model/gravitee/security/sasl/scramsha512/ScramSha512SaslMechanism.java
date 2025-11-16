package io.kafbat.ui.model.gravitee.security.sasl.scramsha512;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScramSha512SaslMechanism extends SaslMechanism {

  public ScramSha512SaslMechanism() {
    super(SaslMechanismType.SCRAM_SHA_512);
  }

  private String username;

  private String password;
}
