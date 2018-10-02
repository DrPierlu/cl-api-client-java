package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
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

public interface CustomerAddressService {
  @GET("customer_addresses")
  Call<List<CustomerAddress>> listCustomerAddresses();

  @GET("customer_addresses")
  Call<List<CustomerAddress>> listCustomerAddresses(
      @QueryMap Map<String, String> queryStringParams);

  @POST("customer_addresses")
  Call<CustomerAddress> createCustomerAddress(@Body CustomerAddress customerAddress);

  @DELETE("customer_addresses/{customerAddressId}")
  Call<Void> deleteCustomerAddress(@Path("customerAddressId") String customerAddressId);

  @PATCH("customer_addresses/{customerAddressId}")
  Call<CustomerAddress> updateCustomerAddress(@Path("customerAddressId") String customerAddressId,
      @Body CustomerAddress customerAddress);

  @GET("customer_addresses/{customerAddressId}")
  Call<CustomerAddress> retrieveCustomerAddress(
      @Path("customerAddressId") String customerAddressId);

  @GET("customer_addresses/{customerAddressId}")
  Call<CustomerAddress> retrieveCustomerAddress(@Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customer_addresses/{customerAddressId}/address")
  Call<Address> retrieveCustomerAddressAddress(@Path("customerAddressId") String customerAddressId);

  @GET("customer_addresses/{customerAddressId}/address")
  Call<Address> retrieveCustomerAddressAddress(@Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customer_addresses/{customerAddressId}/customer")
  Call<Customer> retrieveCustomerAddressCustomer(
      @Path("customerAddressId") String customerAddressId);

  @GET("customer_addresses/{customerAddressId}/customer")
  Call<Customer> retrieveCustomerAddressCustomer(
      @Path("customerAddressId") String customerAddressId,
      @QueryMap Map<String, String> queryStringParams);
}
