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
    type = "customer_password_resets"
)
public class CustomerPasswordReset extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "customer_email"
  )
  private String customerEmail;

  @Json(
      name = "customer_password"
  )
  private String customerPassword;

  @Json(
      name = "_reset_password_token"
  )
  private String _resetPasswordToken;

  @Json(
      name = "reset_password_token"
  )
  private String resetPasswordToken;

  @Json(
      name = "reset_password_at"
  )
  private String resetPasswordAt;

  private HasOne<Customer> customer;

  public String getCustomerEmail() {
    return this.customerEmail;
  }

  public void setCustomerEmail(String customerEmail) {
    this.customerEmail = customerEmail;
  }

  public String getCustomerPassword() {
    return this.customerPassword;
  }

  public void setCustomerPassword(String customerPassword) {
    this.customerPassword = customerPassword;
  }

  public String getResetPasswordToken_() {
    return this._resetPasswordToken;
  }

  public void setResetPasswordToken_(String _resetPasswordToken) {
    this._resetPasswordToken = _resetPasswordToken;
  }

  public String getResetPasswordToken() {
    return this.resetPasswordToken;
  }

  public void setResetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
  }

  public String getResetPasswordAt() {
    return this.resetPasswordAt;
  }

  public void setResetPasswordAt(String resetPasswordAt) {
    this.resetPasswordAt = resetPasswordAt;
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
}
