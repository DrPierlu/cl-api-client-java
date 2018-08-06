package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "customers"
)
public class Customer extends ApiResource {
  public static final long serialVersionUID = -1;

  private String email;

  private String password;

  private String status;

  @Json(
      name = "customer_addresses"
  )
  private HasMany<CustomerAddress> customerAddresses;

  @Json(
      name = "customer_payment_sources"
  )
  private HasMany<CustomerPaymentSource> customerPaymentSources;

  @Json(
      name = "customer_subscriptions"
  )
  private HasMany<CustomerSubscription> customerSubscriptions;

  private HasMany<Order> orders;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public HasMany<CustomerAddress> getCustomerAddresses() {
    return this.customerAddresses;
  }

  public void setCustomerAddresses(HasMany<CustomerAddress> customerAddresses) {
    this.customerAddresses = customerAddresses;
  }

  public List<CustomerAddress> getCustomerAddressResourceList() {
    return getCustomerAddresses().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerAddressesLinksMap() {
    return (Map<String, String>)getCustomerAddresses().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<CustomerPaymentSource> getCustomerPaymentSources() {
    return this.customerPaymentSources;
  }

  public void setCustomerPaymentSources(HasMany<CustomerPaymentSource> customerPaymentSources) {
    this.customerPaymentSources = customerPaymentSources;
  }

  public List<CustomerPaymentSource> getCustomerPaymentSourceResourceList() {
    return getCustomerPaymentSources().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerPaymentSourcesLinksMap() {
    return (Map<String, String>)getCustomerPaymentSources().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<CustomerSubscription> getCustomerSubscriptions() {
    return this.customerSubscriptions;
  }

  public void setCustomerSubscriptions(HasMany<CustomerSubscription> customerSubscriptions) {
    this.customerSubscriptions = customerSubscriptions;
  }

  public List<CustomerSubscription> getCustomerSubscriptionResourceList() {
    return getCustomerSubscriptions().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerSubscriptionsLinksMap() {
    return (Map<String, String>)getCustomerSubscriptions().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<Order> getOrders() {
    return this.orders;
  }

  public void setOrders(HasMany<Order> orders) {
    this.orders = orders;
  }

  public List<Order> getOrderResourceList() {
    return getOrders().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getOrdersLinksMap() {
    return (Map<String, String>)getOrders().getLinks().get(new CLLinksAdapter());
  }
}
