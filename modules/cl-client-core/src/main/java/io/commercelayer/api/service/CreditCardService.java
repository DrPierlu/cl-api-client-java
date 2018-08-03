package io.commercelayer.api.service;

import java.util.Map;

import io.commercelayer.api.model.CreditCard;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CreditCardService {

	@POST("credit_cards")
	Call<CreditCard> createCreditCard(@Body CreditCard creditCard);
	
	@GET("credit_cards")
	Call<CreditCard> listCreditCards(@QueryMap Map<String, String> queryStringParams);
	
	@GET("credit_cards/{id}")
	Call<CreditCard> retrieveCreditCard(@Path("id") String id, @QueryMap Map<String, String> queryStringParams);
	
	@PATCH("credit_cards/{id}")
	Call<CreditCard> updateCreditCard(@Path("id") String id, @Body CreditCard creditCard);
	
	@DELETE("credit_cards/{id}")
	Call<CreditCard> deleteCreditCard(@Path("id") String id);
	
}
