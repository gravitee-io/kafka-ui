package io.kafbat.ui.model.gravitee;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;


@JsonPropertyOrder({
  Pagination.JSON_PROPERTY_PAGE,
  Pagination.JSON_PROPERTY_PER_PAGE,
  Pagination.JSON_PROPERTY_PAGE_COUNT,
  Pagination.JSON_PROPERTY_PAGE_ITEMS_COUNT,
  Pagination.JSON_PROPERTY_TOTAL_COUNT
})
public class Pagination {
  public static final String JSON_PROPERTY_PAGE = "page";
  @jakarta.annotation.Nullable
  private Integer page;

  public static final String JSON_PROPERTY_PER_PAGE = "perPage";
  @jakarta.annotation.Nullable
  private Integer perPage;

  public static final String JSON_PROPERTY_PAGE_COUNT = "pageCount";
  @jakarta.annotation.Nullable
  private Integer pageCount;

  public static final String JSON_PROPERTY_PAGE_ITEMS_COUNT = "pageItemsCount";
  @jakarta.annotation.Nullable
  private Integer pageItemsCount;

  public static final String JSON_PROPERTY_TOTAL_COUNT = "totalCount";
  @jakarta.annotation.Nullable
  private Long totalCount;

  public Pagination() {
  }

  public Pagination page(@jakarta.annotation.Nullable Integer page) {
    this.page = page;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPage() {
    return page;
  }


  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPage(@jakarta.annotation.Nullable Integer page) {
    this.page = page;
  }


  public Pagination perPage(@jakarta.annotation.Nullable Integer perPage) {
    this.perPage = perPage;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPerPage() {
    return perPage;
  }


  @JsonProperty(JSON_PROPERTY_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPerPage(@jakarta.annotation.Nullable Integer perPage) {
    this.perPage = perPage;
  }


  public Pagination pageCount(@jakarta.annotation.Nullable Integer pageCount) {
    this.pageCount = pageCount;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPageCount() {
    return pageCount;
  }


  @JsonProperty(JSON_PROPERTY_PAGE_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageCount(@jakarta.annotation.Nullable Integer pageCount) {
    this.pageCount = pageCount;
  }


  public Pagination pageItemsCount(@jakarta.annotation.Nullable Integer pageItemsCount) {
    this.pageItemsCount = pageItemsCount;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PAGE_ITEMS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPageItemsCount() {
    return pageItemsCount;
  }


  @JsonProperty(JSON_PROPERTY_PAGE_ITEMS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPageItemsCount(@jakarta.annotation.Nullable Integer pageItemsCount) {
    this.pageItemsCount = pageItemsCount;
  }


  public Pagination totalCount(@jakarta.annotation.Nullable Long totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_TOTAL_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTotalCount() {
    return totalCount;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTotalCount(@jakarta.annotation.Nullable Long totalCount) {
    this.totalCount = totalCount;
  }


  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagination pagination = (Pagination) o;
    return Objects.equals(this.page, pagination.page)
        && Objects.equals(this.perPage, pagination.perPage)
        && Objects.equals(this.pageCount, pagination.pageCount)
        && Objects.equals(this.pageItemsCount, pagination.pageItemsCount)
        && Objects.equals(this.totalCount, pagination.totalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, perPage, pageCount, pageItemsCount, totalCount);
  }

  @Override
  public String toString() {
    return "class Pagination {\n"
        + "    page: " + toIndentedString(page) + "\n"
        + "    perPage: " + toIndentedString(perPage) + "\n"
        + "    pageCount: " + toIndentedString(pageCount) + "\n"
        + "    pageItemsCount: " + toIndentedString(pageItemsCount) + "\n"
        + "    totalCount: " + toIndentedString(totalCount) + "\n"
        + "}";
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

