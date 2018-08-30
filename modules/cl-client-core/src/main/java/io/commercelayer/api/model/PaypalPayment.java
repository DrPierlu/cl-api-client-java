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
    type = "paypal_payments"
)
public class PaypalPayment extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "return_url"
  )
  private String returnUrl;

  @Json(
      name = "cancel_url"
  )
  private String cancelUrl;

  @Json(
      name = "note_to_payer"
  )
  private String noteToPayer;

  @Json(
      name = "paypal_payer_id"
  )
  private String paypalPayerId;

  private String name;

  @Json(
      name = "paypal_id"
  )
  private String paypalId;

  private String status;

  @Json(
      name = "approval_url"
  )
  private String approvalUrl;

  private HasOne<Order> order;

  public String getReturnUrl() {
    return this.returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public String getCancelUrl() {
    return this.cancelUrl;
  }

  public void setCancelUrl(String cancelUrl) {
    this.cancelUrl = cancelUrl;
  }

  public String getNoteToPayer() {
    return this.noteToPayer;
  }

  public void setNoteToPayer(String noteToPayer) {
    this.noteToPayer = noteToPayer;
  }

  public String getPaypalPayerId() {
    return this.paypalPayerId;
  }

  public void setPaypalPayerId(String paypalPayerId) {
    this.paypalPayerId = paypalPayerId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPaypalId() {
    return this.paypalId;
  }

  public void setPaypalId(String paypalId) {
    this.paypalId = paypalId;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getApprovalUrl() {
    return this.approvalUrl;
  }

  public void setApprovalUrl(String approvalUrl) {
    this.approvalUrl = approvalUrl;
  }

  public HasOne<Order> getOrder() {
    return this.order;
  }

  public void setOrder(HasOne<Order> order) {
    this.order = order;
  }

  public Order getOrderResource() {
    return getOrder().get(getDocument());
  }

  public void setOrderResource(Order order) {
    setOrder(new HasOne<Order>(order));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getOrderLinksMap() {
    return (Map<String, String>)getOrder().getLinks().get(new CLLinksAdapter());
  }
}
