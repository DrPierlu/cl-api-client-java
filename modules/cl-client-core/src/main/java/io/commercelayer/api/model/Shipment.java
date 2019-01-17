package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "shipments"
)
public class Shipment extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "_on_hold"
  )
  private Integer _onHold;

  @Json(
      name = "_picking"
  )
  private Integer _picking;

  @Json(
      name = "_packing"
  )
  private Integer _packing;

  @Json(
      name = "_ready_to_ship"
  )
  private Integer _readyToShip;

  @Json(
      name = "_ship"
  )
  private Integer _ship;

  @Json(
      name = "_get_rates"
  )
  private Integer _getRates;

  @Json(
      name = "selected_rate_id"
  )
  private String selectedRateId;

  @Json(
      name = "_purchase"
  )
  private Integer _purchase;

  private String status;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "cost_amount_cents"
  )
  private Integer costAmountCents;

  @Json(
      name = "cost_amount_float"
  )
  private Float costAmountFloat;

  @Json(
      name = "formatted_cost_amount"
  )
  private String formattedCostAmount;

  @Json(
      name = "shipping_method"
  )
  private HasOne<ShippingMethod> shippingMethod;

  @Json(
      name = "shipping_category"
  )
  private HasOne<ShippingCategory> shippingCategory;

  @Json(
      name = "stock_location"
  )
  private HasOne<StockLocation> stockLocation;

  @Json(
      name = "shipping_address"
  )
  private HasOne<Address> shippingAddress;

  @Json(
      name = "shipment_line_items"
  )
  private HasMany<LineItem> shipmentLineItems;

  @Json(
      name = "available_shipping_methods"
  )
  private HasMany<ShippingMethod> availableShippingMethods;

  private HasMany<Parcel> parcels;

  public Integer getOnHold_() {
    return this._onHold;
  }

  public void setOnHold_(Integer _onHold) {
    this._onHold = _onHold;
  }

  public Integer getPicking_() {
    return this._picking;
  }

  public void setPicking_(Integer _picking) {
    this._picking = _picking;
  }

  public Integer getPacking_() {
    return this._packing;
  }

  public void setPacking_(Integer _packing) {
    this._packing = _packing;
  }

  public Integer getReadyToShip_() {
    return this._readyToShip;
  }

  public void setReadyToShip_(Integer _readyToShip) {
    this._readyToShip = _readyToShip;
  }

  public Integer getShip_() {
    return this._ship;
  }

  public void setShip_(Integer _ship) {
    this._ship = _ship;
  }

  public Integer getGetRates_() {
    return this._getRates;
  }

  public void setGetRates_(Integer _getRates) {
    this._getRates = _getRates;
  }

  public String getSelectedRateId() {
    return this.selectedRateId;
  }

  public void setSelectedRateId(String selectedRateId) {
    this.selectedRateId = selectedRateId;
  }

  public Integer getPurchase_() {
    return this._purchase;
  }

  public void setPurchase_(Integer _purchase) {
    this._purchase = _purchase;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Integer getCostAmountCents() {
    return this.costAmountCents;
  }

  public void setCostAmountCents(Integer costAmountCents) {
    this.costAmountCents = costAmountCents;
  }

  public Float getCostAmountFloat() {
    return this.costAmountFloat;
  }

  public void setCostAmountFloat(Float costAmountFloat) {
    this.costAmountFloat = costAmountFloat;
  }

  public String getFormattedCostAmount() {
    return this.formattedCostAmount;
  }

  public void setFormattedCostAmount(String formattedCostAmount) {
    this.formattedCostAmount = formattedCostAmount;
  }

  public HasOne<ShippingMethod> getShippingMethod() {
    return this.shippingMethod;
  }

  public void setShippingMethod(HasOne<ShippingMethod> shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public ShippingMethod getShippingMethodResource() {
    return (ShippingMethod)getResource(getShippingMethod().get(getDocument()));
  }

  public void setShippingMethodResource(ShippingMethod shippingMethod) {
    setShippingMethod(new HasOne<ShippingMethod>(shippingMethod));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingMethodLinksMap() {
    return (Map<String, String>)getShippingMethod().getLinks().get(new CLLinksAdapter());
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

  public HasOne<StockLocation> getStockLocation() {
    return this.stockLocation;
  }

  public void setStockLocation(HasOne<StockLocation> stockLocation) {
    this.stockLocation = stockLocation;
  }

  public StockLocation getStockLocationResource() {
    return (StockLocation)getResource(getStockLocation().get(getDocument()));
  }

  public void setStockLocationResource(StockLocation stockLocation) {
    setStockLocation(new HasOne<StockLocation>(stockLocation));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockLocationLinksMap() {
    return (Map<String, String>)getStockLocation().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Address> getShippingAddress() {
    return this.shippingAddress;
  }

  public void setShippingAddress(HasOne<Address> shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Address getShippingAddressResource() {
    return (Address)getResource(getShippingAddress().get(getDocument()));
  }

  public void setShippingAddressResource(Address shippingAddress) {
    setShippingAddress(new HasOne<Address>(shippingAddress));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingAddressLinksMap() {
    return (Map<String, String>)getShippingAddress().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<LineItem> getShipmentLineItems() {
    return this.shipmentLineItems;
  }

  public void setShipmentLineItems(HasMany<LineItem> shipmentLineItems) {
    this.shipmentLineItems = shipmentLineItems;
  }

  @SuppressWarnings("unchecked")
  public List<LineItem> getShipmentLineItemResourceList() {
    return (List<LineItem>)getResource(getShipmentLineItems().get(getDocument()));
  }

  public void setShipmentLineItemResourceList(List<LineItem> shipmentLineItems) {
    setShipmentLineItems(new HasMany<LineItem>(shipmentLineItems.toArray(new LineItem[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShipmentLineItemsLinksMap() {
    return (Map<String, String>)getShipmentLineItems().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<ShippingMethod> getAvailableShippingMethods() {
    return this.availableShippingMethods;
  }

  public void setAvailableShippingMethods(HasMany<ShippingMethod> availableShippingMethods) {
    this.availableShippingMethods = availableShippingMethods;
  }

  @SuppressWarnings("unchecked")
  public List<ShippingMethod> getAvailableShippingMethodResourceList() {
    return (List<ShippingMethod>)getResource(getAvailableShippingMethods().get(getDocument()));
  }

  public void setAvailableShippingMethodResourceList(
      List<ShippingMethod> availableShippingMethods) {
    setAvailableShippingMethods(new HasMany<ShippingMethod>(availableShippingMethods.toArray(new ShippingMethod[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getAvailableShippingMethodsLinksMap() {
    return (Map<String, String>)getAvailableShippingMethods().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<Parcel> getParcels() {
    return this.parcels;
  }

  public void setParcels(HasMany<Parcel> parcels) {
    this.parcels = parcels;
  }

  @SuppressWarnings("unchecked")
  public List<Parcel> getParcelResourceList() {
    return (List<Parcel>)getResource(getParcels().get(getDocument()));
  }

  public void setParcelResourceList(List<Parcel> parcels) {
    setParcels(new HasMany<Parcel>(parcels.toArray(new Parcel[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getParcelsLinksMap() {
    return (Map<String, String>)getParcels().getLinks().get(new CLLinksAdapter());
  }
}
