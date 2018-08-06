package io.commercelayer.api.model.dev;

import java.util.Map;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(type = "addresses")
public class Address extends ApiResource {

	private static final long serialVersionUID = 2576427331927270934L;

	private Boolean business;
	@Json(name = "first_name")
	private String firstName;
	@Json(name = "last_name")
	private String lastName;
	private String company;
	@Json(name = "full_name")
	private String fullName;
	@Json(name = "line_1")
	private String line1;
	@Json(name = "line_2")
	private String line2;
	private String city;
	@Json(name = "zip_code")
	private String zipCode;
	@Json(name = "state_code")
	private String stateCode;
	@Json(name = "country_code")
	private String countryCode;
	private String phone;
	@Json(name = "full_address")
	private String fullAddress;
	private String name;
	private String email;
	private String notes;
	private Float lat;
	private Float lng;
	@Json(name = "is_localized")
	private Boolean isLocalized;
	@Json(name = "is_geocoded")
	private Boolean isGeocoded;
	@Json(name = "provider_name")
	private String providerName;
	@Json(name = "map_url")
	private String mapUrl;
	@Json(name = "static_map_url")
	private String staticMapUrl;
	@Json(name = "billing_info")
	private String billingInfo;
	
	private HasOne<Geocoder> geocoder;

	public Boolean isBusiness() {
		return business;
	}

	public void setBusiness(Boolean business) {
		this.business = business;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Boolean isLocalized() {
		return isLocalized;
	}

	public void setLocalized(Boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

	public Boolean isGeocoded() {
		return isGeocoded;
	}

	public void setGeocoded(Boolean isGeocoded) {
		this.isGeocoded = isGeocoded;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getMapUrl() {
		return mapUrl;
	}

	public void setMapUrl(String mapUrl) {
		this.mapUrl = mapUrl;
	}

	public String getStaticMapUrl() {
		return staticMapUrl;
	}

	public void setStaticMapUrl(String staticMapUrl) {
		this.staticMapUrl = staticMapUrl;
	}

	public String getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(String billingInfo) {
		this.billingInfo = billingInfo;
	}

	public HasOne<Geocoder> getGeocoder() {
		return geocoder;
	}

	public void setGeocoder(HasOne<Geocoder> geocoder) {
		this.geocoder = geocoder;
	}
	
	public Geocoder getGeocoderResource() {
		return getGeocoder().get(getDocument());
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getGeocoderLinksMap() {
		return (Map<String, String>)getGeocoder().getLinks().get(new CLLinksAdapter());
	}

}
