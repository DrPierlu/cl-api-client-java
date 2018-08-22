package io.commercelayer.api.service;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Merchant;
import java.lang.String;
import java.lang.Void;
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

public interface MerchantService {
  @GET("/merchants")
  Call<List<Merchant>> listMerchants();

  @GET("/merchants")
  Call<List<Merchant>> listMerchants(@QueryMap Map<String, String> queryStringParams);

  @POST("/merchants")
  Call<Merchant> createMerchant(@Body Merchant merchant);

  @GET("/merchants/{merchantId}")
  Call<Merchant> retrieveMerchant(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}")
  Call<Merchant> retrieveMerchant(@Path("merchantId") String merchantId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/merchants/{merchantId}")
  Call<Merchant> updateMerchant(@Path("merchantId") String merchantId, @Body Merchant merchant);

  @DELETE("/merchants/{merchantId}")
  Call<Void> deleteMerchant(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}/address")
  Call<Address> retrieveMerchantAddress(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}/address")
  Call<Address> retrieveMerchantAddress(@Path("merchantId") String merchantId,
      @QueryMap Map<String, String> queryStringParams);
}
