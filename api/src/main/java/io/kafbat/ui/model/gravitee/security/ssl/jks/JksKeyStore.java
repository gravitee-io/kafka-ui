package io.kafbat.ui.model.gravitee.security.ssl.jks;

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
public class JksKeyStore extends KeyStore {

  @Serial
  private static final long serialVersionUID = -4687804681763799542L;

  private String path;

  private String content;

  private String password;

  private String alias;

  private String keyPassword;

  public JksKeyStore() {
    super(KeyStoreType.JKS);
  }

  public JksKeyStore(String path, String content, String password, String alias, String keyPassword) {
    super(KeyStoreType.JKS);
    this.path = path;
    this.content = content;
    this.password = password;
    this.alias = alias;
    this.keyPassword = keyPassword;
  }
}
