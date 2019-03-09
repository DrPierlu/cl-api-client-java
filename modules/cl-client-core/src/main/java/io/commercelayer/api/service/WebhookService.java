package io.commercelayer.api.service;

import io.commercelayer.api.model.Webhook;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface WebhookService {
  @GET("webhooks")
  Call<List<Webhook>> listWebhooks();

  @GET("webhooks")
  Call<List<Webhook>> listWebhooks(@QueryMap Map<String, String> queryStringParams);

  @POST("webhooks")
  Call<Webhook> createWebhook(@Body Webhook webhook);

  @POST("webhooks")
  Call<Webhook> createWebhook(@Body Webhook webhook,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("webhooks/{webhookId}")
  Call<Webhook> updateWebhook(@Path("webhookId") String webhookId, @Body Webhook webhook);

  @PATCH("webhooks/{webhookId}")
  Call<Webhook> updateWebhook(@Path("webhookId") String webhookId, @Body Webhook webhook,
      @QueryMap Map<String, String> queryStringParams);

  @GET("webhooks/{webhookId}")
  Call<Webhook> retrieveWebhook(@Path("webhookId") String webhookId);

  @GET("webhooks/{webhookId}")
  Call<Webhook> retrieveWebhook(@Path("webhookId") String webhookId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("webhooks/{webhookId}")
  Call<Void> deleteWebhook(@Path("webhookId") String webhookId);
}
