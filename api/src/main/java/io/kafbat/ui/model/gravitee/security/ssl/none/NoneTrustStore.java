package io.kafbat.ui.model.gravitee.security.ssl.none;

import io.kafbat.ui.model.gravitee.security.ssl.TrustStore;
import io.kafbat.ui.model.gravitee.security.ssl.TrustStoreType;
import java.io.Serial;
import lombok.Builder;

@Builder
public class NoneTrustStore extends TrustStore {

  @Serial
  private static final long serialVersionUID = -6013813999148592319L;

  public NoneTrustStore() {
    super(TrustStoreType.NONE);
  }
}
