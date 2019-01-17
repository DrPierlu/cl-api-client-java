package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "price_lists"
)
public class PriceList extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Price.class));

  private String name;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "tax_included"
  )
  private Boolean taxIncluded;

  private HasMany<Price> prices;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Boolean getTaxIncluded() {
    return this.taxIncluded;
  }

  public void setTaxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
  }

  public HasMany<Price> getPrices() {
    return this.prices;
  }

  public void setPrices(HasMany<Price> prices) {
    this.prices = prices;
  }

  @SuppressWarnings("unchecked")
  public List<Price> getPriceResourceList() {
    return (List<Price>)getResource(getPrices().get(getDocument()));
  }

  public void setPriceResourceList(List<Price> prices) {
    setPrices(new HasMany<Price>(prices.toArray(new Price[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPricesLinksMap() {
    return (Map<String, String>)getPrices().getLinks().get(new CLLinksAdapter());
  }
}
