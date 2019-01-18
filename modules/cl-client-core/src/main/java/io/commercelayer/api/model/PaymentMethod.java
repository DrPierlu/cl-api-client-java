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
    type = "payment_methods"
)
public class PaymentMethod extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Market.class, PaymentGateway.class));

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
  private Float priceAmountFloat;

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

  public Float getPriceAmountFloat() {
    return this.priceAmountFloat;
  }

  public void setPriceAmountFloat(Float priceAmountFloat) {
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
    return (Market)getResource(getMarket().get(getDocument()));
  }

  public void setMarketResource(Market market) {
    setMarket(new HasOne<Market>(market));
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
    return (PaymentGateway)getResource(getPaymentGateway().get(getDocument()));
  }

  public void setPaymentGatewayResource(PaymentGateway paymentGateway) {
    setPaymentGateway(new HasOne<PaymentGateway>(paymentGateway));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPaymentGatewayLinksMap() {
    return (Map<String, String>)getPaymentGateway().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String MARKET = "market";

    String PAYMENT_GATEWAY = "payment_gateway";
  }
}
