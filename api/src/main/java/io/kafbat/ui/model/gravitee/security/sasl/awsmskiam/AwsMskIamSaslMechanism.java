package io.kafbat.ui.model.gravitee.security.sasl.awsmskiam;

import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism;
import io.kafbat.ui.model.gravitee.security.sasl.SaslMechanismType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AwsMskIamSaslMechanism extends SaslMechanism {

  public AwsMskIamSaslMechanism() {
    super(SaslMechanismType.AWS_MSK_IAM);
  }

  private String saslJaasConfig;
}
