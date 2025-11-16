package io.kafbat.ui.model.gravitee.security.ssl.pkcs12;

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
public class Pkcs12TrustStore extends TrustStore {

  @Serial
  private static final long serialVersionUID = 3915578060196536545L;

  private String path;

  private String content;

  private String password;

  private String alias;

  public Pkcs12TrustStore() {
    super(TrustStoreType.PKCS12);
  }

  public Pkcs12TrustStore(String path, String content, String password, String alias) {
    super(TrustStoreType.PKCS12);
    this.path = path;
    this.content = content;
    this.password = password;
    this.alias = alias;
  }
}
