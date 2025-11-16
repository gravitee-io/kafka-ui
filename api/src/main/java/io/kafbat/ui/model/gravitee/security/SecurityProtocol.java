package io.kafbat.ui.model.gravitee.security;

public enum SecurityProtocol {
  /**
   * No authentication no encryption.
   */
  PLAINTEXT,
  /**
   * SASL authentication with no TLS.
   */
  SASL_PLAINTEXT,
  /**
   * SASL authentication with TLS/SSL encryption.
   */
  SASL_SSL,
  /**
   * SSL for both encryption and authentication without SASL.
   */
  SSL,
}
