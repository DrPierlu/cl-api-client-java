package io.commercelayer.api.service.document;

import io.commercelayer.api.model.ShippingMethod;
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

public interface ShippingMethodService {
  @GET("/shipping_methods")
  Call<Document> listShippingMethods();

  @GET("/shipping_methods")
  Call<Document> listShippingMethods(@QueryMap Map<String, String> queryStringParams);

  @POST("/shipping_methods")
  Call<Document> createShippingMethod(@Body ShippingMethod shippingMethod);

  @GET("/shipping_methods/{shippingMethodId}")
  Call<Document> retrieveShippingMethod(@Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}")
  Call<Document> retrieveShippingMethod(@Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/shipping_methods/{shippingMethodId}")
  Call<Document> updateShippingMethod(@Path("shippingMethodId") String shippingMethodId,
      @Body ShippingMethod shippingMethod);

  @DELETE("/shipping_methods/{shippingMethodId}")
  Call<Void> deleteShippingMethod(@Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}/delivery_lead_time_for_shipment")
  Call<Document> retrieveShippingMethodDeliveryLeadTimeForShipment(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}/delivery_lead_time_for_shipment")
  Call<Document> retrieveShippingMethodDeliveryLeadTimeForShipment(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipping_methods/{shippingMethodId}/market")
  Call<Document> retrieveShippingMethodMarket(@Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}/market")
  Call<Document> retrieveShippingMethodMarket(@Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipping_methods/{shippingMethodId}/shipping_category")
  Call<Document> retrieveShippingMethodShippingCategory(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}/shipping_category")
  Call<Document> retrieveShippingMethodShippingCategory(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/shipping_methods/{shippingMethodId}/shipping_zone")
  Call<Document> retrieveShippingMethodShippingZone(
      @Path("shippingMethodId") String shippingMethodId);

  @GET("/shipping_methods/{shippingMethodId}/shipping_zone")
  Call<Document> retrieveShippingMethodShippingZone(
      @Path("shippingMethodId") String shippingMethodId,
      @QueryMap Map<String, String> queryStringParams);
}
