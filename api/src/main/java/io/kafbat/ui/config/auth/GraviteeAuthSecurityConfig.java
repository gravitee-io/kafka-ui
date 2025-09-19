package io.kafbat.ui.config.auth;

import io.kafbat.ui.config.JwtTokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManagerAdapter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import java.util.List;

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
