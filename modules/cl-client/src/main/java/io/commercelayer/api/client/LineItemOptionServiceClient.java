package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.LineItemOption;
import io.commercelayer.api.model.SkuOption;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.LineItemOptionService;
import java.util.List;
import retrofit2.Call;

public class LineItemOptionServiceClient extends AbstractServiceClient {
  protected final LineItemOptionService service;

  {
    this.service = initServiceCallFactory(LineItemOptionService.class, LineItemOption.class);
  }

  public LineItemOptionServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public LineItemOptionServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<LineItemOption> listLineItemOptions(QueryFilter queryFilter) throws ApiException {
    Call<List<LineItemOption>> call = service.listLineItemOptions(queryFilter);
    return syncCall(call);
  }

  public void listLineItemOptions(QueryFilter queryFilter,
      ApiCallback<List<LineItemOption>> callback) {
    Call<List<LineItemOption>> call = service.listLineItemOptions(queryFilter);
    asyncCall(call, callback);
  }

  public List<LineItemOption> listLineItemOptions() throws ApiException {
    Call<List<LineItemOption>> call = service.listLineItemOptions();
    return syncCall(call);
  }

  public void listLineItemOptions(ApiCallback<List<LineItemOption>> callback) {
    Call<List<LineItemOption>> call = service.listLineItemOptions();
    asyncCall(call, callback);
  }

  public LineItemOption createLineItemOption(LineItemOption lineItemOption) throws ApiException {
    Call<LineItemOption> call = service.createLineItemOption(lineItemOption);
    return syncCall(call);
  }

  public void createLineItemOption(LineItemOption lineItemOption,
      ApiCallback<LineItemOption> callback) {
    Call<LineItemOption> call = service.createLineItemOption(lineItemOption);
    asyncCall(call, callback);
  }

  public void deleteLineItemOption(String lineItemOptionId) throws ApiException {
    Call<Void> call = service.deleteLineItemOption(lineItemOptionId);
    syncCall(call);
  }

  public void deleteLineItemOption(String lineItemOptionId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteLineItemOption(lineItemOptionId);
    asyncCall(call, callback);
  }

  public LineItemOption updateLineItemOption(String lineItemOptionId, LineItemOption lineItemOption)
      throws ApiException {
    Call<LineItemOption> call = service.updateLineItemOption(lineItemOptionId, lineItemOption);
    return syncCall(call);
  }

  public void updateLineItemOption(String lineItemOptionId, LineItemOption lineItemOption,
      ApiCallback<LineItemOption> callback) {
    Call<LineItemOption> call = service.updateLineItemOption(lineItemOptionId, lineItemOption);
    asyncCall(call, callback);
  }

  public LineItemOption retrieveLineItemOption(String lineItemOptionId, QueryFilter queryFilter)
      throws ApiException {
    Call<LineItemOption> call = service.retrieveLineItemOption(lineItemOptionId, queryFilter);
    return syncCall(call);
  }

  public void retrieveLineItemOption(String lineItemOptionId, QueryFilter queryFilter,
      ApiCallback<LineItemOption> callback) {
    Call<LineItemOption> call = service.retrieveLineItemOption(lineItemOptionId, queryFilter);
    asyncCall(call, callback);
  }

  public LineItemOption retrieveLineItemOption(String lineItemOptionId) throws ApiException {
    Call<LineItemOption> call = service.retrieveLineItemOption(lineItemOptionId);
    return syncCall(call);
  }

  public void retrieveLineItemOption(String lineItemOptionId,
      ApiCallback<LineItemOption> callback) {
    Call<LineItemOption> call = service.retrieveLineItemOption(lineItemOptionId);
    asyncCall(call, callback);
  }

  public LineItem retrieveLineItemOptionLineItem(String lineItemOptionId, QueryFilter queryFilter)
      throws ApiException {
    Call<LineItem> call = service.retrieveLineItemOptionLineItem(lineItemOptionId, queryFilter);
    return syncCall(call);
  }

  public void retrieveLineItemOptionLineItem(String lineItemOptionId, QueryFilter queryFilter,
      ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.retrieveLineItemOptionLineItem(lineItemOptionId, queryFilter);
    asyncCall(call, callback);
  }

  public LineItem retrieveLineItemOptionLineItem(String lineItemOptionId) throws ApiException {
    Call<LineItem> call = service.retrieveLineItemOptionLineItem(lineItemOptionId);
    return syncCall(call);
  }

  public void retrieveLineItemOptionLineItem(String lineItemOptionId,
      ApiCallback<LineItem> callback) {
    Call<LineItem> call = service.retrieveLineItemOptionLineItem(lineItemOptionId);
    asyncCall(call, callback);
  }

  public SkuOption retrieveLineItemOptionSkuOption(String lineItemOptionId, QueryFilter queryFilter)
      throws ApiException {
    Call<SkuOption> call = service.retrieveLineItemOptionSkuOption(lineItemOptionId, queryFilter);
    return syncCall(call);
  }

  public void retrieveLineItemOptionSkuOption(String lineItemOptionId, QueryFilter queryFilter,
      ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.retrieveLineItemOptionSkuOption(lineItemOptionId, queryFilter);
    asyncCall(call, callback);
  }

  public SkuOption retrieveLineItemOptionSkuOption(String lineItemOptionId) throws ApiException {
    Call<SkuOption> call = service.retrieveLineItemOptionSkuOption(lineItemOptionId);
    return syncCall(call);
  }

  public void retrieveLineItemOptionSkuOption(String lineItemOptionId,
      ApiCallback<SkuOption> callback) {
    Call<SkuOption> call = service.retrieveLineItemOptionSkuOption(lineItemOptionId);
    asyncCall(call, callback);
  }
}
