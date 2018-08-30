package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "line_item_options"
)
public class LineItemOption extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  private Integer quantity;

  @Json(
      name = "delay_hours"
  )
  private Integer delayHours;

  private Object options;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "unit_amount_cents"
  )
  private Integer unitAmountCents;

  @Json(
      name = "unit_amount_float"
  )
  private Integer unitAmountFloat;

  @Json(
      name = "formatted_unit_amount"
  )
  private String formattedUnitAmount;

  @Json(
      name = "total_amount_cents"
  )
  private Integer totalAmountCents;

  @Json(
      name = "total_amount_float"
  )
  private Integer totalAmountFloat;

  @Json(
      name = "formatted_total_amount"
  )
  private String formattedTotalAmount;

  @Json(
      name = "delay_days"
  )
  private Integer delayDays;

  @Json(
      name = "line_item"
  )
  private HasOne<LineItem> lineItem;

  @Json(
      name = "sku_option"
  )
  private HasOne<SkuOption> skuOption;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getDelayHours() {
    return this.delayHours;
  }

  public void setDelayHours(Integer delayHours) {
    this.delayHours = delayHours;
  }

  public Object getOptions() {
    return this.options;
  }

  public void setOptions(Object options) {
    this.options = options;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Integer getUnitAmountCents() {
    return this.unitAmountCents;
  }

  public void setUnitAmountCents(Integer unitAmountCents) {
    this.unitAmountCents = unitAmountCents;
  }

  public Integer getUnitAmountFloat() {
    return this.unitAmountFloat;
  }

  public void setUnitAmountFloat(Integer unitAmountFloat) {
    this.unitAmountFloat = unitAmountFloat;
  }

  public String getFormattedUnitAmount() {
    return this.formattedUnitAmount;
  }

  public void setFormattedUnitAmount(String formattedUnitAmount) {
    this.formattedUnitAmount = formattedUnitAmount;
  }

  public Integer getTotalAmountCents() {
    return this.totalAmountCents;
  }

  public void setTotalAmountCents(Integer totalAmountCents) {
    this.totalAmountCents = totalAmountCents;
  }

  public Integer getTotalAmountFloat() {
    return this.totalAmountFloat;
  }

  public void setTotalAmountFloat(Integer totalAmountFloat) {
    this.totalAmountFloat = totalAmountFloat;
  }

  public String getFormattedTotalAmount() {
    return this.formattedTotalAmount;
  }

  public void setFormattedTotalAmount(String formattedTotalAmount) {
    this.formattedTotalAmount = formattedTotalAmount;
  }

  public Integer getDelayDays() {
    return this.delayDays;
  }

  public void setDelayDays(Integer delayDays) {
    this.delayDays = delayDays;
  }

  public HasOne<LineItem> getLineItem() {
    return this.lineItem;
  }

  public void setLineItem(HasOne<LineItem> lineItem) {
    this.lineItem = lineItem;
  }

  public LineItem getLineItemResource() {
    return getLineItem().get(getDocument());
  }

  public void setLineItemResource(LineItem lineItem) {
    setLineItem(new HasOne<LineItem>(lineItem));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getLineItemLinksMap() {
    return (Map<String, String>)getLineItem().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<SkuOption> getSkuOption() {
    return this.skuOption;
  }

  public void setSkuOption(HasOne<SkuOption> skuOption) {
    this.skuOption = skuOption;
  }

  public SkuOption getSkuOptionResource() {
    return getSkuOption().get(getDocument());
  }

  public void setSkuOptionResource(SkuOption skuOption) {
    setSkuOption(new HasOne<SkuOption>(skuOption));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getSkuOptionLinksMap() {
    return (Map<String, String>)getSkuOption().getLinks().get(new CLLinksAdapter());
  }
}
