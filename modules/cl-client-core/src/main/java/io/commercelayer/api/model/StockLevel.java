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
    type = "stock_levels"
)
public class StockLevel extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(StockLocation.class, InventoryModel.class));

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
    return (StockLocation)getResource(getStockLocation().get(getDocument()));
  }

  public void setStockLocationResource(StockLocation stockLocation) {
    setStockLocation(new HasOne<StockLocation>(stockLocation));
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
    return (InventoryModel)getResource(getInventoryModel().get(getDocument()));
  }

  public void setInventoryModelResource(InventoryModel inventoryModel) {
    setInventoryModel(new HasOne<InventoryModel>(inventoryModel));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getInventoryModelLinksMap() {
    return (Map<String, String>)getInventoryModel().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String STOCK_LOCATION = "stock_location";

    String INVENTORY_MODEL = "inventory_model";
  }
}
