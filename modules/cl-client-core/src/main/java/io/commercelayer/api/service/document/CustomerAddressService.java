package io.commercelayer.api.service.document;

import io.commercelayer.api.model.CustomerAddress;
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

public interface CustomerAddressService {
  @GET("/customer_addresses")
  Call<Document> listCustomerAddresses();

  @GET("/customer_addresses")
  Call<Document> listCustomerAddresses(@QueryMap Map<String, String> queryStringParams);

  @POST("/customer_addresses")
  Call<Document> createCustomerAddress(@Body CustomerAddress customerAddress);

  @GET("/customer_addresses/{customerAddressId}")
  Call<Document> retrieveCustomerAddress(@Path("customerAddressId") String customerAddressId);

  @GET("/customer_addresses/{customerAddressId}")
  Call<Document> retrieveCustomerAddress(@Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/customer_addresses/{customerAddressId}")
  Call<Document> updateCustomerAddress(@Path("customerAddressId") String customerAddressId,
      @Body CustomerAddress customerAddress);

  @DELETE("/customer_addresses/{customerAddressId}")
  Call<Void> deleteCustomerAddress(@Path("customerAddressId") String customerAddressId);

  @GET("/customer_addresses/{customerAddressId}/address")
  Call<Document> retrieveCustomerAddressAddress(
      @Path("customerAddressId") String customerAddressId);

  @GET("/customer_addresses/{customerAddressId}/address")
  Call<Document> retrieveCustomerAddressAddress(@Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/customer_addresses/{customerAddressId}/customer")
  Call<Document> retrieveCustomerAddressCustomer(
      @Path("customerAddressId") String customerAddressId);

  @GET("/customer_addresses/{customerAddressId}/customer")
  Call<Document> retrieveCustomerAddressCustomer(
      @Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);
}
