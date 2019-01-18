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
    type = "prices"
)
public class Price extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(PriceList.class, Sku.class));

  @Json(
      name = "sku_code"
  )
  private String skuCode;

  @Json(
      name = "amount_cents"
  )
  private Integer amountCents;

  @Json(
      name = "compare_at_amount_cents"
  )
  private Integer compareAtAmountCents;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "amount_float"
  )
  private Float amountFloat;

  @Json(
      name = "formatted_amount"
  )
  private String formattedAmount;

  @Json(
      name = "compare_at_amount_float"
  )
  private Float compareAtAmountFloat;

  @Json(
      name = "formatted_compare_at_amount"
  )
  private String formattedCompareAtAmount;

  @Json(
      name = "price_list"
  )
  private HasOne<PriceList> priceList;

  private HasOne<Sku> sku;

  public String getSkuCode() {
    return this.skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
  }

  public Integer getAmountCents() {
    return this.amountCents;
  }

  public void setAmountCents(Integer amountCents) {
    this.amountCents = amountCents;
  }

  public Integer getCompareAtAmountCents() {
    return this.compareAtAmountCents;
  }

  public void setCompareAtAmountCents(Integer compareAtAmountCents) {
    this.compareAtAmountCents = compareAtAmountCents;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Float getAmountFloat() {
    return this.amountFloat;
  }

  public void setAmountFloat(Float amountFloat) {
    this.amountFloat = amountFloat;
  }

  public String getFormattedAmount() {
    return this.formattedAmount;
  }

  public void setFormattedAmount(String formattedAmount) {
    this.formattedAmount = formattedAmount;
  }

  public Float getCompareAtAmountFloat() {
    return this.compareAtAmountFloat;
  }

  public void setCompareAtAmountFloat(Float compareAtAmountFloat) {
    this.compareAtAmountFloat = compareAtAmountFloat;
  }

  public String getFormattedCompareAtAmount() {
    return this.formattedCompareAtAmount;
  }

  public void setFormattedCompareAtAmount(String formattedCompareAtAmount) {
    this.formattedCompareAtAmount = formattedCompareAtAmount;
  }

  public HasOne<PriceList> getPriceList() {
    return this.priceList;
  }

  public void setPriceList(HasOne<PriceList> priceList) {
    this.priceList = priceList;
  }

  public PriceList getPriceListResource() {
    return (PriceList)getResource(getPriceList().get(getDocument()));
  }

  public void setPriceListResource(PriceList priceList) {
    setPriceList(new HasOne<PriceList>(priceList));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPriceListLinksMap() {
    return (Map<String, String>)getPriceList().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Sku> getSku() {
    return this.sku;
  }

  public void setSku(HasOne<Sku> sku) {
    this.sku = sku;
  }

  public Sku getSkuResource() {
    return (Sku)getResource(getSku().get(getDocument()));
  }

  public void setSkuResource(Sku sku) {
    setSku(new HasOne<Sku>(sku));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getSkuLinksMap() {
    return (Map<String, String>)getSku().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String PRICE_LIST = "price_list";

    String SKU = "sku";
  }
}
