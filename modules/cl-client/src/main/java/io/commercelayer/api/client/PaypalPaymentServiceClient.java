package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaypalPayment;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PaypalPaymentService;
import java.util.List;
import retrofit2.Call;

public class PaypalPaymentServiceClient extends AbstractServiceClient<PaypalPaymentService> {
  {
    initServiceCallFactory(PaypalPaymentService.class, PaypalPayment.class);
  }

  public PaypalPaymentServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public PaypalPaymentServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<PaypalPayment> listPaypalPayments(QueryFilter queryFilter) throws ApiException {
    Call<List<PaypalPayment>> call = service.listPaypalPayments(queryFilter);
    return syncCall(call);
  }

  public void listPaypalPayments(QueryFilter queryFilter,
      ApiCallback<List<PaypalPayment>> callback) {
    Call<List<PaypalPayment>> call = service.listPaypalPayments(queryFilter);
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

  public PaypalPayment createPaypalPayment(PaypalPayment paypalPayment, QueryFilter queryFilter)
      throws ApiException {
    Call<PaypalPayment> call = service.createPaypalPayment(paypalPayment, queryFilter);
    return syncCall(call);
  }

  public void createPaypalPayment(PaypalPayment paypalPayment, QueryFilter queryFilter,
      ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.createPaypalPayment(paypalPayment, queryFilter);
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

  public PaypalPayment updatePaypalPayment(String paypalPaymentId, PaypalPayment paypalPayment,
      QueryFilter queryFilter) throws ApiException {
    Call<PaypalPayment> call = service.updatePaypalPayment(paypalPaymentId, paypalPayment, queryFilter);
    return syncCall(call);
  }

  public void updatePaypalPayment(String paypalPaymentId, PaypalPayment paypalPayment,
      QueryFilter queryFilter, ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.updatePaypalPayment(paypalPaymentId, paypalPayment, queryFilter);
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

  public PaypalPayment retrievePaypalPayment(String paypalPaymentId, QueryFilter queryFilter) throws
      ApiException {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId, queryFilter);
    return syncCall(call);
  }

  public void retrievePaypalPayment(String paypalPaymentId, QueryFilter queryFilter,
      ApiCallback<PaypalPayment> callback) {
    Call<PaypalPayment> call = service.retrievePaypalPayment(paypalPaymentId, queryFilter);
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

  public void deletePaypalPayment(String paypalPaymentId) throws ApiException {
    Call<Void> call = service.deletePaypalPayment(paypalPaymentId);
    syncCall(call);
  }

  public void deletePaypalPayment(String paypalPaymentId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePaypalPayment(paypalPaymentId);
    asyncCall(call, callback);
  }

  public Order retrievePaypalPaymentOrder(String paypalPaymentId, QueryFilter queryFilter) throws
      ApiException {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId, queryFilter);
    return syncCall(call);
  }

  public void retrievePaypalPaymentOrder(String paypalPaymentId, QueryFilter queryFilter,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrievePaypalPaymentOrder(paypalPaymentId, queryFilter);
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
