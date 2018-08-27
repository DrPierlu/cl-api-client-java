package io.commercelayer.api.service.document;

import io.commercelayer.api.model.CustomerPasswordReset;
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

public interface CustomerPasswordResetService {
  @GET("/customer_password_resets")
  Call<Document> listCustomerPasswordResets();

  @GET("/customer_password_resets")
  Call<Document> listCustomerPasswordResets(@QueryMap Map<String, String> queryStringParams);

  @POST("/customer_password_resets")
  Call<Document> createCustomerPasswordReset(@Body CustomerPasswordReset customerPasswordReset);

  @GET("/customer_password_resets/{customerPasswordResetId}")
  Call<Document> retrieveCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("/customer_password_resets/{customerPasswordResetId}")
  Call<Document> retrieveCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/customer_password_resets/{customerPasswordResetId}")
  Call<Document> updateCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @Body CustomerPasswordReset customerPasswordReset);

  @DELETE("/customer_password_resets/{customerPasswordResetId}")
  Call<Void> deleteCustomerPasswordReset(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("/customer_password_resets/{customerPasswordResetId}/customer")
  Call<Document> retrieveCustomerPasswordResetCustomer(
      @Path("customerPasswordResetId") String customerPasswordResetId);

  @GET("/customer_password_resets/{customerPasswordResetId}/customer")
  Call<Document> retrieveCustomerPasswordResetCustomer(
      @Path("customerPasswordResetId") String customerPasswordResetId,
      @QueryMap Map<String, String> queryStringParams);
}
