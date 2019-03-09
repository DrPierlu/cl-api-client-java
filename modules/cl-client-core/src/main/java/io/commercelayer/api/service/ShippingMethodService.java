package io.commercelayer.api.service;

import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.ShippingCategory;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.ShippingZone;
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

public interface ShippingMethodService {
  @GET("shipping_methods")
  Call<List<ShippingMethod>> listShippingMethods();

  @GET("shipping_methods")
  Call<List<ShippingMethod>> listShippingMethods(@QueryMap Map<String, String> queryStringParams);

  @POST("shipping_methods")
  Call<ShippingMethod> createShippingMethod(@Body ShippingMethod shippingMethod);

  @POST("shipping_methods")
  Call<ShippingMethod> createShippingMethod(@Body ShippingMethod shippingMethod,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("shipping_methods/{shippingMethodId}")
  Call<ShippingMethod> updateShippingMethod(@Path("shippingMethodId") String shippingMethodId,
      @Body ShippingMethod shippingMethod);

  @PATCH("shipping_methods/{shippingMethodId}")
  Call<ShippingMethod> updateShippingMethod(@Path("shippingMethodId") String shippingMethodId,
      @Body ShippingMethod shippingMethod, @QueryMap Map<String, String> queryStringParams);

  @GET("shipping_methods/{shippingMethodId}")
  Call<ShippingMethod> retrieveShippingMethod(@Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}")
  Call<ShippingMethod> retrieveShippingMethod(@Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @DELETE("shipping_methods/{shippingMethodId}")
  Call<Void> deleteShippingMethod(@Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}/delivery_lead_time_for_shipment")
  Call<List<DeliveryLeadTime>> retrieveShippingMethodDeliveryLeadTimeForShipment(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}/delivery_lead_time_for_shipment")
  Call<List<DeliveryLeadTime>> retrieveShippingMethodDeliveryLeadTimeForShipment(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipping_methods/{shippingMethodId}/market")
  Call<Market> retrieveShippingMethodMarket(@Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}/market")
  Call<Market> retrieveShippingMethodMarket(@Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipping_methods/{shippingMethodId}/shipping_category")
  Call<ShippingCategory> retrieveShippingMethodShippingCategory(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}/shipping_category")
  Call<ShippingCategory> retrieveShippingMethodShippingCategory(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("shipping_methods/{shippingMethodId}/shipping_zone")
  Call<ShippingZone> retrieveShippingMethodShippingZone(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("shipping_methods/{shippingMethodId}/shipping_zone")
  Call<ShippingZone> retrieveShippingMethodShippingZone(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);
}
