package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "orders"
)
public class Order extends ApiResource {
  public static final long serialVersionUID = -1;

  private Boolean guest;

  @Json(
      name = "customer_email"
  )
  private String customerEmail;

  @Json(
      name = "customer_password"
  )
  private String customerPassword;

  @Json(
      name = "language_code"
  )
  private String languageCode;

  @Json(
      name = "shipping_country_code_lock"
  )
  private String shippingCountryCodeLock;

  @Json(
      name = "coupon_code"
  )
  private String couponCode;

  @Json(
      name = "cart_url"
  )
  private String cartUrl;

  @Json(
      name = "return_url"
  )
  private String returnUrl;

  @Json(
      name = "terms_url"
  )
  private String termsUrl;

  @Json(
      name = "privacy_url"
  )
  private String privacyUrl;

  @Json(
      name = "_place"
  )
  private Integer _place;

  @Json(
      name = "_cancel"
  )
  private Integer _cancel;

  @Json(
      name = "_approve"
  )
  private Integer _approve;

  @Json(
      name = "_update_taxes"
  )
  private Integer _updateTaxes;

  @Json(
      name = "_billing_address_clone_id"
  )
  private Integer _billingAddressCloneId;

  @Json(
      name = "_shipping_address_clone_id"
  )
  private Integer _shippingAddressCloneId;

  @Json(
      name = "_customer_payment_source_id"
  )
  private Integer _customerPaymentSourceId;

  @Json(
      name = "_shipping_address_same_as_billing"
  )
  private Integer _shippingAddressSameAsBilling;

  @Json(
      name = "_billing_address_same_as_shipping"
  )
  private Integer _billingAddressSameAsShipping;

  @Json(
      name = "_save_payment_source_to_customer_wallet"
  )
  private Integer _savePaymentSourceToCustomerWallet;

  @Json(
      name = "_save_shipping_address_to_customer_address_book"
  )
  private Integer _saveShippingAddressToCustomerAddressBook;

  @Json(
      name = "_save_billing_address_to_customer_address_book"
  )
  private Integer _saveBillingAddressToCustomerAddressBook;

  @Json(
      name = "_refresh"
  )
  private Integer _refresh;

  private String status;

  @Json(
      name = "payment_status"
  )
  private String paymentStatus;

  @Json(
      name = "fulfillment_status"
  )
  private String fulfillmentStatus;

  private Boolean editable;

  private Boolean placeable;

  @Json(
      name = "currency_code"
  )
  private String currencyCode;

  @Json(
      name = "tax_included"
  )
  private Boolean taxIncluded;

  @Json(
      name = "tax_rate"
  )
  private Integer taxRate;

  @Json(
      name = "freight_taxable"
  )
  private Boolean freightTaxable;

  @Json(
      name = "country_code"
  )
  private String countryCode;

  @Json(
      name = "subtotal_amount_cents"
  )
  private Integer subtotalAmountCents;

  @Json(
      name = "subtotal_amount_float"
  )
  private Integer subtotalAmountFloat;

  @Json(
      name = "formatted_subtotal_amount"
  )
  private String formattedSubtotalAmount;

  @Json(
      name = "shipping_amount_cents"
  )
  private Integer shippingAmountCents;

  @Json(
      name = "shipping_amount_float"
  )
  private Integer shippingAmountFloat;

  @Json(
      name = "formatted_shipping_amount"
  )
  private String formattedShippingAmount;

  @Json(
      name = "payment_method_amount_cents"
  )
  private Integer paymentMethodAmountCents;

  @Json(
      name = "payment_method_amount_float"
  )
  private Integer paymentMethodAmountFloat;

  @Json(
      name = "formatted_payment_method_amount"
  )
  private String formattedPaymentMethodAmount;

  @Json(
      name = "discount_amount_cents"
  )
  private Integer discountAmountCents;

  @Json(
      name = "discount_amount_float"
  )
  private Integer discountAmountFloat;

  @Json(
      name = "formatted_discount_amount"
  )
  private String formattedDiscountAmount;

  @Json(
      name = "total_tax_amount_cents"
  )
  private Integer totalTaxAmountCents;

