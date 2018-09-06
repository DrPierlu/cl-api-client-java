package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "credit_cards"
)
public class CreditCard extends ApiResource {
  public static final long serialVersionUID = -1;

  @Json(
      name = "first_name"
  )
  private String firstName;

  @Json(
      name = "last_name"
  )
  private String lastName;

  private String number;

  private String month;

  private String year;

  @Json(
      name = "verification_value"
  )
  private String verificationValue;

  @Json(
      name = "full_name"
  )
  private String fullName;

  @Json(
      name = "valid_thru"
  )
  private String validThru;

  @Json(
      name = "card_type"
  )
  private String cardType;

  @Json(
      name = "display_number"
  )
  private String displayNumber;

  private String name;

  private String fingerprint;

  @Json(
      name = "storage_state"
  )
  private String storageState;

  private HasOne<Order> order;

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getMonth() {
    return this.month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public String getYear() {
    return this.year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getVerificationValue() {
    return this.verificationValue;
  }

  public void setVerificationValue(String verificationValue) {
    this.verificationValue = verificationValue;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getValidThru() {
    return this.validThru;
  }

  public void setValidThru(String validThru) {
    this.validThru = validThru;
  }

  public String getCardType() {
    return this.cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getDisplayNumber() {
    return this.displayNumber;
  }

  public void setDisplayNumber(String displayNumber) {
    this.displayNumber = displayNumber;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFingerprint() {
    return this.fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public String getStorageState() {
    return this.storageState;
  }

  public void setStorageState(String storageState) {
    this.storageState = storageState;
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
