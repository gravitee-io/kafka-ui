package io.kafbat.ui.config.auth;

import java.util.Collection;
import java.util.Collections;

public record AuthenticatedUser(String principal, Collection<String> groups, Collection<String> clusters) {
  public AuthenticatedUser(String principal, Collection<String> groups) {
    this(principal, groups, Collections.emptyList());
  }
}
