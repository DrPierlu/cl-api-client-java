package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.InventoryModel;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Merchant;
import io.commercelayer.api.model.PriceList;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.MarketService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class MarketServiceClient extends AbstractServiceClient {
  protected MarketService service;

  public MarketServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(MarketService.class, Market.class);
  }

  public MarketServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(MarketService.class, Market.class);
  }

  public List<Market> listMarkets(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Market>> call = service.listMarkets(queryStringParams);
    return syncCall(call);
  }

  public void listMarkets(Map<String, String> queryStringParams,
      ApiCallback<List<Market>> callback) {
    Call<List<Market>> call = service.listMarkets(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Market> listMarkets() throws ApiException {
    Call<List<Market>> call = service.listMarkets();
    return syncCall(call);
  }

  public void listMarkets(ApiCallback<List<Market>> callback) {
    Call<List<Market>> call = service.listMarkets();
    asyncCall(call, callback);
  }

  public Market createMarket(Market market) throws ApiException {
    Call<Market> call = service.createMarket(market);
    return syncCall(call);
  }

  public void createMarket(Market market, ApiCallback<Market> callback) {
    Call<Market> call = service.createMarket(market);
    asyncCall(call, callback);
  }

  public void deleteMarket(String marketId) throws ApiException {
    Call<Void> call = service.deleteMarket(marketId);
    syncCall(call);
  }

  public void deleteMarket(String marketId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteMarket(marketId);
    asyncCall(call, callback);
  }

  public Market updateMarket(String marketId, Market market) throws ApiException {
    Call<Market> call = service.updateMarket(marketId, market);
    return syncCall(call);
  }

  public void updateMarket(String marketId, Market market, ApiCallback<Market> callback) {
    Call<Market> call = service.updateMarket(marketId, market);
    asyncCall(call, callback);
  }

  public Market retrieveMarket(String marketId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Market> call = service.retrieveMarket(marketId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMarket(String marketId, Map<String, String> queryStringParams,
      ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveMarket(marketId, queryStringParams);
    asyncCall(call, callback);
  }

  public Market retrieveMarket(String marketId) throws ApiException {
    Call<Market> call = service.retrieveMarket(marketId);
    return syncCall(call);
  }

  public void retrieveMarket(String marketId, ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveMarket(marketId);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveMarketInventoryModel(String marketId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<InventoryModel> call = service.retrieveMarketInventoryModel(marketId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMarketInventoryModel(String marketId, Map<String, String> queryStringParams,
      ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveMarketInventoryModel(marketId, queryStringParams);
    asyncCall(call, callback);
  }

  public InventoryModel retrieveMarketInventoryModel(String marketId) throws ApiException {
    Call<InventoryModel> call = service.retrieveMarketInventoryModel(marketId);
    return syncCall(call);
  }

  public void retrieveMarketInventoryModel(String marketId, ApiCallback<InventoryModel> callback) {
    Call<InventoryModel> call = service.retrieveMarketInventoryModel(marketId);
    asyncCall(call, callback);
  }

  public Merchant retrieveMarketMerchant(String marketId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Merchant> call = service.retrieveMarketMerchant(marketId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMarketMerchant(String marketId, Map<String, String> queryStringParams,
      ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.retrieveMarketMerchant(marketId, queryStringParams);
    asyncCall(call, callback);
  }

  public Merchant retrieveMarketMerchant(String marketId) throws ApiException {
    Call<Merchant> call = service.retrieveMarketMerchant(marketId);
    return syncCall(call);
  }

  public void retrieveMarketMerchant(String marketId, ApiCallback<Merchant> callback) {
    Call<Merchant> call = service.retrieveMarketMerchant(marketId);
    asyncCall(call, callback);
  }

  public PriceList retrieveMarketPriceList(String marketId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<PriceList> call = service.retrieveMarketPriceList(marketId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveMarketPriceList(String marketId, Map<String, String> queryStringParams,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrieveMarketPriceList(marketId, queryStringParams);
    asyncCall(call, callback);
  }

  public PriceList retrieveMarketPriceList(String marketId) throws ApiException {
    Call<PriceList> call = service.retrieveMarketPriceList(marketId);
    return syncCall(call);
  }

  public void retrieveMarketPriceList(String marketId, ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrieveMarketPriceList(marketId);
    asyncCall(call, callback);
  }
}