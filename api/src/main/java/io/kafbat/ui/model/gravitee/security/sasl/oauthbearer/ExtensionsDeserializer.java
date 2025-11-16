package io.kafbat.ui.model.gravitee.security.sasl.oauthbearer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExtensionsDeserializer extends JsonDeserializer<Map<String, String>> {

  @Override
  public Map<String, String> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
    HashMap<String, String> ret = new HashMap<String, String>();

    ObjectCodec codec = parser.getCodec();
    TreeNode node = codec.readTree(parser);

    if (node.isArray()) {
      for (JsonNode n : (ArrayNode) node) {
        JsonNode id = n.get("extensionKey");
        if (id != null) {
          JsonNode name = n.get("extensionValue");
          ret.put(id.asText(), name.asText());
        }
      }
    }
    return ret;
  }
}