  @Json(
      name = "total_tax_amount_float"
  )
  private Integer totalTaxAmountFloat;

  @Json(
      name = "formatted_total_tax_amount"
  )
  private String formattedTotalTaxAmount;

  @Json(
      name = "subtotal_tax_amount_cents"
  )
  private Integer subtotalTaxAmountCents;

  @Json(
      name = "subtotal_tax_amount_float"
  )
  private Integer subtotalTaxAmountFloat;

  @Json(
      name = "formatted_subtotal_tax_amount"
  )
  private String formattedSubtotalTaxAmount;

  @Json(
      name = "shipping_tax_amount_cents"
  )
  private Integer shippingTaxAmountCents;

  @Json(
      name = "shipping_tax_amount_float"
  )
  private Integer shippingTaxAmountFloat;

  @Json(
      name = "formatted_shipping_tax_amount"
  )
  private String formattedShippingTaxAmount;

  @Json(
      name = "payment_method_tax_amount_cents"
  )
  private Integer paymentMethodTaxAmountCents;

  @Json(
      name = "payment_method_tax_amount_float"
  )
  private Integer paymentMethodTaxAmountFloat;

  @Json(
      name = "formatted_payment_method_tax_amount"
  )
  private String formattedPaymentMethodTaxAmount;

  @Json(
      name = "discount_tax_amount_cents"
  )
  private Integer discountTaxAmountCents;

  @Json(
      name = "discount_tax_amount_float"
  )
  private Integer discountTaxAmountFloat;

  @Json(
      name = "formatted_discount_tax_amount"
  )
  private String formattedDiscountTaxAmount;

  @Json(
      name = "total_amount_cents"
  )
  private Integer totalAmountCents;

  @Json(
      name = "total_amount_float"
  )
  private Integer totalAmountFloat;

  @Json(
      name = "formatted_total_amount"
  )
  private String formattedTotalAmount;

  @Json(
      name = "total_taxable_amount_cents"
  )
  private Integer totalTaxableAmountCents;

  @Json(
      name = "total_taxable_amount_float"
  )
  private Integer totalTaxableAmountFloat;

  @Json(
      name = "formatted_total_taxable_amount"
  )
  private String formattedTotalTaxableAmount;

  @Json(
      name = "subtotal_taxable_amount_cents"
  )
  private Integer subtotalTaxableAmountCents;

  @Json(
      name = "subtotal_taxable_amount_float"
  )
  private Integer subtotalTaxableAmountFloat;

  @Json(
      name = "formatted_subtotal_taxable_amount"
  )
  private String formattedSubtotalTaxableAmount;

  @Json(
      name = "shipping_taxable_amount_cents"
  )
  private Integer shippingTaxableAmountCents;

  @Json(
      name = "shipping_taxable_amount_float"
  )
  private Integer shippingTaxableAmountFloat;

  @Json(
      name = "formatted_shipping_taxable_amount"
  )
  private String formattedShippingTaxableAmount;

  @Json(
      name = "payment_method_taxable_amount_cents"
  )
  private Integer paymentMethodTaxableAmountCents;

  @Json(
      name = "payment_method_taxable_amount_float"
  )
  private Integer paymentMethodTaxableAmountFloat;

  @Json(
      name = "formatted_payment_method_taxable_amount"
  )
  private String formattedPaymentMethodTaxableAmount;

  @Json(
      name = "discount_taxable_amount_cents"
  )
  private Integer discountTaxableAmountCents;

  @Json(
      name = "discount_taxable_amount_float"
  )
  private Integer discountTaxableAmountFloat;

  @Json(
      name = "formatted_discount_taxable_amount"
  )
  private String formattedDiscountTaxableAmount;

  @Json(
      name = "total_amount_with_taxes_cents"
  )
  private Integer totalAmountWithTaxesCents;

  @Json(
      name = "total_amount_with_taxes_float"
  )
  private Integer totalAmountWithTaxesFloat;

  @Json(
      name = "formatted_total_amount_with_taxes"
  )
  private String formattedTotalAmountWithTaxes;

  @Json(
      name = "fees_amount_cents"
  )
  private Integer feesAmountCents;

