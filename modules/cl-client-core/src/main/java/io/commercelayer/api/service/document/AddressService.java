package io.commercelayer.api.service.document;

import java.util.Map;

import io.commercelayer.api.model.Address;
import moe.banana.jsonapi2.Document;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface AddressService {
  @GET("/addresses")
  Call<Document> listAddresses();

  @GET("/addresses")
  Call<Document> listAddresses(@QueryMap Map<String, String> queryStringParams);

  @POST("/addresses")
  Call<Document> createAddress(@Body Address address);

  @GET("/addresses/{addressId}")
  Call<Document> retrieveAddress(@Path("addressId") String addressId);

  @GET("/addresses/{addressId}")
  Call<Document> retrieveAddress(@Path("addressId") String addressId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/addresses/{addressId}")
  Call<Document> updateAddress(@Path("addressId") String addressId, @Body Address address);

  @DELETE("/addresses/{addressId}")
  Call<Void> deleteAddress(@Path("addressId") String addressId);

  @GET("/addresses/{addressId}/geocoder")
  Call<Document> retrieveAddressGeocoder(@Path("addressId") String addressId);

  @GET("/addresses/{addressId}/geocoder")
  Call<Document> retrieveAddressGeocoder(@Path("addressId") String addressId,
      @QueryMap Map<String, String> queryStringParams);
}
