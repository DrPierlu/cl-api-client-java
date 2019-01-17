package io.commercelayer.api.model;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "customer_addresses"
)
public class CustomerAddress extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  private HasOne<Customer> customer;

  private HasOne<Address> address;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HasOne<Customer> getCustomer() {
    return this.customer;
  }

  public void setCustomer(HasOne<Customer> customer) {
    this.customer = customer;
  }

  public Customer getCustomerResource() {
    return (Customer)getResource(getCustomer().get(getDocument()));
  }

  public void setCustomerResource(Customer customer) {
    setCustomer(new HasOne<Customer>(customer));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerLinksMap() {
    return (Map<String, String>)getCustomer().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Address> getAddress() {
    return this.address;
  }

  public void setAddress(HasOne<Address> address) {
    this.address = address;
  }

  public Address getAddressResource() {
    return (Address)getResource(getAddress().get(getDocument()));
  }

  public void setAddressResource(Address address) {
    setAddress(new HasOne<Address>(address));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getAddressLinksMap() {
    return (Map<String, String>)getAddress().getLinks().get(new CLLinksAdapter());
  }
}
