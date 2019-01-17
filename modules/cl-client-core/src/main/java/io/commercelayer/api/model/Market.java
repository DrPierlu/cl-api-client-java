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
    type = "markets"
)
public class Market extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Merchant.class, PriceList.class, InventoryModel.class));

  private String name;

  private HasOne<Merchant> merchant;

  @Json(
      name = "price_list"
  )
  private HasOne<PriceList> priceList;

  @Json(
      name = "inventory_model"
  )
  private HasOne<InventoryModel> inventoryModel;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HasOne<Merchant> getMerchant() {
    return this.merchant;
  }

  public void setMerchant(HasOne<Merchant> merchant) {
    this.merchant = merchant;
  }

  public Merchant getMerchantResource() {
    return (Merchant)getResource(getMerchant().get(getDocument()));
  }

  public void setMerchantResource(Merchant merchant) {
    setMerchant(new HasOne<Merchant>(merchant));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getMerchantLinksMap() {
    return (Map<String, String>)getMerchant().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<PriceList> getPriceList() {
    return this.priceList;
  }

  public void setPriceList(HasOne<PriceList> priceList) {
    this.priceList = priceList;
  }

  public PriceList getPriceListResource() {
    return (PriceList)getResource(getPriceList().get(getDocument()));
  }

  public void setPriceListResource(PriceList priceList) {
    setPriceList(new HasOne<PriceList>(priceList));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPriceListLinksMap() {
    return (Map<String, String>)getPriceList().getLinks().get(new CLLinksAdapter());
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
}
