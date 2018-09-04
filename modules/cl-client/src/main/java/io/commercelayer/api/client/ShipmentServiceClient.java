package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.AvailableShippingMethod;
import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.ShipmentLineItem;
import io.commercelayer.api.model.ShippingAddress;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ShipmentService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class ShipmentServiceClient extends AbstractServiceClient {
  protected ShipmentService service;

  public ShipmentServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(ShipmentService.class, Shipment.class);
  }

  public ShipmentServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(ShipmentService.class, Shipment.class);
  }

  public List<Shipment> listShipments(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Shipment>> call = service.listShipments(queryStringParams);
    return syncCall(call);
  }

  public void listShipments(Map<String, String> queryStringParams,
      ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listShipments(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Shipment> listShipments() throws ApiException {
    Call<List<Shipment>> call = service.listShipments();
    return syncCall(call);
  }

  public void listShipments(ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listShipments();
    asyncCall(call, callback);
  }

  public Shipment createShipment(Shipment shipment) throws ApiException {
    Call<Shipment> call = service.createShipment(shipment);
    return syncCall(call);
  }

  public void createShipment(Shipment shipment, ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.createShipment(shipment);
    asyncCall(call, callback);
  }

  public void deleteShipment(String shipmentId) throws ApiException {
    Call<Void> call = service.deleteShipment(shipmentId);
    syncCall(call);
  }

  public void deleteShipment(String shipmentId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteShipment(shipmentId);
    asyncCall(call, callback);
  }

  public Shipment updateShipment(String shipmentId, Shipment shipment) throws ApiException {
    Call<Shipment> call = service.updateShipment(shipmentId, shipment);
    return syncCall(call);
  }

  public void updateShipment(String shipmentId, Shipment shipment, ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.updateShipment(shipmentId, shipment);
    asyncCall(call, callback);
  }

  public Shipment retrieveShipment(String shipmentId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Shipment> call = service.retrieveShipment(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShipment(String shipmentId, Map<String, String> queryStringParams,
      ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveShipment(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public Shipment retrieveShipment(String shipmentId) throws ApiException {
    Call<Shipment> call = service.retrieveShipment(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipment(String shipmentId, ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveShipment(shipmentId);
    asyncCall(call, callback);
  }

  public List<AvailableShippingMethod> listShipmentAvailableShippingMethods(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<AvailableShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void listShipmentAvailableShippingMethods(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<List<AvailableShippingMethod>> callback) {
    Call<List<AvailableShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<AvailableShippingMethod> listShipmentAvailableShippingMethods(String shipmentId)
      throws ApiException {
    Call<List<AvailableShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId);
    return syncCall(call);
  }

  public void listShipmentAvailableShippingMethods(String shipmentId,
      ApiCallback<List<AvailableShippingMethod>> callback) {
    Call<List<AvailableShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId);
    asyncCall(call, callback);
  }

  public List<Parcel> listShipmentParcels(String shipmentId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void listShipmentParcels(String shipmentId, Map<String, String> queryStringParams,
      ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<Parcel> listShipmentParcels(String shipmentId) throws ApiException {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId);
    return syncCall(call);
  }

  public void listShipmentParcels(String shipmentId, ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId);
    asyncCall(call, callback);
  }

  public List<ShipmentLineItem> listShipmentShipmentLineItems(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<List<ShipmentLineItem>> call = service.listShipmentShipmentLineItems(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void listShipmentShipmentLineItems(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<List<ShipmentLineItem>> callback) {
    Call<List<ShipmentLineItem>> call = service.listShipmentShipmentLineItems(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<ShipmentLineItem> listShipmentShipmentLineItems(String shipmentId) throws
      ApiException {
    Call<List<ShipmentLineItem>> call = service.listShipmentShipmentLineItems(shipmentId);
    return syncCall(call);
  }

  public void listShipmentShipmentLineItems(String shipmentId,
      ApiCallback<List<ShipmentLineItem>> callback) {
    Call<List<ShipmentLineItem>> call = service.listShipmentShipmentLineItems(shipmentId);
    asyncCall(call, callback);
  }

  public ShippingAddress retrieveShipmentShippingAddress(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingAddress> call = service.retrieveShipmentShippingAddress(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShipmentShippingAddress(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<ShippingAddress> callback) {
    Call<ShippingAddress> call = service.retrieveShipmentShippingAddress(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingAddress retrieveShipmentShippingAddress(String shipmentId) throws ApiException {
    Call<ShippingAddress> call = service.retrieveShipmentShippingAddress(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipmentShippingAddress(String shipmentId,
      ApiCallback<ShippingAddress> callback) {
    Call<ShippingAddress> call = service.retrieveShipmentShippingAddress(shipmentId);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShipmentShippingCategory(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShipmentShippingCategory(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShipmentShippingCategory(String shipmentId) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipmentShippingCategory(String shipmentId,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveShipmentShippingMethod(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShipmentShippingMethod(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveShipmentShippingMethod(String shipmentId) throws ApiException {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipmentShippingMethod(String shipmentId,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId);
    asyncCall(call, callback);
  }

  public StockLocation retrieveShipmentStockLocation(String shipmentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShipmentStockLocation(String shipmentId,
      Map<String, String> queryStringParams, ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId, queryStringParams);
    asyncCall(call, callback);
  }

  public StockLocation retrieveShipmentStockLocation(String shipmentId) throws ApiException {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipmentStockLocation(String shipmentId,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId);
    asyncCall(call, callback);
  }
}
