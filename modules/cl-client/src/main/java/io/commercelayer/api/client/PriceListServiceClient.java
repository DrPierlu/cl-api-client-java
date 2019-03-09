package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Price;
import io.commercelayer.api.model.PriceList;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PriceListService;
import java.util.List;
import retrofit2.Call;

public class PriceListServiceClient extends AbstractServiceClient<PriceListService> {
  {
    initServiceCallFactory(PriceListService.class, PriceList.class);
  }

  public PriceListServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public PriceListServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<PriceList> listPriceLists(QueryFilter queryFilter) throws ApiException {
    Call<List<PriceList>> call = service.listPriceLists(queryFilter);
    return syncCall(call);
  }

  public void listPriceLists(QueryFilter queryFilter, ApiCallback<List<PriceList>> callback) {
    Call<List<PriceList>> call = service.listPriceLists(queryFilter);
    asyncCall(call, callback);
  }

  public List<PriceList> listPriceLists() throws ApiException {
    Call<List<PriceList>> call = service.listPriceLists();
    return syncCall(call);
  }

  public void listPriceLists(ApiCallback<List<PriceList>> callback) {
    Call<List<PriceList>> call = service.listPriceLists();
    asyncCall(call, callback);
  }

  public PriceList createPriceList(PriceList priceList, QueryFilter queryFilter) throws
      ApiException {
    Call<PriceList> call = service.createPriceList(priceList, queryFilter);
    return syncCall(call);
  }

  public void createPriceList(PriceList priceList, QueryFilter queryFilter,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.createPriceList(priceList, queryFilter);
    asyncCall(call, callback);
  }

  public PriceList createPriceList(PriceList priceList) throws ApiException {
    Call<PriceList> call = service.createPriceList(priceList);
    return syncCall(call);
  }

  public void createPriceList(PriceList priceList, ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.createPriceList(priceList);
    asyncCall(call, callback);
  }

  public PriceList updatePriceList(String priceListId, PriceList priceList, QueryFilter queryFilter)
      throws ApiException {
    Call<PriceList> call = service.updatePriceList(priceListId, priceList, queryFilter);
    return syncCall(call);
  }

  public void updatePriceList(String priceListId, PriceList priceList, QueryFilter queryFilter,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.updatePriceList(priceListId, priceList, queryFilter);
    asyncCall(call, callback);
  }

  public PriceList updatePriceList(String priceListId, PriceList priceList) throws ApiException {
    Call<PriceList> call = service.updatePriceList(priceListId, priceList);
    return syncCall(call);
  }

  public void updatePriceList(String priceListId, PriceList priceList,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.updatePriceList(priceListId, priceList);
    asyncCall(call, callback);
  }

  public PriceList retrievePriceList(String priceListId, QueryFilter queryFilter) throws
      ApiException {
    Call<PriceList> call = service.retrievePriceList(priceListId, queryFilter);
    return syncCall(call);
  }

  public void retrievePriceList(String priceListId, QueryFilter queryFilter,
      ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrievePriceList(priceListId, queryFilter);
    asyncCall(call, callback);
  }

  public PriceList retrievePriceList(String priceListId) throws ApiException {
    Call<PriceList> call = service.retrievePriceList(priceListId);
    return syncCall(call);
  }

  public void retrievePriceList(String priceListId, ApiCallback<PriceList> callback) {
    Call<PriceList> call = service.retrievePriceList(priceListId);
    asyncCall(call, callback);
  }

  public void deletePriceList(String priceListId) throws ApiException {
    Call<Void> call = service.deletePriceList(priceListId);
    syncCall(call);
  }

  public void deletePriceList(String priceListId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePriceList(priceListId);
    asyncCall(call, callback);
  }

  public List<Price> listPriceListPrices(String priceListId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Price>> call = service.listPriceListPrices(priceListId, queryFilter);
    return syncCall(call);
  }

  public void listPriceListPrices(String priceListId, QueryFilter queryFilter,
      ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listPriceListPrices(priceListId, queryFilter);
    asyncCall(call, callback);
  }

  public List<Price> listPriceListPrices(String priceListId) throws ApiException {
    Call<List<Price>> call = service.listPriceListPrices(priceListId);
    return syncCall(call);
  }

  public void listPriceListPrices(String priceListId, ApiCallback<List<Price>> callback) {
    Call<List<Price>> call = service.listPriceListPrices(priceListId);
    asyncCall(call, callback);
  }
}
