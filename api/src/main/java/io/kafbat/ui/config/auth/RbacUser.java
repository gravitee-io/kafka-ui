package io.kafbat.ui.config.auth;

import java.util.Collection;
import java.util.Collections;

public interface RbacUser {
  String name();

  Collection<String> groups();

  default Collection<String> clusters() {
    return Collections.emptyList();
  }
}
