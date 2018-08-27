package io.commercelayer.api.service.document;

import io.commercelayer.api.model.CustomerPaymentSource;
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

public interface CustomerPaymentSourceService {
  @GET("/customer_payment_sources")
  Call<Document> listCustomerPaymentSources();

  @GET("/customer_payment_sources")
  Call<Document> listCustomerPaymentSources(@QueryMap Map<String, String> queryStringParams);

  @POST("/customer_payment_sources")
  Call<Document> createCustomerPaymentSource(@Body CustomerPaymentSource customerPaymentSource);

  @GET("/customer_payment_sources/{customerPaymentSourceId}")
  Call<Document> retrieveCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("/customer_payment_sources/{customerPaymentSourceId}")
  Call<Document> retrieveCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/customer_payment_sources/{customerPaymentSourceId}")
  Call<Document> updateCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @Body CustomerPaymentSource customerPaymentSource);

  @DELETE("/customer_payment_sources/{customerPaymentSourceId}")
  Call<Void> deleteCustomerPaymentSource(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("/customer_payment_sources/{customerPaymentSourceId}/customer")
  Call<Document> retrieveCustomerPaymentSourceCustomer(
      @Path("customerPaymentSourceId") String customerPaymentSourceId);

  @GET("/customer_payment_sources/{customerPaymentSourceId}/customer")
  Call<Document> retrieveCustomerPaymentSourceCustomer(
      @Path("customerPaymentSourceId") String customerPaymentSourceId,
      @QueryMap Map<String, String> queryStringParams);
}
