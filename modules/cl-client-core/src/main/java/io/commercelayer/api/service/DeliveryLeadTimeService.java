package io.commercelayer.api.service;

import io.commercelayer.api.model.DeliveryLeadTime;
import io.commercelayer.api.model.ShippingMethod;
import io.commercelayer.api.model.StockLocation;
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

public interface DeliveryLeadTimeService {
  @GET("delivery_lead_times")
  Call<List<DeliveryLeadTime>> listDeliveryLeadTimes();

  @GET("delivery_lead_times")
  Call<List<DeliveryLeadTime>> listDeliveryLeadTimes(
      @QueryMap Map<String, String> queryStringParams);

  @POST("delivery_lead_times")
  Call<DeliveryLeadTime> createDeliveryLeadTime(@Body DeliveryLeadTime deliveryLeadTime);

  @PATCH("delivery_lead_times/{deliveryLeadTimeId}")
  Call<DeliveryLeadTime> updateDeliveryLeadTime(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @Body DeliveryLeadTime deliveryLeadTime);

  @DELETE("delivery_lead_times/{deliveryLeadTimeId}")
  Call<Void> deleteDeliveryLeadTime(@Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("delivery_lead_times/{deliveryLeadTimeId}")
  Call<DeliveryLeadTime> retrieveDeliveryLeadTime(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("delivery_lead_times/{deliveryLeadTimeId}")
  Call<DeliveryLeadTime> retrieveDeliveryLeadTime(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("delivery_lead_times/{deliveryLeadTimeId}/shipping_method")
  Call<ShippingMethod> retrieveDeliveryLeadTimeShippingMethod(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("delivery_lead_times/{deliveryLeadTimeId}/shipping_method")
  Call<ShippingMethod> retrieveDeliveryLeadTimeShippingMethod(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("delivery_lead_times/{deliveryLeadTimeId}/stock_location")
  Call<StockLocation> retrieveDeliveryLeadTimeStockLocation(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("delivery_lead_times/{deliveryLeadTimeId}/stock_location")
  Call<StockLocation> retrieveDeliveryLeadTimeStockLocation(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);
}
