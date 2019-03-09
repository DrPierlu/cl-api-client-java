package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Parcel;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ParcelService;
import java.util.List;
import retrofit2.Call;

public class ParcelServiceClient extends AbstractServiceClient<ParcelService> {
  {
    initServiceCallFactory(ParcelService.class, Parcel.class);
  }

  public ParcelServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public ParcelServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Parcel> listParcels(QueryFilter queryFilter) throws ApiException {
    Call<List<Parcel>> call = service.listParcels(queryFilter);
    return syncCall(call);
  }

  public void listParcels(QueryFilter queryFilter, ApiCallback<List<Parcel>> callback) {
    Call<List<Parcel>> call = service.listParcels(queryFilter);
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

  public Parcel createParcel(Parcel parcel, QueryFilter queryFilter) throws ApiException {
    Call<Parcel> call = service.createParcel(parcel, queryFilter);
    return syncCall(call);
  }

  public void createParcel(Parcel parcel, QueryFilter queryFilter, ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.createParcel(parcel, queryFilter);
    asyncCall(call, callback);
  }

  public Parcel createParcel(Parcel parcel) throws ApiException {
    Call<Parcel> call = service.createParcel(parcel);
    return syncCall(call);
  }

  public void createParcel(Parcel parcel, ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.createParcel(parcel);
    asyncCall(call, callback);
  }

  public Parcel updateParcel(String parcelId, Parcel parcel, QueryFilter queryFilter) throws
      ApiException {
    Call<Parcel> call = service.updateParcel(parcelId, parcel, queryFilter);
    return syncCall(call);
  }

  public void updateParcel(String parcelId, Parcel parcel, QueryFilter queryFilter,
      ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.updateParcel(parcelId, parcel, queryFilter);
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

  public Parcel retrieveParcel(String parcelId, QueryFilter queryFilter) throws ApiException {
    Call<Parcel> call = service.retrieveParcel(parcelId, queryFilter);
    return syncCall(call);
  }

  public void retrieveParcel(String parcelId, QueryFilter queryFilter,
      ApiCallback<Parcel> callback) {
    Call<Parcel> call = service.retrieveParcel(parcelId, queryFilter);
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

  public void deleteParcel(String parcelId) throws ApiException {
    Call<Void> call = service.deleteParcel(parcelId);
    syncCall(call);
  }

  public void deleteParcel(String parcelId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteParcel(parcelId);
    asyncCall(call, callback);
  }

  public Shipment retrieveParcelShipment(String parcelId, QueryFilter queryFilter) throws
      ApiException {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId, queryFilter);
    return syncCall(call);
  }

  public void retrieveParcelShipment(String parcelId, QueryFilter queryFilter,
      ApiCallback<Shipment> callback) {
    Call<Shipment> call = service.retrieveParcelShipment(parcelId, queryFilter);
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