  @Json(
      name = "fees_amount_float"
  )
  private Integer feesAmountFloat;

  @Json(
      name = "formatted_fees_amount"
  )
  private String formattedFeesAmount;

  @Json(
      name = "skus_count"
  )
  private Integer skusCount;

  @Json(
      name = "payment_source_details"
  )
  private Object paymentSourceDetails;

  private String token;

  @Json(
      name = "checkout_url"
  )
  private String checkoutUrl;

  @Json(
      name = "placed_at"
  )
  private String placedAt;

  @Json(
      name = "approved_at"
  )
  private String approvedAt;

  @Json(
      name = "cancelled_at"
  )
  private String cancelledAt;

  @Json(
      name = "payment_updated_at"
  )
  private String paymentUpdatedAt;

  @Json(
      name = "fulfillment_updated_at"
  )
  private String fulfillmentUpdatedAt;

  private HasOne<Market> market;

  private HasOne<Customer> customer;

  @Json(
      name = "shipping_address"
  )
  private HasOne<Address> shippingAddress;

  @Json(
      name = "billing_address"
  )
  private HasOne<Address> billingAddress;

  @Json(
      name = "payment_method"
  )
  private HasOne<PaymentMethod> paymentMethod;

  @Json(
      name = "payment_source"
  )
  private HasOne<PaymentSource> paymentSource;

  @Json(
      name = "line_items"
  )
  private HasMany<LineItem> lineItems;

  private HasMany<Shipment> shipments;

  public Boolean getGuest() {
    return this.guest;
  }

  public void setGuest(Boolean guest) {
    this.guest = guest;
  }

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

  public String getLanguageCode() {
    return this.languageCode;
  }

