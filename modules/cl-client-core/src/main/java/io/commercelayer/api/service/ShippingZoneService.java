package io.commercelayer.api.service;

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

public interface ShippingZoneService {
  @GET("shipping_zones")
  Call<List<ShippingZone>> listShippingZones();

  @GET("shipping_zones")
  Call<List<ShippingZone>> listShippingZones(@QueryMap Map<String, String> queryStringParams);

  @POST("shipping_zones")
  Call<ShippingZone> createShippingZone(@Body ShippingZone shippingZone);

  @PATCH("shipping_zones/{shippingZoneId}")
  Call<ShippingZone> updateShippingZone(@Path("shippingZoneId") String shippingZoneId,
      @Body ShippingZone shippingZone);

  @DELETE("shipping_zones/{shippingZoneId}")
  Call<Void> deleteShippingZone(@Path("shippingZoneId") String shippingZoneId);

  @GET("shipping_zones/{shippingZoneId}")
  Call<ShippingZone> retrieveShippingZone(@Path("shippingZoneId") String shippingZoneId);

  @GET("shipping_zones/{shippingZoneId}")
  Call<ShippingZone> retrieveShippingZone(@Path("shippingZoneId") String shippingZoneId,
      @QueryMap Map<String, String> queryStringParams);
}
