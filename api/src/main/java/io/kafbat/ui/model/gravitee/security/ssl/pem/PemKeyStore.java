package io.kafbat.ui.model.gravitee.security.ssl.pem;

import io.kafbat.ui.model.gravitee.security.ssl.KeyStore;
import io.kafbat.ui.model.gravitee.security.ssl.KeyStoreType;
import java.io.Serial;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
public class PemKeyStore extends KeyStore {

  @Serial
  private static final long serialVersionUID = 1051430527272519608L;

  private String keyPath;

  private String keyContent;

  private String certPath;

  private String certContent;

  public PemKeyStore() {
    super(KeyStoreType.PEM);
  }

  public PemKeyStore(String keyPath, String keyContent, String certPath, String certContent) {
    super(KeyStoreType.PEM);
    this.keyPath = keyPath;
    this.keyContent = keyContent;
    this.certPath = certPath;
    this.certContent = certContent;
  }
}
