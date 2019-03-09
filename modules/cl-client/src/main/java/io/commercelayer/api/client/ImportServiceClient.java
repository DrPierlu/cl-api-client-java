package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Import;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.ImportService;
import java.util.List;
import retrofit2.Call;

public class ImportServiceClient extends AbstractServiceClient<ImportService> {
  {
    initServiceCallFactory(ImportService.class, Import.class);
  }

  public ImportServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public ImportServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Import> listImports(QueryFilter queryFilter) throws ApiException {
    Call<List<Import>> call = service.listImports(queryFilter);
    return syncCall(call);
  }

  public void listImports(QueryFilter queryFilter, ApiCallback<List<Import>> callback) {
    Call<List<Import>> call = service.listImports(queryFilter);
    asyncCall(call, callback);
  }

  public List<Import> listImports() throws ApiException {
    Call<List<Import>> call = service.listImports();
    return syncCall(call);
  }

  public void listImports(ApiCallback<List<Import>> callback) {
    Call<List<Import>> call = service.listImports();
    asyncCall(call, callback);
  }

  public Import createImport(Import import_, QueryFilter queryFilter) throws ApiException {
    Call<Import> call = service.createImport(import_, queryFilter);
    return syncCall(call);
  }

  public void createImport(Import import_, QueryFilter queryFilter, ApiCallback<Import> callback) {
    Call<Import> call = service.createImport(import_, queryFilter);
    asyncCall(call, callback);
  }

  public Import createImport(Import import_) throws ApiException {
    Call<Import> call = service.createImport(import_);
    return syncCall(call);
  }

  public void createImport(Import import_, ApiCallback<Import> callback) {
    Call<Import> call = service.createImport(import_);
    asyncCall(call, callback);
  }

  public Import updateImport(String importId, Import import_, QueryFilter queryFilter) throws
      ApiException {
    Call<Import> call = service.updateImport(importId, import_, queryFilter);
    return syncCall(call);
  }

  public void updateImport(String importId, Import import_, QueryFilter queryFilter,
      ApiCallback<Import> callback) {
    Call<Import> call = service.updateImport(importId, import_, queryFilter);
    asyncCall(call, callback);
  }

  public Import updateImport(String importId, Import import_) throws ApiException {
    Call<Import> call = service.updateImport(importId, import_);
    return syncCall(call);
  }

  public void updateImport(String importId, Import import_, ApiCallback<Import> callback) {
    Call<Import> call = service.updateImport(importId, import_);
    asyncCall(call, callback);
  }

  public Import retrieveImport(String importId, QueryFilter queryFilter) throws ApiException {
    Call<Import> call = service.retrieveImport(importId, queryFilter);
    return syncCall(call);
  }

  public void retrieveImport(String importId, QueryFilter queryFilter,
      ApiCallback<Import> callback) {
    Call<Import> call = service.retrieveImport(importId, queryFilter);
    asyncCall(call, callback);
  }

  public Import retrieveImport(String importId) throws ApiException {
    Call<Import> call = service.retrieveImport(importId);
    return syncCall(call);
  }

  public void retrieveImport(String importId, ApiCallback<Import> callback) {
    Call<Import> call = service.retrieveImport(importId);
    asyncCall(call, callback);
  }

  public void deleteImport(String importId) throws ApiException {
    Call<Void> call = service.deleteImport(importId);
    syncCall(call);
  }

  public void deleteImport(String importId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteImport(importId);
    asyncCall(call, callback);
  }
}
