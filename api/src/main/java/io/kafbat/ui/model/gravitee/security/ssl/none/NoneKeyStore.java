package io.kafbat.ui.model.gravitee.security.ssl.none;

import io.kafbat.ui.model.gravitee.security.ssl.KeyStore;
import io.kafbat.ui.model.gravitee.security.ssl.KeyStoreType;
import java.io.Serial;
import lombok.Builder;

@Builder
public class NoneKeyStore extends KeyStore {

  @Serial
  private static final long serialVersionUID = -2540354913966457704L;

  public NoneKeyStore() {
    super(KeyStoreType.NONE);
  }
}
