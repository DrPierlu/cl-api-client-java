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
    type = "addresses"
)
public class Address extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Geocoder.class));

  private Boolean business;

  @Json(
      name = "first_name"
  )
  private String firstName;

  @Json(
      name = "last_name"
  )
  private String lastName;

  private String company;

  @Json(
      name = "line_1"
  )
  private String line1;

  @Json(
      name = "line_2"
  )
  private String line2;

  private String city;

  @Json(
      name = "zip_code"
  )
  private String zipCode;

  @Json(
      name = "state_code"
  )
  private String stateCode;

  @Json(
      name = "country_code"
  )
  private String countryCode;

  private String phone;

  private String email;

  private String notes;

  private Float lat;

  private Float lng;

  @Json(
      name = "billing_info"
  )
  private String billingInfo;

  @Json(
      name = "full_name"
  )
  private String fullName;

  @Json(
      name = "full_address"
  )
  private String fullAddress;

  private String name;

  @Json(
      name = "is_localized"
  )
  private Boolean isLocalized;

  @Json(
      name = "is_geocoded"
  )
  private Boolean isGeocoded;

  @Json(
      name = "provider_name"
  )
  private String providerName;

  @Json(
      name = "map_url"
  )
  private String mapUrl;

  @Json(
      name = "static_map_url"
  )
  private String staticMapUrl;

  private HasOne<Geocoder> geocoder;

  public Boolean getBusiness() {
    return this.business;
  }

  public void setBusiness(Boolean business) {
    this.business = business;
  }

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

  public String getCompany() {
    return this.company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLine1() {
    return this.line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return this.line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZipCode() {
    return this.zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getStateCode() {
    return this.stateCode;
  }

  public void setStateCode(String stateCode) {
    this.stateCode = stateCode;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Float getLat() {
    return this.lat;
  }

  public void setLat(Float lat) {
    this.lat = lat;
  }

  public Float getLng() {
    return this.lng;
  }

  public void setLng(Float lng) {
    this.lng = lng;
  }

  public String getBillingInfo() {
    return this.billingInfo;
  }

  public void setBillingInfo(String billingInfo) {
    this.billingInfo = billingInfo;
  }

  public String getFullName() {
    return this.fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFullAddress() {
    return this.fullAddress;
  }

  public void setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getIsLocalized() {
    return this.isLocalized;
  }

  public void setIsLocalized(Boolean isLocalized) {
    this.isLocalized = isLocalized;
  }

  public Boolean getIsGeocoded() {
    return this.isGeocoded;
  }

  public void setIsGeocoded(Boolean isGeocoded) {
    this.isGeocoded = isGeocoded;
  }

  public String getProviderName() {
    return this.providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public String getMapUrl() {
    return this.mapUrl;
  }

  public void setMapUrl(String mapUrl) {
    this.mapUrl = mapUrl;
  }

  public String getStaticMapUrl() {
    return this.staticMapUrl;
  }

  public void setStaticMapUrl(String staticMapUrl) {
    this.staticMapUrl = staticMapUrl;
  }

  public HasOne<Geocoder> getGeocoder() {
    return this.geocoder;
  }

  public void setGeocoder(HasOne<Geocoder> geocoder) {
    this.geocoder = geocoder;
  }

  public Geocoder getGeocoderResource() {
    return (Geocoder)getResource(getGeocoder().get(getDocument()));
  }

  public void setGeocoderResource(Geocoder geocoder) {
    setGeocoder(new HasOne<Geocoder>(geocoder));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getGeocoderLinksMap() {
    return (Map<String, String>)getGeocoder().getLinks().get(new CLLinksAdapter());
  }
}
