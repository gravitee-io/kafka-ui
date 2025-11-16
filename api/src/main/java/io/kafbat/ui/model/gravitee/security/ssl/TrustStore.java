package io.kafbat.ui.model.gravitee.security.ssl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.kafbat.ui.model.gravitee.security.ssl.jks.JksTrustStore;
import io.kafbat.ui.model.gravitee.security.ssl.none.NoneTrustStore;
import io.kafbat.ui.model.gravitee.security.ssl.pem.PemTrustStore;
import io.kafbat.ui.model.gravitee.security.ssl.pkcs12.Pkcs12TrustStore;
import java.io.Serial;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    defaultImpl = NoneTrustStore.class
)
@JsonSubTypes(
    {
        @JsonSubTypes.Type(names = { "JKS", "jks" }, value = JksTrustStore.class),
        @JsonSubTypes.Type(names = { "PEM", "pem" }, value = PemTrustStore.class),
        @JsonSubTypes.Type(names = { "PKCS12", "pkcs12" }, value = Pkcs12TrustStore.class),
        @JsonSubTypes.Type(names = { "NONE", "none" }, value = NoneTrustStore.class),
    }
)
@Getter
@EqualsAndHashCode
public abstract class TrustStore implements Serializable {
  @Serial
  private static final long serialVersionUID = -9209765483153309314L;

  private final TrustStoreType type;

  public TrustStore(TrustStoreType type) {
    this.type = type;
  }
}
