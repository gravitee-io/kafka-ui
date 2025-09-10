package io.kafbat.ui.model.gravitee.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Security {

    /**
     * This attributes defines the security protocol.
     */
    @Builder.Default
    private SecurityProtocol protocol = SecurityProtocol.PLAINTEXT;
    private Sasl sasl;
    private io.kafbat.ui.model.gravitee.security.ssl.SslOptions ssl;

    @Data
    public static class Sasl {

        /**
         * This attributes defines the authentication mechanism when SASL is enabled.
         */
        private io.kafbat.ui.model.gravitee.security.sasl.SaslMechanism mechanism;
    }
}
