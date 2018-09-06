package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.common.ApiResource;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "shipping_zones"
)
public class ShippingZone extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  @Json(
      name = "country_code_regex"
  )
  private String countryCodeRegex;

  @Json(
      name = "not_country_code_regex"
  )
  private String notCountryCodeRegex;

  @Json(
      name = "state_code_regex"
  )
  private String stateCodeRegex;

  @Json(
      name = "not_state_code_regex"
  )
  private String notStateCodeRegex;

  @Json(
      name = "zip_code_regex"
  )
  private String zipCodeRegex;

  @Json(
      name = "not_zip_code_regex"
  )
  private String notZipCodeRegex;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCodeRegex() {
    return this.countryCodeRegex;
  }

  public void setCountryCodeRegex(String countryCodeRegex) {
    this.countryCodeRegex = countryCodeRegex;
  }

  public String getNotCountryCodeRegex() {
    return this.notCountryCodeRegex;
  }

  public void setNotCountryCodeRegex(String notCountryCodeRegex) {
    this.notCountryCodeRegex = notCountryCodeRegex;
  }

  public String getStateCodeRegex() {
    return this.stateCodeRegex;
  }

  public void setStateCodeRegex(String stateCodeRegex) {
    this.stateCodeRegex = stateCodeRegex;
  }

  public String getNotStateCodeRegex() {
    return this.notStateCodeRegex;
  }

  public void setNotStateCodeRegex(String notStateCodeRegex) {
    this.notStateCodeRegex = notStateCodeRegex;
  }

  public String getZipCodeRegex() {
    return this.zipCodeRegex;
  }

  public void setZipCodeRegex(String zipCodeRegex) {
    this.zipCodeRegex = zipCodeRegex;
  }

  public String getNotZipCodeRegex() {
    return this.notZipCodeRegex;
  }

  public void setNotZipCodeRegex(String notZipCodeRegex) {
    this.notZipCodeRegex = notZipCodeRegex;
  }
}
