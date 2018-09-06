package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "delivery_lead_times"
)
public class DeliveryLeadTime extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "min_hours"
  )
  private Integer minHours;

  @Json(
      name = "max_hours"
  )
  private Integer maxHours;

  @Json(
      name = "min_days"
  )
  private Integer minDays;

  @Json(
      name = "max_days"
  )
  private Integer maxDays;

  @Json(
      name = "stock_location"
  )
  private HasOne<StockLocation> stockLocation;

  @Json(
      name = "shipping_method"
  )
  private HasOne<ShippingMethod> shippingMethod;

  public Integer getMinHours() {
    return this.minHours;
  }

  public void setMinHours(Integer minHours) {
    this.minHours = minHours;
  }

  public Integer getMaxHours() {
    return this.maxHours;
  }

  public void setMaxHours(Integer maxHours) {
    this.maxHours = maxHours;
  }

  public Integer getMinDays() {
    return this.minDays;
  }

  public void setMinDays(Integer minDays) {
    this.minDays = minDays;
  }

  public Integer getMaxDays() {
    return this.maxDays;
  }

  public void setMaxDays(Integer maxDays) {
    this.maxDays = maxDays;
  }

  public HasOne<StockLocation> getStockLocation() {
    return this.stockLocation;
  }

  public void setStockLocation(HasOne<StockLocation> stockLocation) {
    this.stockLocation = stockLocation;
  }

  public StockLocation getStockLocationResource() {
    return getStockLocation().get(getDocument());
  }

  public void setStockLocationResource(StockLocation stockLocation) {
    setStockLocation(new HasOne<StockLocation>(stockLocation));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockLocationLinksMap() {
    return (Map<String, String>)getStockLocation().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<ShippingMethod> getShippingMethod() {
    return this.shippingMethod;
  }

  public void setShippingMethod(HasOne<ShippingMethod> shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public ShippingMethod getShippingMethodResource() {
    return getShippingMethod().get(getDocument());
  }

  public void setShippingMethodResource(ShippingMethod shippingMethod) {
    setShippingMethod(new HasOne<ShippingMethod>(shippingMethod));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingMethodLinksMap() {
    return (Map<String, String>)getShippingMethod().getLinks().get(new CLLinksAdapter());
  }
}
