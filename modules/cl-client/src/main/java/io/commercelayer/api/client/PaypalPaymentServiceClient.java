package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaypalPayment;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PaypalPaymentService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class PaypalPaymentServiceClient extends AbstractServiceClient {
  protected PaypalPaymentService service;

  public PaypalPaymentServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(PaypalPaymentService.class, PaypalPayment.class);
  }

  public PaypalPaymentServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(PaypalPaymentService.class, PaypalPayment.class);
  }

  public List<PaypalPayment> listPaypalPayments(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<PaypalPayment>> call = service.listPaypalPayments(queryStringParams);
    return syncCall(call);
  }

  public void listPaypalPayments(Map<String, String> queryStringParams,
      ApiCallback<List<PaypalPayment>> callback) {
    Call<List<PaypalPayment>> call = service.listPaypalPayments(queryStringParams);
    asyncCall(call, callback);
  }

  public List<PaypalPayment> listPaypalPayments() throws ApiException {
    Call<List<PaypalPayment>> call = service.listPaypalPayments();
    return syncCall(call);
  }

  public void listPaypalPayments(ApiCallback<List<PaypalPayment>> callback) {
    Call<List<PaypalPayment>> call = service.listPaypalPayments();
    asyncCall(call, callback);
  }

  public PaypalPayment createPaypalPayment(PaypalPayment paypalPayment) throws ApiException {
    Call<PaypalPayment> call = service.createPaypalPayment(paypalPayment);
    return syncCall(call);
  }

  public void createPaypalPayment(PaypalPayment paypalPayment,
      ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.createPaypalPayment(paypalPayment);
    asyncCall(call, callback);
  }

  public void deletePaypalPayment(String paypalPaymentId) throws ApiException {
    Call<Void> call = service.deletePaypalPayment(paypalPaymentId);
    syncCall(call);
  }

  public void deletePaypalPayment(String paypalPaymentId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePaypalPayment(paypalPaymentId);
    asyncCall(call, callback);
  }

  public PaypalPayment updatePaypalPayment(String paypalPaymentId, PaypalPayment paypalPayment)
      throws ApiException {
    Call<PaypalPayment> call = service.updatePaypalPayment(paypalPaymentId, paypalPayment);
    return syncCall(call);
  }

  public void updatePaypalPayment(String paypalPaymentId, PaypalPayment paypalPayment,
      ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.updatePaypalPayment(paypalPaymentId, paypalPayment);
    asyncCall(call, callback);
  }

  public PaypalPayment retrievePaypalPayment(String paypalPaymentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId, queryStringParams);
    return syncCall(call);
  }

  public void retrievePaypalPayment(String paypalPaymentId, Map<String, String> queryStringParams,
      ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId, queryStringParams);
    asyncCall(call, callback);
  }

  public PaypalPayment retrievePaypalPayment(String paypalPaymentId) throws ApiException {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId);
    return syncCall(call);
  }

  public void retrievePaypalPayment(String paypalPaymentId, ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId);
    asyncCall(call, callback);
  }

  public Order retrievePaypalPaymentOrder(String paypalPaymentId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId, queryStringParams);
    return syncCall(call);
  }

  public void retrievePaypalPaymentOrder(String paypalPaymentId,
      Map<String, String> queryStringParams, ApiCallback<Order> callback) {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId, queryStringParams);
    asyncCall(call, callback);
  }

  public Order retrievePaypalPaymentOrder(String paypalPaymentId) throws ApiException {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId);
    return syncCall(call);
  }

  public void retrievePaypalPaymentOrder(String paypalPaymentId, ApiCallback<Order> callback) {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId);
    asyncCall(call, callback);
  }
}
