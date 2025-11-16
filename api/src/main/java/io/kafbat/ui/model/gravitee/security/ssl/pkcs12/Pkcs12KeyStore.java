package io.kafbat.ui.model.gravitee.security.ssl.pkcs12;

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
public class Pkcs12KeyStore extends KeyStore {

  @Serial
  private static final long serialVersionUID = 1210626721233767960L;

  private String path;

  private String content;

  private String password;

  private String alias;

  /**
   * For PKCS12, if specified,
   * it must be equals to password as the JDK doesn't support a key password different from the keystore password.
   */
  private String keyPassword;

  public Pkcs12KeyStore() {
    super(KeyStoreType.PKCS12);
  }

  public Pkcs12KeyStore(String path, String content, String password, String alias, String keyPassword) {
    super(KeyStoreType.PKCS12);
    this.path = path;
    this.content = content;
    this.password = password;
    this.alias = alias;
    this.keyPassword = keyPassword;
  }
}
