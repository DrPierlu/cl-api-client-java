package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "stock_levels"
)
public class StockLevel extends ApiResource {
  public static final long serialVersionUID = -1;

  private Integer priority;

  @Json(
      name = "on_hold"
  )
  private Boolean onHold;

  @Json(
      name = "stock_location"
  )
  private HasOne<StockLocation> stockLocation;

  @Json(
      name = "inventory_model"
  )
  private HasOne<InventoryModel> inventoryModel;

  public Integer getPriority() {
    return this.priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Boolean getOnHold() {
    return this.onHold;
  }

  public void setOnHold(Boolean onHold) {
    this.onHold = onHold;
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

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockLocationLinksMap() {
    return (Map<String, String>)getStockLocation().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<InventoryModel> getInventoryModel() {
    return this.inventoryModel;
  }

  public void setInventoryModel(HasOne<InventoryModel> inventoryModel) {
    this.inventoryModel = inventoryModel;
  }

  public InventoryModel getInventoryModelResource() {
    return getInventoryModel().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getInventoryModelLinksMap() {
    return (Map<String, String>)getInventoryModel().getLinks().get(new CLLinksAdapter());
  }
}
