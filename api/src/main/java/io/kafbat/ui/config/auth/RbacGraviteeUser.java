package io.kafbat.ui.config.auth;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class RbacGraviteeUser implements UserDetails, RbacUser {
  private final ImmutableList<String> clusters;
  private final String username;

  public RbacGraviteeUser(String username, List<String> clusters) {
    this.username = username;
    this.clusters = ImmutableList.copyOf(clusters);
  }

  @Override
  public String name() {
    return "";
  }

  @Override
  public Collection<String> groups() {
    return List.of();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public String getPassword() {
    return "";
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public Collection<String> clusters() {
    return clusters;
  }
}
