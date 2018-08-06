package io.commercelayer.api.model.dev;

import java.util.Map;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(type = "credit_cards")
public class CreditCard extends ApiResource {

	private static final long serialVersionUID = 4133368950410457479L;

	@Json(name = "first_name")
	private String firstName;
	@Json(name = "last_name")
	private String lastName;
	@Json(name = "full_name")
	private String fullName;
	private String month;
	private String year;
	@Json(name = "valid_thru")
	private String validThru;
	@Json(name = "card_type")
	private String cardType;
	@Json(name = "display_number")
	private String displayNumber;
	private String name;
	private String fingerprint;
	@Json(name = "storage_state")
	private String storageState;

	private HasOne<Order> order;

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getValidThru() {
		return validThru;
	}

	public void setValidThru(String validThru) {
		this.validThru = validThru;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getDisplayNumber() {
		return displayNumber;
	}

	public void setDisplayNumber(String displayNumber) {
		this.displayNumber = displayNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getStorageState() {
		return storageState;
	}

	public void setStorageState(String storageState) {
		this.storageState = storageState;
	}

	public HasOne<Order> getOrder() {
		return order;
	}

	public void setOrder(HasOne<Order> order) {
		this.order = order;
	}
	
	public Order getOrderResource() {
		return getOrder().get(getDocument());
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getOrderLinksMap() {
		return (Map<String, String>)getOrder().getLinks().get(new CLLinksAdapter());
	}

}
