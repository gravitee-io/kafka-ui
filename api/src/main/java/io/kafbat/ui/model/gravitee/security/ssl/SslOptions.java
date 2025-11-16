package io.kafbat.ui.model.gravitee.security.ssl;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SslOptions implements Serializable {
  @Serial
  private static final long serialVersionUID = 5578794192878572915L;

  private boolean trustAll;

  @Builder.Default
  private boolean hostnameVerifier = true;

  private TrustStore trustStore;

  private KeyStore keyStore;
}