  public void setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
  }

  public String getShippingCountryCodeLock() {
    return this.shippingCountryCodeLock;
  }

  public void setShippingCountryCodeLock(String shippingCountryCodeLock) {
    this.shippingCountryCodeLock = shippingCountryCodeLock;
  }

  public String getCouponCode() {
    return this.couponCode;
  }

  public void setCouponCode(String couponCode) {
    this.couponCode = couponCode;
  }

  public String getCartUrl() {
    return this.cartUrl;
  }

  public void setCartUrl(String cartUrl) {
    this.cartUrl = cartUrl;
  }

  public String getReturnUrl() {
    return this.returnUrl;
  }

  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  public String getTermsUrl() {
    return this.termsUrl;
  }

  public void setTermsUrl(String termsUrl) {
    this.termsUrl = termsUrl;
  }

  public String getPrivacyUrl() {
    return this.privacyUrl;
  }

  public void setPrivacyUrl(String privacyUrl) {
    this.privacyUrl = privacyUrl;
  }

  public Integer getPlace_() {
    return this._place;
  }

  public void setPlace_(Integer _place) {
    this._place = _place;
  }

  public Integer getCancel_() {
    return this._cancel;
  }

  public void setCancel_(Integer _cancel) {
    this._cancel = _cancel;
  }

  public Integer getApprove_() {
    return this._approve;
  }

  public void setApprove_(Integer _approve) {
    this._approve = _approve;
  }

  public Integer getUpdateTaxes_() {
    return this._updateTaxes;
  }

  public void setUpdateTaxes_(Integer _updateTaxes) {
    this._updateTaxes = _updateTaxes;
  }

  public Integer getBillingAddressCloneId_() {
    return this._billingAddressCloneId;
  }

  public void setBillingAddressCloneId_(Integer _billingAddressCloneId) {
    this._billingAddressCloneId = _billingAddressCloneId;
  }

  public Integer getShippingAddressCloneId_() {
    return this._shippingAddressCloneId;
  }

  public void setShippingAddressCloneId_(Integer _shippingAddressCloneId) {
    this._shippingAddressCloneId = _shippingAddressCloneId;
  }

  public Integer getCustomerPaymentSourceId_() {
    return this._customerPaymentSourceId;
  }

  public void setCustomerPaymentSourceId_(Integer _customerPaymentSourceId) {
    this._customerPaymentSourceId = _customerPaymentSourceId;
  }

  public Integer getShippingAddressSameAsBilling_() {
    return this._shippingAddressSameAsBilling;
  }

  public void setShippingAddressSameAsBilling_(Integer _shippingAddressSameAsBilling) {
    this._shippingAddressSameAsBilling = _shippingAddressSameAsBilling;
  }

  public Integer getBillingAddressSameAsShipping_() {
    return this._billingAddressSameAsShipping;
  }

  public void setBillingAddressSameAsShipping_(Integer _billingAddressSameAsShipping) {
    this._billingAddressSameAsShipping = _billingAddressSameAsShipping;
  }

  public Integer getSavePaymentSourceToCustomerWallet_() {
    return this._savePaymentSourceToCustomerWallet;
  }

  public void setSavePaymentSourceToCustomerWallet_(Integer _savePaymentSourceToCustomerWallet) {
    this._savePaymentSourceToCustomerWallet = _savePaymentSourceToCustomerWallet;
  }

  public Integer getSaveShippingAddressToCustomerAddressBook_() {
    return this._saveShippingAddressToCustomerAddressBook;
  }

  public void setSaveShippingAddressToCustomerAddressBook_(
      Integer _saveShippingAddressToCustomerAddressBook) {
    this._saveShippingAddressToCustomerAddressBook = _saveShippingAddressToCustomerAddressBook;
  }

  public Integer getSaveBillingAddressToCustomerAddressBook_() {
    return this._saveBillingAddressToCustomerAddressBook;
  }

  public void setSaveBillingAddressToCustomerAddressBook_(
      Integer _saveBillingAddressToCustomerAddressBook) {
    this._saveBillingAddressToCustomerAddressBook = _saveBillingAddressToCustomerAddressBook;
  }

  public Integer getRefresh_() {
    return this._refresh;
  }

  public void setRefresh_(Integer _refresh) {
    this._refresh = _refresh;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPaymentStatus() {
    return this.paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getFulfillmentStatus() {
    return this.fulfillmentStatus;
  }

  public void setFulfillmentStatus(String fulfillmentStatus) {
    this.fulfillmentStatus = fulfillmentStatus;
  }

  public Boolean getEditable() {
    return this.editable;
  }

  public void setEditable(Boolean editable) {
    this.editable = editable;
  }

  public Boolean getPlaceable() {
    return this.placeable;
  }

  public void setPlaceable(Boolean placeable) {
    this.placeable = placeable;
  }

  public String getCurrencyCode() {
    return this.currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public Boolean getTaxIncluded() {
    return this.taxIncluded;
  }

  public void setTaxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
  }

  public Integer getTaxRate() {
    return this.taxRate;
  }

  public void setTaxRate(Integer taxRate) {
    this.taxRate = taxRate;
  }

  public Boolean getFreightTaxable() {
    return this.freightTaxable;
  }

  public void setFreightTaxable(Boolean freightTaxable) {
    this.freightTaxable = freightTaxable;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Integer getSubtotalAmountCents() {
    return this.subtotalAmountCents;
  }

  public void setSubtotalAmountCents(Integer subtotalAmountCents) {
    this.subtotalAmountCents = subtotalAmountCents;
  }

  public Integer getSubtotalAmountFloat() {
    return this.subtotalAmountFloat;
  }

  public void setSubtotalAmountFloat(Integer subtotalAmountFloat) {
    this.subtotalAmountFloat = subtotalAmountFloat;
  }

  public String getFormattedSubtotalAmount() {
    return this.formattedSubtotalAmount;
  }

  public void setFormattedSubtotalAmount(String formattedSubtotalAmount) {
    this.formattedSubtotalAmount = formattedSubtotalAmount;
  }

  public Integer getShippingAmountCents() {
    return this.shippingAmountCents;
  }

  public void setShippingAmountCents(Integer shippingAmountCents) {
    this.shippingAmountCents = shippingAmountCents;
  }

  public Integer getShippingAmountFloat() {
    return this.shippingAmountFloat;
  }

  public void setShippingAmountFloat(Integer shippingAmountFloat) {
    this.shippingAmountFloat = shippingAmountFloat;
  }

  public String getFormattedShippingAmount() {
    return this.formattedShippingAmount;
  }

  public void setFormattedShippingAmount(String formattedShippingAmount) {
    this.formattedShippingAmount = formattedShippingAmount;
  }

  public Integer getPaymentMethodAmountCents() {
    return this.paymentMethodAmountCents;
  }

  public void setPaymentMethodAmountCents(Integer paymentMethodAmountCents) {
    this.paymentMethodAmountCents = paymentMethodAmountCents;
  }

  public Integer getPaymentMethodAmountFloat() {
    return this.paymentMethodAmountFloat;
  }

  public void setPaymentMethodAmountFloat(Integer paymentMethodAmountFloat) {
    this.paymentMethodAmountFloat = paymentMethodAmountFloat;
  }

  public String getFormattedPaymentMethodAmount() {
    return this.formattedPaymentMethodAmount;
  }

  public void setFormattedPaymentMethodAmount(String formattedPaymentMethodAmount) {
    this.formattedPaymentMethodAmount = formattedPaymentMethodAmount;
  }

  public Integer getDiscountAmountCents() {
    return this.discountAmountCents;
  }

  public void setDiscountAmountCents(Integer discountAmountCents) {
    this.discountAmountCents = discountAmountCents;
  }

  public Integer getDiscountAmountFloat() {
    return this.discountAmountFloat;
  }

  public void setDiscountAmountFloat(Integer discountAmountFloat) {
    this.discountAmountFloat = discountAmountFloat;
  }

  public String getFormattedDiscountAmount() {
    return this.formattedDiscountAmount;
  }

  public void setFormattedDiscountAmount(String formattedDiscountAmount) {
    this.formattedDiscountAmount = formattedDiscountAmount;
  }

  public Integer getTotalTaxAmountCents() {
    return this.totalTaxAmountCents;
  }

  public void setTotalTaxAmountCents(Integer totalTaxAmountCents) {
    this.totalTaxAmountCents = totalTaxAmountCents;
  }

  public Integer getTotalTaxAmountFloat() {
    return this.totalTaxAmountFloat;
  }

  public void setTotalTaxAmountFloat(Integer totalTaxAmountFloat) {
    this.totalTaxAmountFloat = totalTaxAmountFloat;
  }

  public String getFormattedTotalTaxAmount() {
    return this.formattedTotalTaxAmount;
  }

  public void setFormattedTotalTaxAmount(String formattedTotalTaxAmount) {
    this.formattedTotalTaxAmount = formattedTotalTaxAmount;
  }

  public Integer getSubtotalTaxAmountCents() {
    return this.subtotalTaxAmountCents;
  }

  public void setSubtotalTaxAmountCents(Integer subtotalTaxAmountCents) {
    this.subtotalTaxAmountCents = subtotalTaxAmountCents;
  }

  public Integer getSubtotalTaxAmountFloat() {
    return this.subtotalTaxAmountFloat;
  }

  public void setSubtotalTaxAmountFloat(Integer subtotalTaxAmountFloat) {
    this.subtotalTaxAmountFloat = subtotalTaxAmountFloat;
  }

  public String getFormattedSubtotalTaxAmount() {
    return this.formattedSubtotalTaxAmount;
  }

  public void setFormattedSubtotalTaxAmount(String formattedSubtotalTaxAmount) {
    this.formattedSubtotalTaxAmount = formattedSubtotalTaxAmount;
  }

  public Integer getShippingTaxAmountCents() {
    return this.shippingTaxAmountCents;
  }

  public void setShippingTaxAmountCents(Integer shippingTaxAmountCents) {
    this.shippingTaxAmountCents = shippingTaxAmountCents;
  }

  public Integer getShippingTaxAmountFloat() {
    return this.shippingTaxAmountFloat;
  }

  public void setShippingTaxAmountFloat(Integer shippingTaxAmountFloat) {
    this.shippingTaxAmountFloat = shippingTaxAmountFloat;
  }

  public String getFormattedShippingTaxAmount() {
    return this.formattedShippingTaxAmount;
  }

  public void setFormattedShippingTaxAmount(String formattedShippingTaxAmount) {
    this.formattedShippingTaxAmount = formattedShippingTaxAmount;
  }

  public Integer getPaymentMethodTaxAmountCents() {
    return this.paymentMethodTaxAmountCents;
  }

  public void setPaymentMethodTaxAmountCents(Integer paymentMethodTaxAmountCents) {
    this.paymentMethodTaxAmountCents = paymentMethodTaxAmountCents;
  }

  public Integer getPaymentMethodTaxAmountFloat() {
    return this.paymentMethodTaxAmountFloat;
  }

  public void setPaymentMethodTaxAmountFloat(Integer paymentMethodTaxAmountFloat) {
    this.paymentMethodTaxAmountFloat = paymentMethodTaxAmountFloat;
  }

  public String getFormattedPaymentMethodTaxAmount() {
    return this.formattedPaymentMethodTaxAmount;
  }

  public void setFormattedPaymentMethodTaxAmount(String formattedPaymentMethodTaxAmount) {
    this.formattedPaymentMethodTaxAmount = formattedPaymentMethodTaxAmount;
  }

  public Integer getDiscountTaxAmountCents() {
    return this.discountTaxAmountCents;
  }

  public void setDiscountTaxAmountCents(Integer discountTaxAmountCents) {
    this.discountTaxAmountCents = discountTaxAmountCents;
  }

  public Integer getDiscountTaxAmountFloat() {
    return this.discountTaxAmountFloat;
  }

  public void setDiscountTaxAmountFloat(Integer discountTaxAmountFloat) {
    this.discountTaxAmountFloat = discountTaxAmountFloat;
  }

  public String getFormattedDiscountTaxAmount() {
    return this.formattedDiscountTaxAmount;
  }

  public void setFormattedDiscountTaxAmount(String formattedDiscountTaxAmount) {
    this.formattedDiscountTaxAmount = formattedDiscountTaxAmount;
  }

  public Integer getTotalAmountCents() {
    return this.totalAmountCents;
  }

  public void setTotalAmountCents(Integer totalAmountCents) {
    this.totalAmountCents = totalAmountCents;
  }

  public Integer getTotalAmountFloat() {
    return this.totalAmountFloat;
  }

  public void setTotalAmountFloat(Integer totalAmountFloat) {
    this.totalAmountFloat = totalAmountFloat;
  }

  public String getFormattedTotalAmount() {
    return this.formattedTotalAmount;
  }

  public void setFormattedTotalAmount(String formattedTotalAmount) {
    this.formattedTotalAmount = formattedTotalAmount;
  }

  public Integer getTotalTaxableAmountCents() {
    return this.totalTaxableAmountCents;
  }

  public void setTotalTaxableAmountCents(Integer totalTaxableAmountCents) {
    this.totalTaxableAmountCents = totalTaxableAmountCents;
  }

  public Integer getTotalTaxableAmountFloat() {
    return this.totalTaxableAmountFloat;
  }

  public void setTotalTaxableAmountFloat(Integer totalTaxableAmountFloat) {
    this.totalTaxableAmountFloat = totalTaxableAmountFloat;
  }

  public String getFormattedTotalTaxableAmount() {
    return this.formattedTotalTaxableAmount;
  }

  public void setFormattedTotalTaxableAmount(String formattedTotalTaxableAmount) {
    this.formattedTotalTaxableAmount = formattedTotalTaxableAmount;
  }

  public Integer getSubtotalTaxableAmountCents() {
    return this.subtotalTaxableAmountCents;
  }

  public void setSubtotalTaxableAmountCents(Integer subtotalTaxableAmountCents) {
    this.subtotalTaxableAmountCents = subtotalTaxableAmountCents;
  }

  public Integer getSubtotalTaxableAmountFloat() {
    return this.subtotalTaxableAmountFloat;
  }

  public void setSubtotalTaxableAmountFloat(Integer subtotalTaxableAmountFloat) {
    this.subtotalTaxableAmountFloat = subtotalTaxableAmountFloat;
  }

  public String getFormattedSubtotalTaxableAmount() {
    return this.formattedSubtotalTaxableAmount;
  }

  public void setFormattedSubtotalTaxableAmount(String formattedSubtotalTaxableAmount) {
    this.formattedSubtotalTaxableAmount = formattedSubtotalTaxableAmount;
  }

  public Integer getShippingTaxableAmountCents() {
    return this.shippingTaxableAmountCents;
  }

  public void setShippingTaxableAmountCents(Integer shippingTaxableAmountCents) {
    this.shippingTaxableAmountCents = shippingTaxableAmountCents;
  }

  public Integer getShippingTaxableAmountFloat() {
    return this.shippingTaxableAmountFloat;
  }

  public void setShippingTaxableAmountFloat(Integer shippingTaxableAmountFloat) {
    this.shippingTaxableAmountFloat = shippingTaxableAmountFloat;
  }

  public String getFormattedShippingTaxableAmount() {
    return this.formattedShippingTaxableAmount;
  }

  public void setFormattedShippingTaxableAmount(String formattedShippingTaxableAmount) {
    this.formattedShippingTaxableAmount = formattedShippingTaxableAmount;
  }

  public Integer getPaymentMethodTaxableAmountCents() {
    return this.paymentMethodTaxableAmountCents;
  }

  public void setPaymentMethodTaxableAmountCents(Integer paymentMethodTaxableAmountCents) {
    this.paymentMethodTaxableAmountCents = paymentMethodTaxableAmountCents;
  }

  public Integer getPaymentMethodTaxableAmountFloat() {
    return this.paymentMethodTaxableAmountFloat;
  }

  public void setPaymentMethodTaxableAmountFloat(Integer paymentMethodTaxableAmountFloat) {
    this.paymentMethodTaxableAmountFloat = paymentMethodTaxableAmountFloat;
  }

  public String getFormattedPaymentMethodTaxableAmount() {
    return this.formattedPaymentMethodTaxableAmount;
  }

  public void setFormattedPaymentMethodTaxableAmount(String formattedPaymentMethodTaxableAmount) {
    this.formattedPaymentMethodTaxableAmount = formattedPaymentMethodTaxableAmount;
  }

  public Integer getDiscountTaxableAmountCents() {
    return this.discountTaxableAmountCents;
  }

  public void setDiscountTaxableAmountCents(Integer discountTaxableAmountCents) {
    this.discountTaxableAmountCents = discountTaxableAmountCents;
  }

  public Integer getDiscountTaxableAmountFloat() {
    return this.discountTaxableAmountFloat;
  }

  public void setDiscountTaxableAmountFloat(Integer discountTaxableAmountFloat) {
    this.discountTaxableAmountFloat = discountTaxableAmountFloat;
  }

  public String getFormattedDiscountTaxableAmount() {
    return this.formattedDiscountTaxableAmount;
  }

  public void setFormattedDiscountTaxableAmount(String formattedDiscountTaxableAmount) {
    this.formattedDiscountTaxableAmount = formattedDiscountTaxableAmount;
  }

  public Integer getTotalAmountWithTaxesCents() {
    return this.totalAmountWithTaxesCents;
  }

  public void setTotalAmountWithTaxesCents(Integer totalAmountWithTaxesCents) {
    this.totalAmountWithTaxesCents = totalAmountWithTaxesCents;
  }

  public Integer getTotalAmountWithTaxesFloat() {
    return this.totalAmountWithTaxesFloat;
  }

  public void setTotalAmountWithTaxesFloat(Integer totalAmountWithTaxesFloat) {
    this.totalAmountWithTaxesFloat = totalAmountWithTaxesFloat;
  }

  public String getFormattedTotalAmountWithTaxes() {
    return this.formattedTotalAmountWithTaxes;
  }

  public void setFormattedTotalAmountWithTaxes(String formattedTotalAmountWithTaxes) {
    this.formattedTotalAmountWithTaxes = formattedTotalAmountWithTaxes;
  }

  public Integer getFeesAmountCents() {
    return this.feesAmountCents;
  }

  public void setFeesAmountCents(Integer feesAmountCents) {
    this.feesAmountCents = feesAmountCents;
  }

  public Integer getFeesAmountFloat() {
    return this.feesAmountFloat;
  }

  public void setFeesAmountFloat(Integer feesAmountFloat) {
    this.feesAmountFloat = feesAmountFloat;
  }

  public String getFormattedFeesAmount() {
    return this.formattedFeesAmount;
  }

  public void setFormattedFeesAmount(String formattedFeesAmount) {
    this.formattedFeesAmount = formattedFeesAmount;
  }

  public Integer getSkusCount() {
    return this.skusCount;
  }

  public void setSkusCount(Integer skusCount) {
    this.skusCount = skusCount;
  }

  public Object getPaymentSourceDetails() {
    return this.paymentSourceDetails;
  }

  public void setPaymentSourceDetails(Object paymentSourceDetails) {
    this.paymentSourceDetails = paymentSourceDetails;
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getCheckoutUrl() {
    return this.checkoutUrl;
  }

  public void setCheckoutUrl(String checkoutUrl) {
    this.checkoutUrl = checkoutUrl;
  }

  public String getPlacedAt() {
    return this.placedAt;
  }

  public void setPlacedAt(String placedAt) {
    this.placedAt = placedAt;
  }

  public String getApprovedAt() {
    return this.approvedAt;
  }

  public void setApprovedAt(String approvedAt) {
    this.approvedAt = approvedAt;
  }

  public String getCancelledAt() {
    return this.cancelledAt;
  }

  public void setCancelledAt(String cancelledAt) {
    this.cancelledAt = cancelledAt;
  }

  public String getPaymentUpdatedAt() {
    return this.paymentUpdatedAt;
  }

  public void setPaymentUpdatedAt(String paymentUpdatedAt) {
    this.paymentUpdatedAt = paymentUpdatedAt;
  }

  public String getFulfillmentUpdatedAt() {
    return this.fulfillmentUpdatedAt;
  }

  public void setFulfillmentUpdatedAt(String fulfillmentUpdatedAt) {
    this.fulfillmentUpdatedAt = fulfillmentUpdatedAt;
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

  public HasOne<Customer> getCustomer() {
    return this.customer;
  }

  public void setCustomer(HasOne<Customer> customer) {
    this.customer = customer;
  }

  public Customer getCustomerResource() {
    return getCustomer().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getCustomerLinksMap() {
    return (Map<String, String>)getCustomer().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Address> getShippingAddress() {
    return this.shippingAddress;
  }

  public void setShippingAddress(HasOne<Address> shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public Address getShippingAddressResource() {
    return getShippingAddress().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShippingAddressLinksMap() {
    return (Map<String, String>)getShippingAddress().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<Address> getBillingAddress() {
    return this.billingAddress;
  }

  public void setBillingAddress(HasOne<Address> billingAddress) {
    this.billingAddress = billingAddress;
  }

  public Address getBillingAddressResource() {
    return getBillingAddress().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getBillingAddressLinksMap() {
    return (Map<String, String>)getBillingAddress().getLinks().get(new CLLinksAdapter());
  }

  public HasOne<PaymentMethod> getPaymentMethod() {
    return this.paymentMethod;
  }

  public void setPaymentMethod(HasOne<PaymentMethod> paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public PaymentMethod getPaymentMethodResource() {
    return getPaymentMethod().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getPaymentMethodLinksMap() {
    return (Map<String, String>)getPaymentMethod().getLinks().get(new CLLinksAdapter());
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

  @SuppressWarnings("unchecked")
  public Map<String, String> getPaymentSourceLinksMap() {
    return (Map<String, String>)getPaymentSource().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<LineItem> getLineItems() {
    return this.lineItems;
  }

  public void setLineItems(HasMany<LineItem> lineItems) {
    this.lineItems = lineItems;
  }

  public List<LineItem> getLineItemResourceList() {
    return getLineItems().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getLineItemsLinksMap() {
    return (Map<String, String>)getLineItems().getLinks().get(new CLLinksAdapter());
  }

  public HasMany<Shipment> getShipments() {
    return this.shipments;
  }

  public void setShipments(HasMany<Shipment> shipments) {
    this.shipments = shipments;
  }

  public List<Shipment> getShipmentResourceList() {
    return getShipments().get(getDocument());
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShipmentsLinksMap() {
    return (Map<String, String>)getShipments().getLinks().get(new CLLinksAdapter());
  }
}
