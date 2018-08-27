package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Webhook;
import java.lang.String;
import java.lang.Void;
import java.util.Map;
import moe.banana.jsonapi2.Document;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface WebhookService {
  @GET("/webhooks")
  Call<Document> listWebhooks();

  @GET("/webhooks")
  Call<Document> listWebhooks(@QueryMap Map<String, String> queryStringParams);

  @POST("/webhooks")
  Call<Document> createWebhook(@Body Webhook webhook);

  @GET("/webhooks/{webhookId}")
  Call<Document> retrieveWebhook(@Path("webhookId") String webhookId);

  @GET("/webhooks/{webhookId}")
  Call<Document> retrieveWebhook(@Path("webhookId") String webhookId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/webhooks/{webhookId}")
  Call<Document> updateWebhook(@Path("webhookId") String webhookId, @Body Webhook webhook);

  @DELETE("/webhooks/{webhookId}")
  Call<Void> deleteWebhook(@Path("webhookId") String webhookId);
}
