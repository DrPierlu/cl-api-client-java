package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ParcelService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class ParcelServiceClient extends AbstractServiceClient {
  protected ParcelService service;

  public ParcelServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(ParcelService.class, Parcel.class);
  }

  public ParcelServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(ParcelService.class, Parcel.class);
  }

  public Parcel createParcel(Parcel parcel) throws ApiException {
    Call<Parcel> call = service.createParcel(parcel);
    return syncCall(call);
  }

  public void createParcel(Parcel parcel, ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.createParcel(parcel);
    asyncCall(call, callback);
  }

  public List<Parcel> listParcels(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Parcel>> call = service.listParcels(queryStringParams);
    return syncCall(call);
  }

  public void listParcels(Map<String, String> queryStringParams,
      ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listParcels(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Parcel> listParcels() throws ApiException {
    Call<List<Parcel>> call = service.listParcels();
    return syncCall(call);
  }

  public void listParcels(ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listParcels();
    asyncCall(call, callback);
  }

  public void deleteParcel(String parcelId) throws ApiException {
    Call<Void> call = service.deleteParcel(parcelId);
    syncCall(call);
  }

  public void deleteParcel(String parcelId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteParcel(parcelId);
    asyncCall(call, callback);
  }

  public Parcel updateParcel(String parcelId, Parcel parcel) throws ApiException {
    Call<Parcel> call = service.updateParcel(parcelId, parcel);
    return syncCall(call);
  }

  public void updateParcel(String parcelId, Parcel parcel, ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.updateParcel(parcelId, parcel);
    asyncCall(call, callback);
  }

  public Parcel retrieveParcel(String parcelId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Parcel> call = service.retrieveParcel(parcelId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveParcel(String parcelId, Map<String, String> queryStringParams,
      ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.retrieveParcel(parcelId, queryStringParams);
    asyncCall(call, callback);
  }

  public Parcel retrieveParcel(String parcelId) throws ApiException {
    Call<Parcel> call = service.retrieveParcel(parcelId);
    return syncCall(call);
  }

  public void retrieveParcel(String parcelId, ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.retrieveParcel(parcelId);
    asyncCall(call, callback);
  }

  public Shipment retrieveParcelShipment(String parcelId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveParcelShipment(String parcelId, Map<String, String> queryStringParams,
      ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId, queryStringParams);
    asyncCall(call, callback);
  }

  public Shipment retrieveParcelShipment(String parcelId) throws ApiException {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId);
    return syncCall(call);
  }

  public void retrieveParcelShipment(String parcelId, ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId);
    asyncCall(call, callback);
  }
}
