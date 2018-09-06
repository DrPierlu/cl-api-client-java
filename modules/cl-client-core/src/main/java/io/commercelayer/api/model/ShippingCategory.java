package io.commercelayer.api.model;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "shipping_categories"
)
public class ShippingCategory extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  private HasMany<Sku> skus;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HasMany<Sku> getSkus() {
    return this.skus;
  }

  public void setSkus(HasMany<Sku> skus) {
    this.skus = skus;
  }

  public List<Sku> getSkuResourceList() {
    return getSkus().get(getDocument());
  }

  public void setSkuResourceList(List<Sku> skus) {
    setSkus(new HasMany<Sku>(skus.toArray(new Sku[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getSkusLinksMap() {
    return (Map<String, String>)getSkus().getLinks().get(new CLLinksAdapter());
  }
}
