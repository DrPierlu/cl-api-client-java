package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.ShippingZone;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ShippingMethodService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class ShippingMethodServiceClient extends AbstractServiceClient {
  protected final ShippingMethodService service;

  {
    this.service = initServiceCallFactory(ShippingMethodService.class, ShippingMethod.class);
  }

  public ShippingMethodServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public ShippingMethodServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<ShippingMethod> listShippingMethods(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<ShippingMethod>> call = service.listShippingMethods(queryStringParams);
    return syncCall(call);
  }

  public void listShippingMethods(Map<String, String> queryStringParams,
      ApiCallback<List<ShippingMethod>> callback) {
    Call<List<ShippingMethod>> call = service.listShippingMethods(queryStringParams);
    asyncCall(call, callback);
  }

  public List<ShippingMethod> listShippingMethods() throws ApiException {
    Call<List<ShippingMethod>> call = service.listShippingMethods();
    return syncCall(call);
  }

  public void listShippingMethods(ApiCallback<List<ShippingMethod>> callback) {
    Call<List<ShippingMethod>> call = service.listShippingMethods();
    asyncCall(call, callback);
  }

  public ShippingMethod createShippingMethod(ShippingMethod shippingMethod) throws ApiException {
    Call<ShippingMethod> call = service.createShippingMethod(shippingMethod);
    return syncCall(call);
  }

  public void createShippingMethod(ShippingMethod shippingMethod,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.createShippingMethod(shippingMethod);
    asyncCall(call, callback);
  }

  public void deleteShippingMethod(String shippingMethodId) throws ApiException {
    Call<Void> call = service.deleteShippingMethod(shippingMethodId);
    syncCall(call);
  }

  public void deleteShippingMethod(String shippingMethodId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteShippingMethod(shippingMethodId);
    asyncCall(call, callback);
  }

  public ShippingMethod updateShippingMethod(String shippingMethodId, ShippingMethod shippingMethod)
      throws ApiException {
    Call<ShippingMethod> call = service.updateShippingMethod(shippingMethodId, shippingMethod);
    return syncCall(call);
  }

  public void updateShippingMethod(String shippingMethodId, ShippingMethod shippingMethod,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.updateShippingMethod(shippingMethodId, shippingMethod);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveShippingMethod(String shippingMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingMethod> call = service.retrieveShippingMethod(shippingMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingMethod(String shippingMethodId, Map<String, String> queryStringParams,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveShippingMethod(shippingMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveShippingMethod(String shippingMethodId) throws ApiException {
    Call<ShippingMethod> call = service.retrieveShippingMethod(shippingMethodId);
    return syncCall(call);
  }

  public void retrieveShippingMethod(String shippingMethodId,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveShippingMethod(shippingMethodId);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> retrieveShippingMethodDeliveryLeadTimeForShipment(
      String shippingMethodId, Map<String, String> queryStringParams) throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.retrieveShippingMethodDeliveryLeadTimeForShipment(shippingMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingMethodDeliveryLeadTimeForShipment(String shippingMethodId,
      Map<String, String> queryStringParams, ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.retrieveShippingMethodDeliveryLeadTimeForShipment(shippingMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> retrieveShippingMethodDeliveryLeadTimeForShipment(
      String shippingMethodId) throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.retrieveShippingMethodDeliveryLeadTimeForShipment(shippingMethodId);
    return syncCall(call);
  }

  public void retrieveShippingMethodDeliveryLeadTimeForShipment(String shippingMethodId,
      ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.retrieveShippingMethodDeliveryLeadTimeForShipment(shippingMethodId);
    asyncCall(call, callback);
  }

  public Market retrieveShippingMethodMarket(String shippingMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Market> call = service.retrieveShippingMethodMarket(shippingMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingMethodMarket(String shippingMethodId,
      Map<String, String> queryStringParams, ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveShippingMethodMarket(shippingMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public Market retrieveShippingMethodMarket(String shippingMethodId) throws ApiException {
    Call<Market> call = service.retrieveShippingMethodMarket(shippingMethodId);
    return syncCall(call);
  }

  public void retrieveShippingMethodMarket(String shippingMethodId, ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveShippingMethodMarket(shippingMethodId);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShippingMethodShippingCategory(String shippingMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingCategory> call = service.retrieveShippingMethodShippingCategory(shippingMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingMethodShippingCategory(String shippingMethodId,
      Map<String, String> queryStringParams, ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShippingMethodShippingCategory(shippingMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingCategory retrieveShippingMethodShippingCategory(String shippingMethodId) throws
      ApiException {
    Call<ShippingCategory> call = service.retrieveShippingMethodShippingCategory(shippingMethodId);
    return syncCall(call);
  }

  public void retrieveShippingMethodShippingCategory(String shippingMethodId,
      ApiCallback<ShippingCategory> callback) {
    Call<ShippingCategory> call = service.retrieveShippingMethodShippingCategory(shippingMethodId);
    asyncCall(call, callback);
  }

  public ShippingZone retrieveShippingMethodShippingZone(String shippingMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingZone> call = service.retrieveShippingMethodShippingZone(shippingMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingMethodShippingZone(String shippingMethodId,
      Map<String, String> queryStringParams, ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.retrieveShippingMethodShippingZone(shippingMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingZone retrieveShippingMethodShippingZone(String shippingMethodId) throws
      ApiException {
    Call<ShippingZone> call = service.retrieveShippingMethodShippingZone(shippingMethodId);
    return syncCall(call);
  }

  public void retrieveShippingMethodShippingZone(String shippingMethodId,
      ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.retrieveShippingMethodShippingZone(shippingMethodId);
    asyncCall(call, callback);
  }
}
