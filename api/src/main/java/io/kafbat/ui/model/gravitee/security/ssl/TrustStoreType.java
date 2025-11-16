package io.kafbat.ui.model.gravitee.security.ssl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum TrustStoreType {
  PEM,
  PKCS12,
  JKS,
  NONE;

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public static TrustStoreType forValues(@JsonProperty("type") String type) {
    if (type.isEmpty()) {
      return NONE;
    }
    return TrustStoreType.valueOf(type);
  }
}
