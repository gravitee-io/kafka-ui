package io.kafbat.ui.config.auth;

import io.kafbat.ui.config.JwtTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@ConditionalOnProperty(value = "auth.type", havingValue = "GRAVITEE")
@Slf4j
public class GraviteeAuthSecurityConfig extends AbstractAuthSecurityConfig {

  @Bean
  public SecurityWebFilterChain configure(ServerHttpSecurity http, JwtTokenProvider jwtTokenProvider) {
    log.info("Configuring GRAVITEE authentication.");

    var jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);

    var builder = http.authorizeExchange(spec -> spec
            .anyExchange()
            .permitAll()
        )
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .addFilterBefore(jwtTokenFilter, SecurityWebFiltersOrder.AUTHENTICATION);
    ;

    return builder.build();
  }

}
