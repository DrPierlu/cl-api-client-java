package io.commercelayer.api.service;

import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.Sku;
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

public interface ShippingCategoryService {
  @GET("shipping_categories")
  Call<List<ShippingCategory>> listShippingCategories();

  @GET("shipping_categories")
  Call<List<ShippingCategory>> listShippingCategories(
      @QueryMap Map<String, String> queryStringParams);

  @POST("shipping_categories")
  Call<ShippingCategory> createShippingCategory(@Body ShippingCategory shippingCategory);

  @DELETE("shipping_categories/{shippingCategoryId}")
  Call<Void> deleteShippingCategory(@Path("shippingCategoryId") String shippingCategoryId);

  @PATCH("shipping_categories/{shippingCategoryId}")
  Call<ShippingCategory> updateShippingCategory(
      @Path("shippingCategoryId") String shippingCategoryId,
      @Body ShippingCategory shippingCategory);

  @GET("shipping_categories/{shippingCategoryId}")
  Call<ShippingCategory> retrieveShippingCategory(
      @Path("shippingCategoryId") String shippingCategoryId);

  @GET("shipping_categories/{shippingCategoryId}")
  Call<ShippingCategory> retrieveShippingCategory(
      @Path("shippingCategoryId") String shippingCategoryId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipping_categories/{shippingCategoryId}/skus")
  Call<List<Sku>> listShippingCategorySkus(@Path("shippingCategoryId") String shippingCategoryId);

  @GET("shipping_categories/{shippingCategoryId}/skus")
  Call<List<Sku>> listShippingCategorySkus(@Path("shippingCategoryId") String shippingCategoryId,
      @QueryMap Map<String, String> queryStringParams);
}
