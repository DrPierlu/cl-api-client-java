package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.ShippingZone;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ShippingZoneService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class ShippingZoneServiceClient extends AbstractServiceClient {
  protected ShippingZoneService service;

  public ShippingZoneServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(ShippingZoneService.class, ShippingZone.class);
  }

  public ShippingZoneServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(ShippingZoneService.class, ShippingZone.class);
  }

  public ShippingZone createShippingZone(ShippingZone shippingZone) throws ApiException {
    Call<ShippingZone> call = service.createShippingZone(shippingZone);
    return syncCall(call);
  }

  public void createShippingZone(ShippingZone shippingZone, ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.createShippingZone(shippingZone);
    asyncCall(call, callback);
  }

  public List<ShippingZone> listShippingZones(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<ShippingZone>> call = service.listShippingZones(queryStringParams);
    return syncCall(call);
  }

  public void listShippingZones(Map<String, String> queryStringParams,
      ApiCallback<List<ShippingZone>> callback) {
    Call<List<ShippingZone>> call = service.listShippingZones(queryStringParams);
    asyncCall(call, callback);
  }

  public List<ShippingZone> listShippingZones() throws ApiException {
    Call<List<ShippingZone>> call = service.listShippingZones();
    return syncCall(call);
  }

  public void listShippingZones(ApiCallback<List<ShippingZone>> callback) {
    Call<List<ShippingZone>> call = service.listShippingZones();
    asyncCall(call, callback);
  }

  public void deleteShippingZone(String shippingZoneId) throws ApiException {
    Call<Void> call = service.deleteShippingZone(shippingZoneId);
    syncCall(call);
  }

  public void deleteShippingZone(String shippingZoneId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteShippingZone(shippingZoneId);
    asyncCall(call, callback);
  }

  public ShippingZone updateShippingZone(String shippingZoneId, ShippingZone shippingZone) throws
      ApiException {
    Call<ShippingZone> call = service.updateShippingZone(shippingZoneId, shippingZone);
    return syncCall(call);
  }

  public void updateShippingZone(String shippingZoneId, ShippingZone shippingZone,
      ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.updateShippingZone(shippingZoneId, shippingZone);
    asyncCall(call, callback);
  }

  public ShippingZone retrieveShippingZone(String shippingZoneId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingZone> call = service.retrieveShippingZone(shippingZoneId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveShippingZone(String shippingZoneId, Map<String, String> queryStringParams,
      ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.retrieveShippingZone(shippingZoneId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingZone retrieveShippingZone(String shippingZoneId) throws ApiException {
    Call<ShippingZone> call = service.retrieveShippingZone(shippingZoneId);
    return syncCall(call);
  }

  public void retrieveShippingZone(String shippingZoneId, ApiCallback<ShippingZone> callback) {
    Call<ShippingZone> call = service.retrieveShippingZone(shippingZoneId);
    asyncCall(call, callback);
  }
}
