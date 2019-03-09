package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Webhook;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.WebhookService;
import java.util.List;
import retrofit2.Call;

public class WebhookServiceClient extends AbstractServiceClient<WebhookService> {
  {
    initServiceCallFactory(WebhookService.class, Webhook.class);
  }

  public WebhookServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public WebhookServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Webhook> listWebhooks(QueryFilter queryFilter) throws ApiException {
    Call<List<Webhook>> call = service.listWebhooks(queryFilter);
    return syncCall(call);
  }

  public void listWebhooks(QueryFilter queryFilter, ApiCallback<List<Webhook>> callback) {
    Call<List<Webhook>> call = service.listWebhooks(queryFilter);
    asyncCall(call, callback);
  }

  public List<Webhook> listWebhooks() throws ApiException {
    Call<List<Webhook>> call = service.listWebhooks();
    return syncCall(call);
  }

  public void listWebhooks(ApiCallback<List<Webhook>> callback) {
    Call<List<Webhook>> call = service.listWebhooks();
    asyncCall(call, callback);
  }

  public Webhook createWebhook(Webhook webhook) throws ApiException {
    Call<Webhook> call = service.createWebhook(webhook);
    return syncCall(call);
  }

  public void createWebhook(Webhook webhook, ApiCallback<Webhook> callback) {
    Call<Webhook> call = service.createWebhook(webhook);
    asyncCall(call, callback);
  }

  public Webhook updateWebhook(String webhookId, Webhook webhook) throws ApiException {
    Call<Webhook> call = service.updateWebhook(webhookId, webhook);
    return syncCall(call);
  }

  public void updateWebhook(String webhookId, Webhook webhook, ApiCallback<Webhook> callback) {
    Call<Webhook> call = service.updateWebhook(webhookId, webhook);
    asyncCall(call, callback);
  }

  public Webhook retrieveWebhook(String webhookId, QueryFilter queryFilter) throws ApiException {
    Call<Webhook> call = service.retrieveWebhook(webhookId, queryFilter);
    return syncCall(call);
  }

  public void retrieveWebhook(String webhookId, QueryFilter queryFilter,
      ApiCallback<Webhook> callback) {
    Call<Webhook> call = service.retrieveWebhook(webhookId, queryFilter);
    asyncCall(call, callback);
  }

  public Webhook retrieveWebhook(String webhookId) throws ApiException {
    Call<Webhook> call = service.retrieveWebhook(webhookId);
    return syncCall(call);
  }

  public void retrieveWebhook(String webhookId, ApiCallback<Webhook> callback) {
    Call<Webhook> call = service.retrieveWebhook(webhookId);
    asyncCall(call, callback);
  }

  public void deleteWebhook(String webhookId) throws ApiException {
    Call<Void> call = service.deleteWebhook(webhookId);
    syncCall(call);
  }

  public void deleteWebhook(String webhookId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteWebhook(webhookId);
    asyncCall(call, callback);
  }
}
