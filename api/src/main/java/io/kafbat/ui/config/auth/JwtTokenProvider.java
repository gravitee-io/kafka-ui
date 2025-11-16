package io.kafbat.ui.config.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import java.util.List;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class JwtTokenProvider {

  @Value("${auth.jwt.secret:myJWT4Gr4v1t33_S3cr3t}")
  private String secret;

  @SuppressWarnings("unchecked")
  public Authentication getAuthentication(String token) {
    Claims claims = extractAllClaims(token);
    String username = claims.getSubject();
    UserDetails userDetails = new RbacGraviteeUser(username, claims.get("clusters", List.class));

    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  public String getUsername(String token) {
    Claims claims = extractAllClaims(token);
    return claims.getSubject();
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parser()
        .verifyWith(getSignInKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  private SecretKey getSignInKey() {
    byte[] keyBytes = secret.getBytes();
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String resolveToken(ServerWebExchange exchange) {
    String bearer = exchange.getRequest().getHeaders().getFirst("Authorization");
    return (bearer != null && bearer.startsWith("Bearer ")) ? bearer.substring(7) : null;
  }

  public boolean validateToken(String token) {
    try {
      SecretKey key = getSignInKey();
      Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
      return true;
    } catch (SecurityException | MalformedJwtException e) {
      throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
    } catch (ExpiredJwtException e) {
      throw new AuthenticationCredentialsNotFoundException("Expired JWT token.");
    } catch (UnsupportedJwtException e) {
      throw new AuthenticationCredentialsNotFoundException("Unsupported JWT token.");
    } catch (IllegalArgumentException e) {
      throw new AuthenticationCredentialsNotFoundException("JWT token compact of handler are invalid.");
    }
  }
}
