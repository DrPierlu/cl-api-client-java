package io.commercelayer.api.service.document;

import io.commercelayer.api.model.DeliveryLeadTime;
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

public interface DeliveryLeadTimeService {
  @GET("/delivery_lead_times")
  Call<Document> listDeliveryLeadTimes();

  @GET("/delivery_lead_times")
  Call<Document> listDeliveryLeadTimes(@QueryMap Map<String, String> queryStringParams);

  @POST("/delivery_lead_times")
  Call<Document> createDeliveryLeadTime(@Body DeliveryLeadTime deliveryLeadTime);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}")
  Call<Document> retrieveDeliveryLeadTime(@Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}")
  Call<Document> retrieveDeliveryLeadTime(@Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);

  @PATCH("/delivery_lead_times/{deliveryLeadTimeId}")
  Call<Document> updateDeliveryLeadTime(@Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @Body DeliveryLeadTime deliveryLeadTime);

  @DELETE("/delivery_lead_times/{deliveryLeadTimeId}")
  Call<Void> deleteDeliveryLeadTime(@Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}/shipping_method")
  Call<Document> retrieveDeliveryLeadTimeShippingMethod(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}/shipping_method")
  Call<Document> retrieveDeliveryLeadTimeShippingMethod(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}/stock_location")
  Call<Document> retrieveDeliveryLeadTimeStockLocation(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId);

  @GET("/delivery_lead_times/{deliveryLeadTimeId}/stock_location")
  Call<Document> retrieveDeliveryLeadTimeStockLocation(
      @Path("deliveryLeadTimeId") String deliveryLeadTimeId,
      @QueryMap Map<String, String> queryStringParams);
}
