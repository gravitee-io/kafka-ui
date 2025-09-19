package io.kafbat.ui.config;

import java.io.IOException;

import io.kafbat.ui.config.auth.JwtTokenProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class JwtTokenFilter implements WebFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @NotNull
    @Override
    public Mono<Void> filter(@NotNull ServerWebExchange exchange, @NotNull WebFilterChain chain) {
        String token = jwtTokenProvider.resolveToken(exchange);

        if (token != null && jwtTokenProvider.validateToken(token)) {
          return chain.filter(exchange).contextWrite(ReactiveSecurityContextHolder.withAuthentication(jwtTokenProvider.getAuthentication(token)));
        }

        return chain.filter(exchange);
    }
}
