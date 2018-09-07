package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.PaymentGateway;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PaymentMethodService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class PaymentMethodServiceClient extends AbstractServiceClient {
  protected final PaymentMethodService service;

  {
    this.service = initServiceCallFactory(PaymentMethodService.class, PaymentMethod.class);
  }

  public PaymentMethodServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public PaymentMethodServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<PaymentMethod> listPaymentMethods(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<PaymentMethod>> call = service.listPaymentMethods(queryStringParams);
    return syncCall(call);
  }

  public void listPaymentMethods(Map<String, String> queryStringParams,
      ApiCallback<List<PaymentMethod>> callback) {
    Call<List<PaymentMethod>> call = service.listPaymentMethods(queryStringParams);
    asyncCall(call, callback);
  }

  public List<PaymentMethod> listPaymentMethods() throws ApiException {
    Call<List<PaymentMethod>> call = service.listPaymentMethods();
    return syncCall(call);
  }

  public void listPaymentMethods(ApiCallback<List<PaymentMethod>> callback) {
    Call<List<PaymentMethod>> call = service.listPaymentMethods();
    asyncCall(call, callback);
  }

  public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) throws ApiException {
    Call<PaymentMethod> call = service.createPaymentMethod(paymentMethod);
    return syncCall(call);
  }

  public void createPaymentMethod(PaymentMethod paymentMethod,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.createPaymentMethod(paymentMethod);
    asyncCall(call, callback);
  }

  public void deletePaymentMethod(String paymentMethodId) throws ApiException {
    Call<Void> call = service.deletePaymentMethod(paymentMethodId);
    syncCall(call);
  }

  public void deletePaymentMethod(String paymentMethodId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePaymentMethod(paymentMethodId);
    asyncCall(call, callback);
  }

  public PaymentMethod updatePaymentMethod(String paymentMethodId, PaymentMethod paymentMethod)
      throws ApiException {
    Call<PaymentMethod> call = service.updatePaymentMethod(paymentMethodId, paymentMethod);
    return syncCall(call);
  }

  public void updatePaymentMethod(String paymentMethodId, PaymentMethod paymentMethod,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.updatePaymentMethod(paymentMethodId, paymentMethod);
    asyncCall(call, callback);
  }

  public PaymentMethod retrievePaymentMethod(String paymentMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrievePaymentMethod(String paymentMethodId, Map<String, String> queryStringParams,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public PaymentMethod retrievePaymentMethod(String paymentMethodId) throws ApiException {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId);
    return syncCall(call);
  }

  public void retrievePaymentMethod(String paymentMethodId, ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId);
    asyncCall(call, callback);
  }

  public Market retrievePaymentMethodMarket(String paymentMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrievePaymentMethodMarket(String paymentMethodId,
      Map<String, String> queryStringParams, ApiCallback<Market> callback) {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public Market retrievePaymentMethodMarket(String paymentMethodId) throws ApiException {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId);
    return syncCall(call);
  }

  public void retrievePaymentMethodMarket(String paymentMethodId, ApiCallback<Market> callback) {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId);
    asyncCall(call, callback);
  }

  public PaymentGateway retrievePaymentMethodPaymentGateway(String paymentMethodId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId, queryStringParams);
    return syncCall(call);
  }

  public void retrievePaymentMethodPaymentGateway(String paymentMethodId,
      Map<String, String> queryStringParams, ApiCallback<PaymentGateway> callback) {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId, queryStringParams);
    asyncCall(call, callback);
  }

  public PaymentGateway retrievePaymentMethodPaymentGateway(String paymentMethodId) throws
      ApiException {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId);
    return syncCall(call);
  }

  public void retrievePaymentMethodPaymentGateway(String paymentMethodId,
      ApiCallback<PaymentGateway> callback) {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId);
    asyncCall(call, callback);
  }
}
