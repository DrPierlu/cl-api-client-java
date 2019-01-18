package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "line_items"
)
public class LineItem extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Order.class, Item.class, LineItemOption.class));

  @Json(
      name = "sku_code"
  )
  private String skuCode;

  private Integer quantity;

  @Json(
      name = "_update_quantity"
  )
  private Integer _updateQuantity;

  private String name;

  @Json(
      name = "image_url"
  )
  private String imageUrl;

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
  private Float unitAmountFloat;

  @Json(
      name = "formatted_unit_amount"
  )
  private String formattedUnitAmount;

  @Json(
      name = "options_amount_cents"
  )
  private Integer optionsAmountCents;

  @Json(
      name = "options_amount_float"
  )
  private Float optionsAmountFloat;

  @Json(
      name = "formatted_options_amount"
  )
  private String formattedOptionsAmount;

  @Json(
      name = "total_amount_cents"
  )
  private Integer totalAmountCents;

  @Json(
      name = "total_amount_float"
  )
  private Float totalAmountFloat;

  @Json(
      name = "formatted_total_amount"
  )
  private String formattedTotalAmount;

  @Json(
      name = "tax_rate"
  )
  private Float taxRate;

  @Json(
      name = "tax_breakdown"
  )
  private Object taxBreakdown;

  @Json(
      name = "item_type"
  )
  private String itemType;

  private HasOne<Order> order;

  private HasOne<Item> item;

  @Json(
      name = "line_item_options"
  )
  private HasMany<LineItemOption> lineItemOptions;

  public String getSkuCode() {
    return this.skuCode;
  }

  public void setSkuCode(String skuCode) {
    this.skuCode = skuCode;
  }

  public Integer getQuantity() {
    return this.quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getUpdateQuantity_() {
    return this._updateQuantity;
  }

  public void setUpdateQuantity_(Integer _updateQuantity) {
    this._updateQuantity = _updateQuantity;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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

  public Float getUnitAmountFloat() {
    return this.unitAmountFloat;
  }

  public void setUnitAmountFloat(Float unitAmountFloat) {
    this.unitAmountFloat = unitAmountFloat;
  }

  public String getFormattedUnitAmount() {
    return this.formattedUnitAmount;
  }

  public void setFormattedUnitAmount(String formattedUnitAmount) {
    this.formattedUnitAmount = formattedUnitAmount;
  }

  public Integer getOptionsAmountCents() {
    return this.optionsAmountCents;
  }

  public void setOptionsAmountCents(Integer optionsAmountCents) {
    this.optionsAmountCents = optionsAmountCents;
  }

  public Float getOptionsAmountFloat() {
    return this.optionsAmountFloat;
  }

  public void setOptionsAmountFloat(Float optionsAmountFloat) {
    this.optionsAmountFloat = optionsAmountFloat;
  }

  public String getFormattedOptionsAmount() {
    return this.formattedOptionsAmount;
  }

  public void setFormattedOptionsAmount(String formattedOptionsAmount) {
    this.formattedOptionsAmount = formattedOptionsAmount;
  }

  public Integer getTotalAmountCents() {
    return this.totalAmountCents;
  }

  public void setTotalAmountCents(Integer totalAmountCents) {
    this.totalAmountCents = totalAmountCents;
  }

  public Float getTotalAmountFloat() {
    return this.totalAmountFloat;
  }

  public void setTotalAmountFloat(Float totalAmountFloat) {
    this.totalAmountFloat = totalAmountFloat;
  }

  public String getFormattedTotalAmount() {
    return this.formattedTotalAmount;
  }

  public void setFormattedTotalAmount(String formattedTotalAmount) {
    this.formattedTotalAmount = formattedTotalAmount;
  }

  public Float getTaxRate() {
    return this.taxRate;
  }

  public void setTaxRate(Float taxRate) {
    this.taxRate = taxRate;
  }

  public Object getTaxBreakdown() {
    return this.taxBreakdown;
  }

  public void setTaxBreakdown(Object taxBreakdown) {
    this.taxBreakdown = taxBreakdown;
  }

  public String getItemType() {
    return this.itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public HasOne<Order> getOrder() {
    return this.order;
  }

  public void setOrder(HasOne<Order> order) {
    this.order = order;
  }

  public Order getOrderResource() {
    return (Order)getResource(getOrder().get(getDocument()));
  }

  public void setOrderResource(Order order) {
    setOrder(new HasOne<Order>(order));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getOrderLinksMap() {
    return (Map<String, String>)getOrder().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Item> getItem() {
    return this.item;
  }

  public void setItem(HasOne<Item> item) {
    this.item = item;
  }

  public Item getItemResource() {
    return (Item)getResource(getItem().get(getDocument()));
  }

  public void setItemResource(Item item) {
    setItem(new HasOne<Item>(item));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getItemLinksMap() {
    return (Map<String, String>)getItem().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<LineItemOption> getLineItemOptions() {
    return this.lineItemOptions;
  }

  public void setLineItemOptions(HasMany<LineItemOption> lineItemOptions) {
    this.lineItemOptions = lineItemOptions;
  }

  @SuppressWarnings("unchecked")
  public List<LineItemOption> getLineItemOptionResourceList() {
    return (List<LineItemOption>)getResource(getLineItemOptions().get(getDocument()));
  }

  public void setLineItemOptionResourceList(List<LineItemOption> lineItemOptions) {
    setLineItemOptions(new HasMany<LineItemOption>(lineItemOptions.toArray(new LineItemOption[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getLineItemOptionsLinksMap() {
    return (Map<String, String>)getLineItemOptions().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String ORDER = "order";

    String ITEM = "item";

    String LINE_ITEM_OPTIONS = "line_item_options";
  }
}
