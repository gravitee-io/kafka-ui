package io.kafbat.ui.model.gravitee;

import io.kafbat.ui.model.gravitee.security.Security;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterConfiguration {
  private String bootstrapServers;
  private Security security;
}
