package io.commercelayer.api.service;

import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.WireTransfer;
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

public interface WireTransferService {
  @GET("wire_transfers")
  Call<List<WireTransfer>> listWireTransfers();

  @GET("wire_transfers")
  Call<List<WireTransfer>> listWireTransfers(@QueryMap Map<String, String> queryStringParams);

  @POST("wire_transfers")
  Call<WireTransfer> createWireTransfer(@Body WireTransfer wireTransfer);

  @PATCH("wire_transfers/{wireTransferId}")
  Call<WireTransfer> updateWireTransfer(@Path("wireTransferId") String wireTransferId,
      @Body WireTransfer wireTransfer);

  @DELETE("wire_transfers/{wireTransferId}")
  Call<Void> deleteWireTransfer(@Path("wireTransferId") String wireTransferId);

  @GET("wire_transfers/{wireTransferId}")
  Call<WireTransfer> retrieveWireTransfer(@Path("wireTransferId") String wireTransferId);

  @GET("wire_transfers/{wireTransferId}")
  Call<WireTransfer> retrieveWireTransfer(@Path("wireTransferId") String wireTransferId,
      @QueryMap Map<String, String> queryStringParams);

  @GET("wire_transfers/{wireTransferId}/order")
  Call<Order> retrieveWireTransferOrder(@Path("wireTransferId") String wireTransferId);

  @GET("wire_transfers/{wireTransferId}/order")
  Call<Order> retrieveWireTransferOrder(@Path("wireTransferId") String wireTransferId,
      @QueryMap Map<String, String> queryStringParams);
}
