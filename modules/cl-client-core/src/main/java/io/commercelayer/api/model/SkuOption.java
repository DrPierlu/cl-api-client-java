package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "sku_options"
)
public class SkuOption extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Market.class));

  private String name;

  @Json(
      name = "price_amount_cents"
  )
  private Integer priceAmountCents;

  @Json(
      name = "delay_hours"
  )
  private Integer delayHours;

  @Json(
      name = "sku_code_regex"
  )
  private String skuCodeRegex;

  @Json(
      name = "price_amount_float"
  )
  private Float priceAmountFloat;

  @Json(
      name = "formatted_price_amount"
  )
  private String formattedPriceAmount;

  @Json(
      name = "delay_days"
  )
  private Integer delayDays;

  private HasOne<Market> market;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPriceAmountCents() {
    return this.priceAmountCents;
  }

  public void setPriceAmountCents(Integer priceAmountCents) {
    this.priceAmountCents = priceAmountCents;
  }

  public Integer getDelayHours() {
    return this.delayHours;
  }

  public void setDelayHours(Integer delayHours) {
    this.delayHours = delayHours;
  }

  public String getSkuCodeRegex() {
    return this.skuCodeRegex;
  }

  public void setSkuCodeRegex(String skuCodeRegex) {
    this.skuCodeRegex = skuCodeRegex;
  }

  public Float getPriceAmountFloat() {
    return this.priceAmountFloat;
  }

  public void setPriceAmountFloat(Float priceAmountFloat) {
    this.priceAmountFloat = priceAmountFloat;
  }

  public String getFormattedPriceAmount() {
    return this.formattedPriceAmount;
  }

  public void setFormattedPriceAmount(String formattedPriceAmount) {
    this.formattedPriceAmount = formattedPriceAmount;
  }

  public Integer getDelayDays() {
    return this.delayDays;
  }

  public void setDelayDays(Integer delayDays) {
    this.delayDays = delayDays;
  }

  public HasOne<Market> getMarket() {
    return this.market;
  }

  public void setMarket(HasOne<Market> market) {
    this.market = market;
  }

  public Market getMarketResource() {
    return (Market)getResource(getMarket().get(getDocument()));
  }

  public void setMarketResource(Market market) {
    setMarket(new HasOne<Market>(market));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getMarketLinksMap() {
    return (Map<String, String>)getMarket().getLinks().get(new CLLinksAdapter());
  }
}
