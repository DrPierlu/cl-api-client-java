package io.commercelayer.api.service.document;

import io.commercelayer.api.model.ShippingCategory;
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

public interface ShippingCategoryService {
  @GET("/shipping_categories")
  Call<Document> listShippingCategories();

  @GET("/shipping_categories")
  Call<Document> listShippingCategories(@QueryMap Map<String, String> queryStringParams);

  @POST("/shipping_categories")
  Call<Document> createShippingCategory(@Body ShippingCategory shippingCategory);

  @GET("/shipping_categories/{shippingCategoryId}")
  Call<Document> retrieveShippingCategory(@Path("shippingCategoryId") String shippingCategoryId);

  @GET("/shipping_categories/{shippingCategoryId}")
  Call<Document> retrieveShippingCategory(@Path("shippingCategoryId") String shippingCategoryId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/shipping_categories/{shippingCategoryId}")
  Call<Document> updateShippingCategory(@Path("shippingCategoryId") String shippingCategoryId,
      @Body ShippingCategory shippingCategory);

  @DELETE("/shipping_categories/{shippingCategoryId}")
  Call<Void> deleteShippingCategory(@Path("shippingCategoryId") String shippingCategoryId);

  @GET("/shipping_categories/{shippingCategoryId}/skus")
  Call<Document> listShippingCategorySkus(@Path("shippingCategoryId") String shippingCategoryId);

  @GET("/shipping_categories/{shippingCategoryId}/skus")
  Call<Document> listShippingCategorySkus(@Path("shippingCategoryId") String shippingCategoryId,
      @QueryMap Map<String, String> queryStringParams);
}
