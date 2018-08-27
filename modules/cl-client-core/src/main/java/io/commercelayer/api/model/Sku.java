package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "skus"
)
public class Sku extends ApiResource {
  public static final long serialVersionUID = -1;

  private String code;

  private String name;

  private String description;

  @Json(
      name = "image_url"
  )
  private String imageUrl;

  @Json(
      name = "tag_names"
  )
  private String tagNames;

  @Json(
      name = "pieces_per_pack"
  )
  private Integer piecesPerPack;

  private Integer weight;

  @Json(
      name = "unit_of_weight"
  )
  private String unitOfWeight;

  @Json(
      name = "shipping_category"
  )
  private HasOne<ShippingCategory> shippingCategory;

  private HasMany<Price> prices;

  @Json(
      name = "stock_items"
  )
  private HasMany<StockItem> stockItems;

  @Json(
      name = "delivery_lead_times"
  )
  private HasMany<DeliveryLeadTime> deliveryLeadTimes;

  @Json(
      name = "sku_options"
  )
  private HasMany<SkuOption> skuOptions;

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getTagNames() {
    return this.tagNames;
  }

  public void setTagNames(String tagNames) {
    this.tagNames = tagNames;
  }

  public Integer getPiecesPerPack() {
    return this.piecesPerPack;
  }

  public void setPiecesPerPack(Integer piecesPerPack) {
    this.piecesPerPack = piecesPerPack;
  }

  public Integer getWeight() {
    return this.weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getUnitOfWeight() {
    return this.unitOfWeight;
  }

  public void setUnitOfWeight(String unitOfWeight) {
    this.unitOfWeight = unitOfWeight;
  }

  public HasOne<ShippingCategory> getShippingCategory() {
    return this.shippingCategory;
  }

  public void setShippingCategory(HasOne<ShippingCategory> shippingCategory) {
    this.shippingCategory = shippingCategory;
  }

  public ShippingCategory getShippingCategoryResource() {
    return getShippingCategory().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingCategoryLinksMap() {
    return (Map<String, String>)getShippingCategory().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<Price> getPrices() {
    return this.prices;
  }

  public void setPrices(HasMany<Price> prices) {
    this.prices = prices;
  }

  public List<Price> getPriceResourceList() {
    return getPrices().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPricesLinksMap() {
    return (Map<String, String>)getPrices().getLinks().get(new CLLinksAdapter());
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

  public HasMany<DeliveryLeadTime> getDeliveryLeadTimes() {
    return this.deliveryLeadTimes;
  }

  public void setDeliveryLeadTimes(HasMany<DeliveryLeadTime> deliveryLeadTimes) {
    this.deliveryLeadTimes = deliveryLeadTimes;
  }

  public List<DeliveryLeadTime> getDeliveryLeadTimeResourceList() {
    return getDeliveryLeadTimes().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getDeliveryLeadTimesLinksMap() {
    return (Map<String, String>)getDeliveryLeadTimes().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<SkuOption> getSkuOptions() {
    return this.skuOptions;
  }

  public void setSkuOptions(HasMany<SkuOption> skuOptions) {
    this.skuOptions = skuOptions;
  }

  public List<SkuOption> getSkuOptionResourceList() {
    return getSkuOptions().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getSkuOptionsLinksMap() {
    return (Map<String, String>)getSkuOptions().getLinks().get(new CLLinksAdapter());
  }
}
