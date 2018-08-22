package io.commercelayer.api.service.dev;

import java.util.Map;

import io.commercelayer.api.model.dev.Customer;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CustomerService {

	@POST("customers")
	Call<Customer> createCustomer(@Body Customer customer);
	
	@GET("customers")
	Call<Customer> listCustomers(@QueryMap Map<String, String> queryStringParams);
	
	@GET("customers/{id}")
	Call<Customer> retrieveCustomer(@Path("id") String id, @QueryMap Map<String, String> queryStringParams);
	
	@PATCH("customers/{id}")
	Call<Customer> updateCustomer(@Path("id") String id, @Body Customer customer);
	
	@DELETE("customers/{id}")
	Call<Customer> deleteCustomer(@Path("id") String id);
	
}
