package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "customer_subscriptions"
)
public class CustomerSubscription extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "customer_email"
  )
  private String customerEmail;

  private HasOne<Customer> customer;

  public String getCustomerEmail() {
    return this.customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public HasOne<Customer> getCustomer() {
    return this.customer;
  }

  public void setCustomer(HasOne<Customer> customer) {
    this.customer = customer;
  }

  public Customer getCustomerResource() {
    return getCustomer().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerLinksMap() {
    return (Map<String, String>)getCustomer().getLinks().get(new CLLinksAdapter());
  }
}
