package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.SkuOption;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.SkuOptionService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class SkuOptionServiceClient extends AbstractServiceClient {
  protected SkuOptionService service;

  public SkuOptionServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(SkuOptionService.class, SkuOption.class);
  }

  public SkuOptionServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(SkuOptionService.class, SkuOption.class);
  }

  public SkuOption createSkuOption(SkuOption skuOption) throws ApiException {
    Call<SkuOption> call = service.createSkuOption(skuOption);
    return syncCall(call);
  }

  public void createSkuOption(SkuOption skuOption, ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.createSkuOption(skuOption);
    asyncCall(call, callback);
  }

  public List<SkuOption> listSkuOptions(Map<String, String> queryStringParams) throws ApiException {
    Call<List<SkuOption>> call = service.listSkuOptions(queryStringParams);
    return syncCall(call);
  }

  public void listSkuOptions(Map<String, String> queryStringParams,
      ApiCallback<List<SkuOption>> callback) {
    Call<List<SkuOption>> call = service.listSkuOptions(queryStringParams);
    asyncCall(call, callback);
  }

  public List<SkuOption> listSkuOptions() throws ApiException {
    Call<List<SkuOption>> call = service.listSkuOptions();
    return syncCall(call);
  }

  public void listSkuOptions(ApiCallback<List<SkuOption>> callback) {
    Call<List<SkuOption>> call = service.listSkuOptions();
    asyncCall(call, callback);
  }

  public void deleteSkuOption(String skuOptionId) throws ApiException {
    Call<Void> call = service.deleteSkuOption(skuOptionId);
    syncCall(call);
  }

  public void deleteSkuOption(String skuOptionId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteSkuOption(skuOptionId);
    asyncCall(call, callback);
  }

  public SkuOption updateSkuOption(String skuOptionId, SkuOption skuOption) throws ApiException {
    Call<SkuOption> call = service.updateSkuOption(skuOptionId, skuOption);
    return syncCall(call);
  }

  public void updateSkuOption(String skuOptionId, SkuOption skuOption,
      ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.updateSkuOption(skuOptionId, skuOption);
    asyncCall(call, callback);
  }

  public SkuOption retrieveSkuOption(String skuOptionId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<SkuOption> call = service.retrieveSkuOption(skuOptionId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveSkuOption(String skuOptionId, Map<String, String> queryStringParams,
      ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.retrieveSkuOption(skuOptionId, queryStringParams);
    asyncCall(call, callback);
  }

  public SkuOption retrieveSkuOption(String skuOptionId) throws ApiException {
    Call<SkuOption> call = service.retrieveSkuOption(skuOptionId);
    return syncCall(call);
  }

  public void retrieveSkuOption(String skuOptionId, ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.retrieveSkuOption(skuOptionId);
    asyncCall(call, callback);
  }

  public Market retrieveSkuOptionMarket(String skuOptionId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Market> call = service.retrieveSkuOptionMarket(skuOptionId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveSkuOptionMarket(String skuOptionId, Map<String, String> queryStringParams,
      ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveSkuOptionMarket(skuOptionId, queryStringParams);
    asyncCall(call, callback);
  }

  public Market retrieveSkuOptionMarket(String skuOptionId) throws ApiException {
    Call<Market> call = service.retrieveSkuOptionMarket(skuOptionId);
    return syncCall(call);
  }

  public void retrieveSkuOptionMarket(String skuOptionId, ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveSkuOptionMarket(skuOptionId);
    asyncCall(call, callback);
  }
}
