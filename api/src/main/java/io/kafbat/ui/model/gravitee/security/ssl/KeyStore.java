package io.kafbat.ui.model.gravitee.security.ssl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.kafbat.ui.model.gravitee.security.ssl.jks.JksKeyStore;
import io.kafbat.ui.model.gravitee.security.ssl.none.NoneKeyStore;
import io.kafbat.ui.model.gravitee.security.ssl.pem.PemKeyStore;
import io.kafbat.ui.model.gravitee.security.ssl.pkcs12.Pkcs12KeyStore;
import java.io.Serial;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    defaultImpl = NoneKeyStore.class
)
@JsonSubTypes(
    {
        @JsonSubTypes.Type(names = { "JKS", "jks" }, value = JksKeyStore.class),
        @JsonSubTypes.Type(names = { "PEM", "pem" }, value = PemKeyStore.class),
        @JsonSubTypes.Type(names = { "PKCS12", "pkcs12" }, value = Pkcs12KeyStore.class),
        @JsonSubTypes.Type(names = { "NONE", "none" }, value = NoneKeyStore.class),
    }
)
@Getter
@EqualsAndHashCode
public abstract class KeyStore implements Serializable {

  @Serial
  private static final long serialVersionUID = -917896495926741784L;

  private final KeyStoreType type;

  protected KeyStore(KeyStoreType type) {
    this.type = type;
  }
}
