package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
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

public interface AddressService {
  @GET("addresses")
  Call<List<Address>> listAddresses();

  @GET("addresses")
  Call<List<Address>> listAddresses(@QueryMap Map<String, String> queryStringParams);

  @POST("addresses")
  Call<Address> createAddress(@Body Address address);

  @POST("addresses")
  Call<Address> createAddress(@Body Address address,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("addresses/{addressId}")
  Call<Address> updateAddress(@Path("addressId") String addressId, @Body Address address);

  @PATCH("addresses/{addressId}")
  Call<Address> updateAddress(@Path("addressId") String addressId, @Body Address address,
      @QueryMap Map<String, String> queryStringParams);

  @GET("addresses/{addressId}")
  Call<Address> retrieveAddress(@Path("addressId") String addressId);

  @GET("addresses/{addressId}")
  Call<Address> retrieveAddress(@Path("addressId") String addressId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("addresses/{addressId}")
  Call<Void> deleteAddress(@Path("addressId") String addressId);

  @GET("addresses/{addressId}/geocoder")
  Call<Geocoder> retrieveAddressGeocoder(@Path("addressId") String addressId);

  @GET("addresses/{addressId}/geocoder")
  Call<Geocoder> retrieveAddressGeocoder(@Path("addressId") String addressId,
      @QueryMap Map<String, String> queryStringParams);
}
