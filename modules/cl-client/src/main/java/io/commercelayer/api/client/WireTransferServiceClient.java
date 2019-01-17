package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.WireTransfer;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.WireTransferService;
import java.util.List;
import retrofit2.Call;

public class WireTransferServiceClient extends AbstractServiceClient<WireTransferService> {
  {
    initServiceCallFactory(WireTransferService.class, WireTransfer.class);
  }

  public WireTransferServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public WireTransferServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<WireTransfer> listWireTransfers(QueryFilter queryFilter) throws ApiException {
    Call<List<WireTransfer>> call = service.listWireTransfers(queryFilter);
    return syncCall(call);
  }

  public void listWireTransfers(QueryFilter queryFilter, ApiCallback<List<WireTransfer>> callback) {
    Call<List<WireTransfer>> call = service.listWireTransfers(queryFilter);
    asyncCall(call, callback);
  }

  public List<WireTransfer> listWireTransfers() throws ApiException {
    Call<List<WireTransfer>> call = service.listWireTransfers();
    return syncCall(call);
  }

  public void listWireTransfers(ApiCallback<List<WireTransfer>> callback) {
    Call<List<WireTransfer>> call = service.listWireTransfers();
    asyncCall(call, callback);
  }

  public WireTransfer createWireTransfer(WireTransfer wireTransfer) throws ApiException {
    Call<WireTransfer> call = service.createWireTransfer(wireTransfer);
    return syncCall(call);
  }

  public void createWireTransfer(WireTransfer wireTransfer, ApiCallback<WireTransfer> callback) {
    Call<WireTransfer> call = service.createWireTransfer(wireTransfer);
    asyncCall(call, callback);
  }

  public WireTransfer updateWireTransfer(String wireTransferId, WireTransfer wireTransfer) throws
      ApiException {
    Call<WireTransfer> call = service.updateWireTransfer(wireTransferId, wireTransfer);
    return syncCall(call);
  }

  public void updateWireTransfer(String wireTransferId, WireTransfer wireTransfer,
      ApiCallback<WireTransfer> callback) {
    Call<WireTransfer> call = service.updateWireTransfer(wireTransferId, wireTransfer);
    asyncCall(call, callback);
  }

  public void deleteWireTransfer(String wireTransferId) throws ApiException {
    Call<Void> call = service.deleteWireTransfer(wireTransferId);
    syncCall(call);
  }

  public void deleteWireTransfer(String wireTransferId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteWireTransfer(wireTransferId);
    asyncCall(call, callback);
  }

  public WireTransfer retrieveWireTransfer(String wireTransferId, QueryFilter queryFilter) throws
      ApiException {
    Call<WireTransfer> call = service.retrieveWireTransfer(wireTransferId, queryFilter);
    return syncCall(call);
  }

  public void retrieveWireTransfer(String wireTransferId, QueryFilter queryFilter,
      ApiCallback<WireTransfer> callback) {
    Call<WireTransfer> call = service.retrieveWireTransfer(wireTransferId, queryFilter);
    asyncCall(call, callback);
  }

  public WireTransfer retrieveWireTransfer(String wireTransferId) throws ApiException {
    Call<WireTransfer> call = service.retrieveWireTransfer(wireTransferId);
    return syncCall(call);
  }

  public void retrieveWireTransfer(String wireTransferId, ApiCallback<WireTransfer> callback) {
    Call<WireTransfer> call = service.retrieveWireTransfer(wireTransferId);
    asyncCall(call, callback);
  }

  public Order retrieveWireTransferOrder(String wireTransferId, QueryFilter queryFilter) throws
      ApiException {
    Call<Order> call = service.retrieveWireTransferOrder(wireTransferId, queryFilter);
    return syncCall(call);
  }

  public void retrieveWireTransferOrder(String wireTransferId, QueryFilter queryFilter,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveWireTransferOrder(wireTransferId, queryFilter);
    asyncCall(call, callback);
  }

  public Order retrieveWireTransferOrder(String wireTransferId) throws ApiException {
    Call<Order> call = service.retrieveWireTransferOrder(wireTransferId);
    return syncCall(call);
  }

  public void retrieveWireTransferOrder(String wireTransferId, ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveWireTransferOrder(wireTransferId);
    asyncCall(call, callback);
  }
}
