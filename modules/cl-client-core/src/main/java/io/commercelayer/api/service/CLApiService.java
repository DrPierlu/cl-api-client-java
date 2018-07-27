package io.commercelayer.api.service;

import java.util.Map;

import io.commercelayer.api.domain.ContentType;
import io.commercelayer.api.model.Address;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface CLApiService {

	@Headers("Content-Type: " + ContentType.JSON_API)
	@GET("addresses")
	Call<Address> getAddresses(@QueryMap Map<String, String> queryStringParams);
	
	@POST("addresses")
	Call<Address> postUser(@Body Address address);
	
}
