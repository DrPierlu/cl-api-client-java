package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ShipmentService;
import java.util.List;
import retrofit2.Call;

public class ShipmentServiceClient extends AbstractServiceClient {
  protected final ShipmentService service;

  {
    this.service = initServiceCallFactory(ShipmentService.class, Shipment.class);
  }

  public ShipmentServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public ShipmentServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Shipment> listShipments(QueryFilter queryFilter) throws ApiException {
    Call<List<Shipment>> call = service.listShipments(queryFilter);
    return syncCall(call);
  }

  public void listShipments(QueryFilter queryFilter, ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listShipments(queryFilter);
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

  public Shipment retrieveShipment(String shipmentId, QueryFilter queryFilter) throws ApiException {
    Call<Shipment> call = service.retrieveShipment(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void retrieveShipment(String shipmentId, QueryFilter queryFilter,
      ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveShipment(shipmentId, queryFilter);
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

  public List<ShippingMethod> listShipmentAvailableShippingMethods(String shipmentId,
      QueryFilter queryFilter) throws ApiException {
    Call<List<ShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void listShipmentAvailableShippingMethods(String shipmentId, QueryFilter queryFilter,
      ApiCallback<List<ShippingMethod>> callback) {
    Call<List<ShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId, queryFilter);
    asyncCall(call, callback);
  }

  public List<ShippingMethod> listShipmentAvailableShippingMethods(String shipmentId) throws
      ApiException {
    Call<List<ShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId);
    return syncCall(call);
  }

  public void listShipmentAvailableShippingMethods(String shipmentId,
      ApiCallback<List<ShippingMethod>> callback) {
    Call<List<ShippingMethod>> call = service.listShipmentAvailableShippingMethods(shipmentId);
    asyncCall(call, callback);
  }

  public List<Parcel> listShipmentParcels(String shipmentId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void listShipmentParcels(String shipmentId, QueryFilter queryFilter,
      ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listShipmentParcels(shipmentId, queryFilter);
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

  public List<LineItem> listShipmentShipmentLineItems(String shipmentId, QueryFilter queryFilter)
      throws ApiException {
    Call<List<LineItem>> call = service.listShipmentShipmentLineItems(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void listShipmentShipmentLineItems(String shipmentId, QueryFilter queryFilter,
      ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listShipmentShipmentLineItems(shipmentId, queryFilter);
    asyncCall(call, callback);
  }

  public List<LineItem> listShipmentShipmentLineItems(String shipmentId) throws ApiException {
    Call<List<LineItem>> call = service.listShipmentShipmentLineItems(shipmentId);
    return syncCall(call);
  }

  public void listShipmentShipmentLineItems(String shipmentId,
      ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listShipmentShipmentLineItems(shipmentId);
    asyncCall(call, callback);
  }

  public List<Address> retrieveShipmentShippingAddress(String shipmentId, QueryFilter queryFilter)
      throws ApiException {
    Call<List<Address>> call = service.retrieveShipmentShippingAddress(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void retrieveShipmentShippingAddress(String shipmentId, QueryFilter queryFilter,
      ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveShipmentShippingAddress(shipmentId, queryFilter);
    asyncCall(call, callback);
  }

  public List<Address> retrieveShipmentShippingAddress(String shipmentId) throws ApiException {
    Call<List<Address>> call = service.retrieveShipmentShippingAddress(shipmentId);
    return syncCall(call);
  }

  public void retrieveShipmentShippingAddress(String shipmentId,
      ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveShipmentShippingAddress(shipmentId);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShipmentShippingCategory(String shipmentId,
      QueryFilter queryFilter) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void retrieveShipmentShippingCategory(String shipmentId, QueryFilter queryFilter,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShipmentShippingCategory(shipmentId, queryFilter);
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

  public ShippingMethod retrieveShipmentShippingMethod(String shipmentId, QueryFilter queryFilter)
      throws ApiException {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void retrieveShipmentShippingMethod(String shipmentId, QueryFilter queryFilter,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveShipmentShippingMethod(shipmentId, queryFilter);
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

  public StockLocation retrieveShipmentStockLocation(String shipmentId, QueryFilter queryFilter)
      throws ApiException {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId, queryFilter);
    return syncCall(call);
  }

  public void retrieveShipmentStockLocation(String shipmentId, QueryFilter queryFilter,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveShipmentStockLocation(shipmentId, queryFilter);
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
