package io.kafbat.ui.model.gravitee.security.ssl.pem;

import io.kafbat.ui.model.gravitee.security.ssl.TrustStore;
import io.kafbat.ui.model.gravitee.security.ssl.TrustStoreType;
import java.io.Serial;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
public class PemTrustStore extends TrustStore {

  @Serial
  private static final long serialVersionUID = 7432939542056493096L;

  private String path;

  private String content;

  public PemTrustStore() {
    super(TrustStoreType.PEM);
  }

  public PemTrustStore(String path, String content) {
    super(TrustStoreType.PEM);
    this.path = path;
    this.content = content;
  }
}
