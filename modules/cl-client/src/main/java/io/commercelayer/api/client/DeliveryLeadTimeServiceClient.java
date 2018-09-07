package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.StockLocation;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.DeliveryLeadTimeService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class DeliveryLeadTimeServiceClient extends AbstractServiceClient {
  protected final DeliveryLeadTimeService service;

  {
    this.service = initServiceCallFactory(DeliveryLeadTimeService.class, DeliveryLeadTime.class);
  }

  public DeliveryLeadTimeServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws
      AuthException {
    super(apiOrg, apiAuth);
  }

  public DeliveryLeadTimeServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<DeliveryLeadTime> listDeliveryLeadTimes(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<DeliveryLeadTime>> call = service.listDeliveryLeadTimes(queryStringParams);
    return syncCall(call);
  }

  public void listDeliveryLeadTimes(Map<String, String> queryStringParams,
      ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.listDeliveryLeadTimes(queryStringParams);
    asyncCall(call, callback);
  }

  public List<DeliveryLeadTime> listDeliveryLeadTimes() throws ApiException {
    Call<List<DeliveryLeadTime>> call = service.listDeliveryLeadTimes();
    return syncCall(call);
  }

  public void listDeliveryLeadTimes(ApiCallback<List<DeliveryLeadTime>> callback) {
    Call<List<DeliveryLeadTime>> call = service.listDeliveryLeadTimes();
    asyncCall(call, callback);
  }

  public DeliveryLeadTime createDeliveryLeadTime(DeliveryLeadTime deliveryLeadTime) throws
      ApiException {
    Call<DeliveryLeadTime> call = service.createDeliveryLeadTime(deliveryLeadTime);
    return syncCall(call);
  }

  public void createDeliveryLeadTime(DeliveryLeadTime deliveryLeadTime,
      ApiCallback<DeliveryLeadTime> callback) {
    Call<DeliveryLeadTime> call = service.createDeliveryLeadTime(deliveryLeadTime);
    asyncCall(call, callback);
  }

  public void deleteDeliveryLeadTime(String deliveryLeadTimeId) throws ApiException {
    Call<Void> call = service.deleteDeliveryLeadTime(deliveryLeadTimeId);
    syncCall(call);
  }

  public void deleteDeliveryLeadTime(String deliveryLeadTimeId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteDeliveryLeadTime(deliveryLeadTimeId);
    asyncCall(call, callback);
  }

  public DeliveryLeadTime updateDeliveryLeadTime(String deliveryLeadTimeId,
      DeliveryLeadTime deliveryLeadTime) throws ApiException {
    Call<DeliveryLeadTime> call = service.updateDeliveryLeadTime(deliveryLeadTimeId, deliveryLeadTime);
    return syncCall(call);
  }

  public void updateDeliveryLeadTime(String deliveryLeadTimeId, DeliveryLeadTime deliveryLeadTime,
      ApiCallback<DeliveryLeadTime> callback) {
    Call<DeliveryLeadTime> call = service.updateDeliveryLeadTime(deliveryLeadTimeId, deliveryLeadTime);
    asyncCall(call, callback);
  }

  public DeliveryLeadTime retrieveDeliveryLeadTime(String deliveryLeadTimeId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<DeliveryLeadTime> call = service.retrieveDeliveryLeadTime(deliveryLeadTimeId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTime(String deliveryLeadTimeId,
      Map<String, String> queryStringParams, ApiCallback<DeliveryLeadTime> callback) {
    Call<DeliveryLeadTime> call = service.retrieveDeliveryLeadTime(deliveryLeadTimeId, queryStringParams);
    asyncCall(call, callback);
  }

  public DeliveryLeadTime retrieveDeliveryLeadTime(String deliveryLeadTimeId) throws ApiException {
    Call<DeliveryLeadTime> call = service.retrieveDeliveryLeadTime(deliveryLeadTimeId);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTime(String deliveryLeadTimeId,
      ApiCallback<DeliveryLeadTime> callback) {
    Call<DeliveryLeadTime> call = service.retrieveDeliveryLeadTime(deliveryLeadTimeId);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveDeliveryLeadTimeShippingMethod(String deliveryLeadTimeId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingMethod> call = service.retrieveDeliveryLeadTimeShippingMethod(deliveryLeadTimeId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTimeShippingMethod(String deliveryLeadTimeId,
      Map<String, String> queryStringParams, ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveDeliveryLeadTimeShippingMethod(deliveryLeadTimeId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingMethod retrieveDeliveryLeadTimeShippingMethod(String deliveryLeadTimeId) throws
      ApiException {
    Call<ShippingMethod> call = service.retrieveDeliveryLeadTimeShippingMethod(deliveryLeadTimeId);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTimeShippingMethod(String deliveryLeadTimeId,
      ApiCallback<ShippingMethod> callback) {
    Call<ShippingMethod> call = service.retrieveDeliveryLeadTimeShippingMethod(deliveryLeadTimeId);
    asyncCall(call, callback);
  }

  public StockLocation retrieveDeliveryLeadTimeStockLocation(String deliveryLeadTimeId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<StockLocation> call = service.retrieveDeliveryLeadTimeStockLocation(deliveryLeadTimeId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTimeStockLocation(String deliveryLeadTimeId,
      Map<String, String> queryStringParams, ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveDeliveryLeadTimeStockLocation(deliveryLeadTimeId, queryStringParams);
    asyncCall(call, callback);
  }

  public StockLocation retrieveDeliveryLeadTimeStockLocation(String deliveryLeadTimeId) throws
      ApiException {
    Call<StockLocation> call = service.retrieveDeliveryLeadTimeStockLocation(deliveryLeadTimeId);
    return syncCall(call);
  }

  public void retrieveDeliveryLeadTimeStockLocation(String deliveryLeadTimeId,
      ApiCallback<StockLocation> callback) {
    Call<StockLocation> call = service.retrieveDeliveryLeadTimeStockLocation(deliveryLeadTimeId);
    asyncCall(call, callback);
  }
}
