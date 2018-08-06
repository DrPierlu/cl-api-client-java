package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "stock_locations"
)
public class StockLocation extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  @Json(
      name = "label_format"
  )
  private String labelFormat;

  private HasOne<Address> address;

  @Json(
      name = "stock_levels"
  )
  private HasMany<StockLevel> stockLevels;

  @Json(
      name = "stock_items"
  )
  private HasMany<StockItem> stockItems;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLabelFormat() {
    return this.labelFormat;
  }

  public void setLabelFormat(String labelFormat) {
    this.labelFormat = labelFormat;
  }

  public HasOne<Address> getAddress() {
    return this.address;
  }

  public void setAddress(HasOne<Address> address) {
    this.address = address;
  }

  public Address getAddressResource() {
    return getAddress().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getAddressLinksMap() {
    return (Map<String, String>)getAddress().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<StockLevel> getStockLevels() {
    return this.stockLevels;
  }

  public void setStockLevels(HasMany<StockLevel> stockLevels) {
    this.stockLevels = stockLevels;
  }

  public List<StockLevel> getStockLevelResourceList() {
    return getStockLevels().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockLevelsLinksMap() {
    return (Map<String, String>)getStockLevels().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<StockItem> getStockItems() {
    return this.stockItems;
  }

  public void setStockItems(HasMany<StockItem> stockItems) {
    this.stockItems = stockItems;
  }

  public List<StockItem> getStockItemResourceList() {
    return getStockItems().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockItemsLinksMap() {
    return (Map<String, String>)getStockItems().getLinks().get(new CLLinksAdapter());
  }
}
