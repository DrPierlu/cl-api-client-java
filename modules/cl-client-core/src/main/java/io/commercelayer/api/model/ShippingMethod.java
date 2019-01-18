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
    type = "shipping_methods"
)
public class ShippingMethod extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Market.class, ShippingZone.class, ShippingCategory.class, DeliveryLeadTime.class));

  private String name;

  @Json(
      name = "price_amount_cents"
  )
  private Integer priceAmountCents;

  @Json(
      name = "free_over_amount_cents"
  )
  private Integer freeOverAmountCents;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "price_amount_float"
  )
  private Float priceAmountFloat;

  @Json(
      name = "formatted_price_amount"
  )
  private String formattedPriceAmount;

  @Json(
      name = "free_over_amount_float"
  )
  private Float freeOverAmountFloat;

  @Json(
      name = "formatted_free_over_amount"
  )
  private String formattedFreeOverAmount;

  @Json(
      name = "price_amount_for_shipment_cents"
  )
  private Integer priceAmountForShipmentCents;

  @Json(
      name = "price_amount_for_shipment_float"
  )
  private Float priceAmountForShipmentFloat;

  @Json(
      name = "formatted_price_amount_for_shipment"
  )
  private String formattedPriceAmountForShipment;

  private HasOne<Market> market;

  @Json(
      name = "shipping_zone"
  )
  private HasOne<ShippingZone> shippingZone;

  @Json(
      name = "shipping_category"
  )
  private HasOne<ShippingCategory> shippingCategory;

  @Json(
      name = "delivery_lead_time_for_shipment"
  )
  private HasOne<DeliveryLeadTime> deliveryLeadTimeForShipment;

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

  public Integer getFreeOverAmountCents() {
    return this.freeOverAmountCents;
  }

  public void setFreeOverAmountCents(Integer freeOverAmountCents) {
    this.freeOverAmountCents = freeOverAmountCents;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
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

  public Float getFreeOverAmountFloat() {
    return this.freeOverAmountFloat;
  }

  public void setFreeOverAmountFloat(Float freeOverAmountFloat) {
    this.freeOverAmountFloat = freeOverAmountFloat;
  }

  public String getFormattedFreeOverAmount() {
    return this.formattedFreeOverAmount;
  }

  public void setFormattedFreeOverAmount(String formattedFreeOverAmount) {
    this.formattedFreeOverAmount = formattedFreeOverAmount;
  }

  public Integer getPriceAmountForShipmentCents() {
    return this.priceAmountForShipmentCents;
  }

  public void setPriceAmountForShipmentCents(Integer priceAmountForShipmentCents) {
    this.priceAmountForShipmentCents = priceAmountForShipmentCents;
  }

  public Float getPriceAmountForShipmentFloat() {
    return this.priceAmountForShipmentFloat;
  }

  public void setPriceAmountForShipmentFloat(Float priceAmountForShipmentFloat) {
    this.priceAmountForShipmentFloat = priceAmountForShipmentFloat;
  }

  public String getFormattedPriceAmountForShipment() {
    return this.formattedPriceAmountForShipment;
  }

  public void setFormattedPriceAmountForShipment(String formattedPriceAmountForShipment) {
    this.formattedPriceAmountForShipment = formattedPriceAmountForShipment;
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

  public HasOne<ShippingZone> getShippingZone() {
    return this.shippingZone;
  }

  public void setShippingZone(HasOne<ShippingZone> shippingZone) {
    this.shippingZone = shippingZone;
  }

  public ShippingZone getShippingZoneResource() {
    return (ShippingZone)getResource(getShippingZone().get(getDocument()));
  }

  public void setShippingZoneResource(ShippingZone shippingZone) {
    setShippingZone(new HasOne<ShippingZone>(shippingZone));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingZoneLinksMap() {
    return (Map<String, String>)getShippingZone().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<ShippingCategory> getShippingCategory() {
    return this.shippingCategory;
  }

  public void setShippingCategory(HasOne<ShippingCategory> shippingCategory) {
    this.shippingCategory = shippingCategory;
  }

  public ShippingCategory getShippingCategoryResource() {
    return (ShippingCategory)getResource(getShippingCategory().get(getDocument()));
  }

  public void setShippingCategoryResource(ShippingCategory shippingCategory) {
    setShippingCategory(new HasOne<ShippingCategory>(shippingCategory));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingCategoryLinksMap() {
    return (Map<String, String>)getShippingCategory().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<DeliveryLeadTime> getDeliveryLeadTimeForShipment() {
    return this.deliveryLeadTimeForShipment;
  }

  public void setDeliveryLeadTimeForShipment(HasOne<DeliveryLeadTime> deliveryLeadTimeForShipment) {
    this.deliveryLeadTimeForShipment = deliveryLeadTimeForShipment;
  }

  public DeliveryLeadTime getDeliveryLeadTimeForShipmentResource() {
    return (DeliveryLeadTime)getResource(getDeliveryLeadTimeForShipment().get(getDocument()));
  }

  public void setDeliveryLeadTimeForShipmentResource(DeliveryLeadTime deliveryLeadTimeForShipment) {
    setDeliveryLeadTimeForShipment(new HasOne<DeliveryLeadTime>(deliveryLeadTimeForShipment));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getDeliveryLeadTimeForShipmentLinksMap() {
    return (Map<String, String>)getDeliveryLeadTimeForShipment().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String MARKET = "market";

    String SHIPPING_ZONE = "shipping_zone";

    String SHIPPING_CATEGORY = "shipping_category";

    String DELIVERY_LEAD_TIME_FOR_SHIPMENT = "delivery_lead_time_for_shipment";
  }
}
