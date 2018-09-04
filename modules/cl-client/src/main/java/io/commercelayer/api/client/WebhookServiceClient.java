package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Webhook;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.WebhookService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class WebhookServiceClient extends AbstractServiceClient {
  protected WebhookService service;

  public WebhookServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(WebhookService.class, Webhook.class);
  }

  public WebhookServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(WebhookService.class, Webhook.class);
  }

  public List<Webhook> listWebhooks(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Webhook>> call = service.listWebhooks(queryStringParams);
    return syncCall(call);
  }

  public void listWebhooks(Map<String, String> queryStringParams,
      ApiCallback<List<Webhook>> callback) {
    Call<List<Webhook>> call = service.listWebhooks(queryStringParams);
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

  public void deleteWebhook(String webhookId) throws ApiException {
    Call<Void> call = service.deleteWebhook(webhookId);
    syncCall(call);
  }

  public void deleteWebhook(String webhookId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteWebhook(webhookId);
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

  public Webhook retrieveWebhook(String webhookId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Webhook> call = service.retrieveWebhook(webhookId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveWebhook(String webhookId, Map<String, String> queryStringParams,
      ApiCallback<Webhook> callback) {
    Call<Webhook> call = service.retrieveWebhook(webhookId, queryStringParams);
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
}
