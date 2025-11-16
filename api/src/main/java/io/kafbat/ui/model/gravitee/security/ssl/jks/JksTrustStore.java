package io.kafbat.ui.model.gravitee.security.ssl.jks;

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
public class JksTrustStore extends TrustStore {

  @Serial
  private static final long serialVersionUID = -6603840868190194763L;

  private String path;

  private String content;

  private String password;

  private String alias;

  public JksTrustStore() {
    super(TrustStoreType.JKS);
  }

  public JksTrustStore(String path, String content, String password, String alias) {
    super(TrustStoreType.JKS);
    this.path = path;
    this.content = content;
    this.password = password;
    this.alias = alias;
  }
}
