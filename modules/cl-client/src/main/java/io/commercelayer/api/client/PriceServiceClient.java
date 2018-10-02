package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.PriceList;
import io.commercelayer.api.model.Sku;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PriceService;
import java.util.List;
import retrofit2.Call;

public class PriceServiceClient extends AbstractServiceClient {
  protected final PriceService service;

  {
    this.service = initServiceCallFactory(PriceService.class, Price.class);
  }

  public PriceServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public PriceServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Price> listPrices(QueryFilter queryFilter) throws ApiException {
    Call<List<Price>> call = service.listPrices(queryFilter);
    return syncCall(call);
  }

  public void listPrices(QueryFilter queryFilter, ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listPrices(queryFilter);
    asyncCall(call, callback);
  }

  public List<Price> listPrices() throws ApiException {
    Call<List<Price>> call = service.listPrices();
    return syncCall(call);
  }

  public void listPrices(ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listPrices();
    asyncCall(call, callback);
  }

  public Price createPrice(Price price) throws ApiException {
    Call<Price> call = service.createPrice(price);
    return syncCall(call);
  }

  public void createPrice(Price price, ApiCallback<Price> callback) {
    Call<Price> call = service.createPrice(price);
    asyncCall(call, callback);
  }

  public void deletePrice(String priceId) throws ApiException {
    Call<Void> call = service.deletePrice(priceId);
    syncCall(call);
  }

  public void deletePrice(String priceId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePrice(priceId);
    asyncCall(call, callback);
  }

  public Price updatePrice(String priceId, Price price) throws ApiException {
    Call<Price> call = service.updatePrice(priceId, price);
    return syncCall(call);
  }

  public void updatePrice(String priceId, Price price, ApiCallback<Price> callback) {
    Call<Price> call = service.updatePrice(priceId, price);
    asyncCall(call, callback);
  }

  public Price retrievePrice(String priceId, QueryFilter queryFilter) throws ApiException {
    Call<Price> call = service.retrievePrice(priceId, queryFilter);
    return syncCall(call);
  }

  public void retrievePrice(String priceId, QueryFilter queryFilter, ApiCallback<Price> callback) {
    Call<Price> call = service.retrievePrice(priceId, queryFilter);
    asyncCall(call, callback);
  }

  public Price retrievePrice(String priceId) throws ApiException {
    Call<Price> call = service.retrievePrice(priceId);
    return syncCall(call);
  }

  public void retrievePrice(String priceId, ApiCallback<Price> callback) {
    Call<Price> call = service.retrievePrice(priceId);
    asyncCall(call, callback);
  }

  public PriceList retrievePricePriceList(String priceId, QueryFilter queryFilter) throws
      ApiException {
    Call<PriceList> call = service.retrievePricePriceList(priceId, queryFilter);
    return syncCall(call);
  }

  public void retrievePricePriceList(String priceId, QueryFilter queryFilter,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrievePricePriceList(priceId, queryFilter);
    asyncCall(call, callback);
  }

  public PriceList retrievePricePriceList(String priceId) throws ApiException {
    Call<PriceList> call = service.retrievePricePriceList(priceId);
    return syncCall(call);
  }

  public void retrievePricePriceList(String priceId, ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrievePricePriceList(priceId);
    asyncCall(call, callback);
  }

  public Sku retrievePriceSku(String priceId, QueryFilter queryFilter) throws ApiException {
    Call<Sku> call = service.retrievePriceSku(priceId, queryFilter);
    return syncCall(call);
  }

  public void retrievePriceSku(String priceId, QueryFilter queryFilter, ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrievePriceSku(priceId, queryFilter);
    asyncCall(call, callback);
  }

  public Sku retrievePriceSku(String priceId) throws ApiException {
    Call<Sku> call = service.retrievePriceSku(priceId);
    return syncCall(call);
  }

  public void retrievePriceSku(String priceId, ApiCallback<Sku> callback) {
    Call<Sku> call = service.retrievePriceSku(priceId);
    asyncCall(call, callback);
  }
}
