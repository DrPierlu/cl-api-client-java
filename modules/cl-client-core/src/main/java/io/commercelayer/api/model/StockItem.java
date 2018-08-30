package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "stock_items"
)
public class StockItem extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "sku_code"
  )
  private String skuCode;

  private Integer quantity;

  @Json(
      name = "stock_location"
  )
  private HasOne<StockLocation> stockLocation;

  private HasOne<Sku> sku;

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

  public HasOne<Sku> getSku() {
    return this.sku;
  }

  public void setSku(HasOne<Sku> sku) {
    this.sku = sku;
  }

  public Sku getSkuResource() {
    return getSku().get(getDocument());
  }

  public void setSkuResource(Sku sku) {
    setSku(new HasOne<Sku>(sku));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getSkuLinksMap() {
    return (Map<String, String>)getSku().getLinks().get(new CLLinksAdapter());
  }
}
