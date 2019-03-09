package io.commercelayer.api.service;

import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerGroup;
import io.commercelayer.api.model.PriceList;
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

public interface CustomerGroupService {
  @GET("customer_groups")
  Call<List<CustomerGroup>> listCustomerGroups();

  @GET("customer_groups")
  Call<List<CustomerGroup>> listCustomerGroups(@QueryMap Map<String, String> queryStringParams);

  @POST("customer_groups")
  Call<CustomerGroup> createCustomerGroup(@Body CustomerGroup customerGroup);

  @PATCH("customer_groups/{customerGroupId}")
  Call<CustomerGroup> updateCustomerGroup(@Path("customerGroupId") String customerGroupId,
      @Body CustomerGroup customerGroup);

  @GET("customer_groups/{customerGroupId}")
  Call<CustomerGroup> retrieveCustomerGroup(@Path("customerGroupId") String customerGroupId);

  @GET("customer_groups/{customerGroupId}")
  Call<CustomerGroup> retrieveCustomerGroup(@Path("customerGroupId") String customerGroupId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("customer_groups/{customerGroupId}")
  Call<Void> deleteCustomerGroup(@Path("customerGroupId") String customerGroupId);

  @GET("customer_groups/{customerGroupId}/customers")
  Call<List<Customer>> listCustomerGroupCustomers(@Path("customerGroupId") String customerGroupId);

  @GET("customer_groups/{customerGroupId}/customers")
  Call<List<Customer>> listCustomerGroupCustomers(@Path("customerGroupId") String customerGroupId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("customer_groups/{customerGroupId}/price_list")
  Call<PriceList> retrieveCustomerGroupPriceList(@Path("customerGroupId") String customerGroupId);

  @GET("customer_groups/{customerGroupId}/price_list")
  Call<PriceList> retrieveCustomerGroupPriceList(@Path("customerGroupId") String customerGroupId,
      @QueryMap Map<String, String> queryStringParams);
}
