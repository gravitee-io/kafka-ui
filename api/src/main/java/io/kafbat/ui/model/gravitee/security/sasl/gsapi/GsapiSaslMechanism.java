package io.kafbat.ui.model.gravitee.security.sasl.gsapi;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GsapiSaslMechanism extends SaslMechanism {

  public GsapiSaslMechanism() {
    super(SaslMechanismType.GSSAPI);
  }

  private String saslJaasConfig;
}
