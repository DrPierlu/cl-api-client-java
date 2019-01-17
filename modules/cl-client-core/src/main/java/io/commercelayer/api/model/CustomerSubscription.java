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
    type = "customer_subscriptions"
)
public class CustomerSubscription extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Customer.class));

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
    return (Customer)getResource(getCustomer().get(getDocument()));
  }

  public void setCustomerResource(Customer customer) {
    setCustomer(new HasOne<Customer>(customer));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerLinksMap() {
    return (Map<String, String>)getCustomer().getLinks().get(new CLLinksAdapter());
  }
}
