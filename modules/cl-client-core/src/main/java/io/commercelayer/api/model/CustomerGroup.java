package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "customer_groups"
)
public class CustomerGroup extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(PriceList.class, Customer.class));

  private String name;

  @Json(
      name = "price_list"
  )
  private HasOne<PriceList> priceList;

  private HasMany<Customer> customers;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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

  public HasMany<Customer> getCustomers() {
    return this.customers;
  }

  public void setCustomers(HasMany<Customer> customers) {
    this.customers = customers;
  }

  @SuppressWarnings("unchecked")
  public List<Customer> getCustomerResourceList() {
    return (List<Customer>)getResource(getCustomers().get(getDocument()));
  }

  public void setCustomerResourceList(List<Customer> customers) {
    setCustomers(new HasMany<Customer>(customers.toArray(new Customer[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomersLinksMap() {
    return (Map<String, String>)getCustomers().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String PRICE_LIST = "price_list";

    String CUSTOMERS = "customers";
  }
}
