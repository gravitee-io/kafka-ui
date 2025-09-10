package io.kafbat.ui.model.gravitee.security.sasl;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @see org.apache.kafka.common.config.SaslConfigs#SASL_MECHANISM
 * @see org.apache.kafka.common.config.SaslConfigs#SASL_MECHANISM_DOC
 *
 * @author GraviteeSource Team
 */
@RequiredArgsConstructor
@Getter
public enum SaslMechanismType {
    /**
     * No authentication is required.
     */
    NONE("NONE"),
    /**
     * The AWS_MSK_IAM mechanism enables the use of AWS IAM credentials for authentication.
     */
    AWS_MSK_IAM("AWS_MSK_IAM"),
    /**
     * SASL/GSSAPI is for organizations using Kerberos (for example, by using Active Directory).
     */
    GSSAPI("GSSAPI"),
    /**
     * The SASL/OAUTHBEARER mechanism enables the use of the framework in a SASL (i.e. a non-HTTP) context; it is defined in RFC 7628.
     */
    OAUTHBEARER("OAUTHBEARER"),
    /**
     * Provides custom token for OAUTHBEARER mechanism
     */
    OAUTHBEARER_TOKEN("OAUTHBEARER_TOKEN"),
    /**
     * A simple username/password authentication mechanism. Recommended over TLS/SSL encryption.
     */
    PLAIN("PLAIN"),
    /**
     * SASL/SCRAM is a family of SASL mechanisms that addresses the security concerns with traditional mechanisms that perform username/password authentication like PLAIN.
     */
    SCRAM_SHA_256("SCRAM-SHA-256"),
    /**
     * Same as SCRAM-SHA-256 but with an SHA-512 key
     */
    SCRAM_SHA_512("SCRAM-SHA-512");

    @JsonValue
    private final String value;
}
