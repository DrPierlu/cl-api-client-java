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
    type = "customer_payment_sources"
)
public class CustomerPaymentSource extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  private HasOne<Customer> customer;

  @Json(
      name = "payment_source"
  )
  private HasOne<PaymentSource> paymentSource;

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
    return getCustomer().get(getDocument());
  }

  public void setCustomerResource(Customer customer) {
    setCustomer(new HasOne<Customer>(customer));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerLinksMap() {
    return (Map<String, String>)getCustomer().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<PaymentSource> getPaymentSource() {
    return this.paymentSource;
  }

  public void setPaymentSource(HasOne<PaymentSource> paymentSource) {
    this.paymentSource = paymentSource;
  }

  public PaymentSource getPaymentSourceResource() {
    return getPaymentSource().get(getDocument());
  }

  public void setPaymentSourceResource(PaymentSource paymentSource) {
    setPaymentSource(new HasOne<PaymentSource>(paymentSource));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPaymentSourceLinksMap() {
    return (Map<String, String>)getPaymentSource().getLinks().get(new CLLinksAdapter());
  }
}
