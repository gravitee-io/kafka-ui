package io.kafbat.ui.model.gravitee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;


@JsonPropertyOrder({
    Links.JSON_PROPERTY_SELF,
    Links.JSON_PROPERTY_FIRST,
    Links.JSON_PROPERTY_LAST,
    Links.JSON_PROPERTY_PREVIOUS,
    Links.JSON_PROPERTY_NEXT
})
public class Links {
  public static final String JSON_PROPERTY_SELF = "self";
  public static final String JSON_PROPERTY_FIRST = "first";
  public static final String JSON_PROPERTY_LAST = "last";
  public static final String JSON_PROPERTY_PREVIOUS = "previous";
  public static final String JSON_PROPERTY_NEXT = "next";
  @jakarta.annotation.Nullable
  private String self;
  @jakarta.annotation.Nullable
  private String first;
  @jakarta.annotation.Nullable
  private String last;
  @jakarta.annotation.Nullable
  private String previous;
  @jakarta.annotation.Nullable
  private String next;

  public Links() {
  }

  public Links self(@jakarta.annotation.Nullable String self) {
    this.self = self;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }


  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSelf(@jakarta.annotation.Nullable String self) {
    this.self = self;
  }


  public Links first(@jakarta.annotation.Nullable String first) {
    this.first = first;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFirst() {
    return first;
  }


  @JsonProperty(JSON_PROPERTY_FIRST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirst(@jakarta.annotation.Nullable String first) {
    this.first = first;
  }


  public Links last(@jakarta.annotation.Nullable String last) {
    this.last = last;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLast() {
    return last;
  }


  @JsonProperty(JSON_PROPERTY_LAST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLast(@jakarta.annotation.Nullable String last) {
    this.last = last;
  }


  public Links previous(@jakarta.annotation.Nullable String previous) {
    this.previous = previous;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREVIOUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrevious() {
    return previous;
  }


  @JsonProperty(JSON_PROPERTY_PREVIOUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrevious(@jakarta.annotation.Nullable String previous) {
    this.previous = previous;
  }


  public Links next(@jakarta.annotation.Nullable String next) {
    this.next = next;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNext() {
    return next;
  }


  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNext(@jakarta.annotation.Nullable String next) {
    this.next = next;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Links links = (Links) o;
    return Objects.equals(this.self, links.self)
        && Objects.equals(this.first, links.first)
        && Objects.equals(this.last, links.last)
        && Objects.equals(this.previous, links.previous)
        && Objects.equals(this.next, links.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, last, previous, next);
  }

  @Override
  public String toString() {
    return "class Links {\n"
        + "    self: " + toIndentedString(self) + "\n"
        + "    first: " + toIndentedString(first) + "\n"
        + "    last: " + toIndentedString(last) + "\n"
        + "    previous: " + toIndentedString(previous) + "\n"
        + "    next: " + toIndentedString(next) + "\n"
        + "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

