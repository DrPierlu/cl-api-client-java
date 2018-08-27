package io.commercelayer.api.service.document;

import io.commercelayer.api.model.Merchant;
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

public interface MerchantService {
  @GET("/merchants")
  Call<Document> listMerchants();

  @GET("/merchants")
  Call<Document> listMerchants(@QueryMap Map<String, String> queryStringParams);

  @POST("/merchants")
  Call<Document> createMerchant(@Body Merchant merchant);

  @GET("/merchants/{merchantId}")
  Call<Document> retrieveMerchant(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}")
  Call<Document> retrieveMerchant(@Path("merchantId") String merchantId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/merchants/{merchantId}")
  Call<Document> updateMerchant(@Path("merchantId") String merchantId, @Body Merchant merchant);

  @DELETE("/merchants/{merchantId}")
  Call<Void> deleteMerchant(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}/address")
  Call<Document> retrieveMerchantAddress(@Path("merchantId") String merchantId);

  @GET("/merchants/{merchantId}/address")
  Call<Document> retrieveMerchantAddress(@Path("merchantId") String merchantId,
      @QueryMap Map<String, String> queryStringParams);
}
