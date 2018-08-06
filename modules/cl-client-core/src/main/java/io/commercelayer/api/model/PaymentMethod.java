package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "payment_methods"
)
public class PaymentMethod extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "payment_source_type"
  )
  private String paymentSourceType;

  @Json(
      name = "price_amount_cents"
  )
  private Integer priceAmountCents;

  private String name;

  @Json(
      name = "price_amount_float"
  )
  private Integer priceAmountFloat;

  @Json(
      name = "formatted_price_amount"
  )
  private String formattedPriceAmount;

  private HasOne<Market> market;

  @Json(
      name = "payment_gateway"
  )
  private HasOne<PaymentGateway> paymentGateway;

  public String getPaymentSourceType() {
    return this.paymentSourceType;
  }

  public void setPaymentSourceType(String paymentSourceType) {
    this.paymentSourceType = paymentSourceType;
  }

  public Integer getPriceAmountCents() {
    return this.priceAmountCents;
  }

  public void setPriceAmountCents(Integer priceAmountCents) {
    this.priceAmountCents = priceAmountCents;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPriceAmountFloat() {
    return this.priceAmountFloat;
  }

  public void setPriceAmountFloat(Integer priceAmountFloat) {
    this.priceAmountFloat = priceAmountFloat;
  }

  public String getFormattedPriceAmount() {
    return this.formattedPriceAmount;
  }

  public void setFormattedPriceAmount(String formattedPriceAmount) {
    this.formattedPriceAmount = formattedPriceAmount;
  }

  public HasOne<Market> getMarket() {
    return this.market;
  }

  public void setMarket(HasOne<Market> market) {
    this.market = market;
  }

  public Market getMarketResource() {
    return getMarket().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getMarketLinksMap() {
    return (Map<String, String>)getMarket().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<PaymentGateway> getPaymentGateway() {
    return this.paymentGateway;
  }

  public void setPaymentGateway(HasOne<PaymentGateway> paymentGateway) {
    this.paymentGateway = paymentGateway;
  }

  public PaymentGateway getPaymentGatewayResource() {
    return getPaymentGateway().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPaymentGatewayLinksMap() {
    return (Map<String, String>)getPaymentGateway().getLinks().get(new CLLinksAdapter());
  }
}
