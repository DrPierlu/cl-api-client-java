package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Merchant;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.MerchantService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class MerchantServiceClient extends AbstractServiceClient {
  protected final MerchantService service;

  {
    this.service = initServiceCallFactory(MerchantService.class, Merchant.class);
  }

  public MerchantServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public MerchantServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Merchant> listMerchants(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Merchant>> call = service.listMerchants(queryStringParams);
    return syncCall(call);
  }

  public void listMerchants(Map<String, String> queryStringParams,
      ApiCallback<List<Merchant>> callback) {
    Call<List<Merchant>> call = service.listMerchants(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Merchant> listMerchants() throws ApiException {
    Call<List<Merchant>> call = service.listMerchants();
    return syncCall(call);
  }

  public void listMerchants(ApiCallback<List<Merchant>> callback) {
    Call<List<Merchant>> call = service.listMerchants();
    asyncCall(call, callback);
  }

  public Merchant createMerchant(Merchant merchant) throws ApiException {
    Call<Merchant> call = service.createMerchant(merchant);
    return syncCall(call);
  }

  public void createMerchant(Merchant merchant, ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.createMerchant(merchant);
    asyncCall(call, callback);
  }

  public void deleteMerchant(String merchantId) throws ApiException {
    Call<Void> call = service.deleteMerchant(merchantId);
    syncCall(call);
  }

  public void deleteMerchant(String merchantId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteMerchant(merchantId);
    asyncCall(call, callback);
  }

  public Merchant updateMerchant(String merchantId, Merchant merchant) throws ApiException {
    Call<Merchant> call = service.updateMerchant(merchantId, merchant);
    return syncCall(call);
  }

  public void updateMerchant(String merchantId, Merchant merchant, ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.updateMerchant(merchantId, merchant);
    asyncCall(call, callback);
  }

  public Merchant retrieveMerchant(String merchantId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Merchant> call = service.retrieveMerchant(merchantId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMerchant(String merchantId, Map<String, String> queryStringParams,
      ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.retrieveMerchant(merchantId, queryStringParams);
    asyncCall(call, callback);
  }

  public Merchant retrieveMerchant(String merchantId) throws ApiException {
    Call<Merchant> call = service.retrieveMerchant(merchantId);
    return syncCall(call);
  }

  public void retrieveMerchant(String merchantId, ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.retrieveMerchant(merchantId);
    asyncCall(call, callback);
  }

  public Address retrieveMerchantAddress(String merchantId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Address> call = service.retrieveMerchantAddress(merchantId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMerchantAddress(String merchantId, Map<String, String> queryStringParams,
      ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveMerchantAddress(merchantId, queryStringParams);
    asyncCall(call, callback);
  }

  public Address retrieveMerchantAddress(String merchantId) throws ApiException {
    Call<Address> call = service.retrieveMerchantAddress(merchantId);
    return syncCall(call);
  }

  public void retrieveMerchantAddress(String merchantId, ApiCallback<Address> callback) {
    Call<Address> call = service.retrieveMerchantAddress(merchantId);
    asyncCall(call, callback);
  }
}
