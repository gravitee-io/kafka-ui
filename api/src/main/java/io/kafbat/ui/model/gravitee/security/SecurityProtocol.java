package io.kafbat.ui.model.gravitee.security;

/**
 * @see org.apache.kafka.clients.CommonClientConfigs#SECURITY_PROTOCOL_CONFIG
 * @see org.apache.kafka.clients.CommonClientConfigs#SECURITY_PROTOCOL_DOC
 *
 * @author GraviteeSource Team
 */
public enum SecurityProtocol {
    /**
     * No authentication no encryption
     */
    PLAINTEXT,
    /**
     * SASL authentication with no TLS
     */
    SASL_PLAINTEXT,
    /**
     * SASL authentication with TLS/SSL encryption
     */
    SASL_SSL,
    /**
     * SSL for both encryption and authentication without SASL
     */
    SSL,
}
