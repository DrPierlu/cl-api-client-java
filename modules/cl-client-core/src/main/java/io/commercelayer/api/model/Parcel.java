package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.Boolean;
import java.lang.Float;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "parcels"
)
public class Parcel extends ApiResource {
  public static final long serialVersionUID = -1;

  private Float weight;

  @Json(
      name = "unit_of_weight"
  )
  private String unitOfWeight;

  @Json(
      name = "eel_pfc"
  )
  private String eelPfc;

  @Json(
      name = "contents_type"
  )
  private String contentsType;

  @Json(
      name = "contents_explanation"
  )
  private String contentsExplanation;

  @Json(
      name = "customs_certify"
  )
  private Boolean customsCertify;

  @Json(
      name = "customs_signer"
  )
  private String customsSigner;

  @Json(
      name = "non_delivery_option"
  )
  private String nonDeliveryOption;

  @Json(
      name = "restriction_type"
  )
  private String restrictionType;

  @Json(
      name = "restriction_comments"
  )
  private String restrictionComments;

  @Json(
      name = "customs_info_required"
  )
  private Boolean customsInfoRequired;

  @Json(
      name = "shipping_label_url"
  )
  private String shippingLabelUrl;

  @Json(
      name = "shipping_label_file_type"
  )
  private String shippingLabelFileType;

  @Json(
      name = "shipping_label_size"
  )
  private String shippingLabelSize;

  @Json(
      name = "shipping_label_resolution"
  )
  private String shippingLabelResolution;

  @Json(
      name = "tracking_number"
  )
  private String trackingNumber;

  @Json(
      name = "tracking_status"
  )
  private String trackingStatus;

  @Json(
      name = "tracking_status_detail"
  )
  private String trackingStatusDetail;

  @Json(
      name = "tracking_status_updated_at"
  )
  private String trackingStatusUpdatedAt;

  @Json(
      name = "tracking_details"
  )
  private String trackingDetails;

  @Json(
      name = "carrier_weight_oz"
  )
  private String carrierWeightOz;

  @Json(
      name = "signed_by"
  )
  private String signedBy;

  private HasOne<Shipment> shipment;

  public Float getWeight() {
    return this.weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public String getUnitOfWeight() {
    return this.unitOfWeight;
  }

  public void setUnitOfWeight(String unitOfWeight) {
    this.unitOfWeight = unitOfWeight;
  }

  public String getEelPfc() {
    return this.eelPfc;
  }

  public void setEelPfc(String eelPfc) {
    this.eelPfc = eelPfc;
  }

  public String getContentsType() {
    return this.contentsType;
  }

  public void setContentsType(String contentsType) {
    this.contentsType = contentsType;
  }

  public String getContentsExplanation() {
    return this.contentsExplanation;
  }

  public void setContentsExplanation(String contentsExplanation) {
    this.contentsExplanation = contentsExplanation;
  }

  public Boolean getCustomsCertify() {
    return this.customsCertify;
  }

  public void setCustomsCertify(Boolean customsCertify) {
    this.customsCertify = customsCertify;
  }

  public String getCustomsSigner() {
    return this.customsSigner;
  }

  public void setCustomsSigner(String customsSigner) {
    this.customsSigner = customsSigner;
  }

  public String getNonDeliveryOption() {
    return this.nonDeliveryOption;
  }

  public void setNonDeliveryOption(String nonDeliveryOption) {
    this.nonDeliveryOption = nonDeliveryOption;
  }

  public String getRestrictionType() {
    return this.restrictionType;
  }

  public void setRestrictionType(String restrictionType) {
    this.restrictionType = restrictionType;
  }

  public String getRestrictionComments() {
    return this.restrictionComments;
  }

  public void setRestrictionComments(String restrictionComments) {
    this.restrictionComments = restrictionComments;
  }

  public Boolean getCustomsInfoRequired() {
    return this.customsInfoRequired;
  }

  public void setCustomsInfoRequired(Boolean customsInfoRequired) {
    this.customsInfoRequired = customsInfoRequired;
  }

  public String getShippingLabelUrl() {
    return this.shippingLabelUrl;
  }

  public void setShippingLabelUrl(String shippingLabelUrl) {
    this.shippingLabelUrl = shippingLabelUrl;
  }

  public String getShippingLabelFileType() {
    return this.shippingLabelFileType;
  }

  public void setShippingLabelFileType(String shippingLabelFileType) {
    this.shippingLabelFileType = shippingLabelFileType;
  }

  public String getShippingLabelSize() {
    return this.shippingLabelSize;
  }

  public void setShippingLabelSize(String shippingLabelSize) {
    this.shippingLabelSize = shippingLabelSize;
  }

  public String getShippingLabelResolution() {
    return this.shippingLabelResolution;
  }

  public void setShippingLabelResolution(String shippingLabelResolution) {
    this.shippingLabelResolution = shippingLabelResolution;
  }

  public String getTrackingNumber() {
    return this.trackingNumber;
  }

  public void setTrackingNumber(String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public String getTrackingStatus() {
    return this.trackingStatus;
  }

  public void setTrackingStatus(String trackingStatus) {
    this.trackingStatus = trackingStatus;
  }

  public String getTrackingStatusDetail() {
    return this.trackingStatusDetail;
  }

  public void setTrackingStatusDetail(String trackingStatusDetail) {
    this.trackingStatusDetail = trackingStatusDetail;
  }

  public String getTrackingStatusUpdatedAt() {
    return this.trackingStatusUpdatedAt;
  }

  public void setTrackingStatusUpdatedAt(String trackingStatusUpdatedAt) {
    this.trackingStatusUpdatedAt = trackingStatusUpdatedAt;
  }

  public String getTrackingDetails() {
    return this.trackingDetails;
  }

  public void setTrackingDetails(String trackingDetails) {
    this.trackingDetails = trackingDetails;
  }

  public String getCarrierWeightOz() {
    return this.carrierWeightOz;
  }

  public void setCarrierWeightOz(String carrierWeightOz) {
    this.carrierWeightOz = carrierWeightOz;
  }

  public String getSignedBy() {
    return this.signedBy;
  }

  public void setSignedBy(String signedBy) {
    this.signedBy = signedBy;
  }

  public HasOne<Shipment> getShipment() {
    return this.shipment;
  }

  public void setShipment(HasOne<Shipment> shipment) {
    this.shipment = shipment;
  }

  public Shipment getShipmentResource() {
    return getShipment().get(getDocument());
  }

  public void setShipmentResource(Shipment shipment) {
    setShipment(new HasOne<Shipment>(shipment));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getShipmentLinksMap() {
    return (Map<String, String>)getShipment().getLinks().get(new CLLinksAdapter());
  }
}
