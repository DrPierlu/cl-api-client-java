package io.commercelayer.api.service.dev;

import java.util.Map;

import io.commercelayer.api.model.dev.Address;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface AddressService {

	@POST("addresses")
	Call<Address> createAddress(@Body Address address);
	
	@GET("addresses")
	Call<Address> listAddresses(@QueryMap Map<String, String> queryStringParams);
	
	@GET("addresses/{id}")
	Call<Address> retrieveAddress(@Path("id") String id, @QueryMap Map<String, String> queryStringParams);
	
	@PATCH("addresses/{id}")
	Call<Address> updateAddress(@Path("id") String id, @Body Address address);
	
	@DELETE("addresses/{id}")
	Call<Address> deleteAddress(@Path("id") String id);
	
}
