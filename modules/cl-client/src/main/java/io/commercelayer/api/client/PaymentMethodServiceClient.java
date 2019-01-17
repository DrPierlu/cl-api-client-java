package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.PaymentGateway;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.PaymentMethodService;
import java.util.List;
import retrofit2.Call;

public class PaymentMethodServiceClient extends AbstractServiceClient<PaymentMethodService> {
  {
    initServiceCallFactory(PaymentMethodService.class, PaymentMethod.class);
  }

  public PaymentMethodServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public PaymentMethodServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws
      AuthException {
    super(apiOrg, apiToken);
  }

  public List<PaymentMethod> listPaymentMethods(QueryFilter queryFilter) throws ApiException {
    Call<List<PaymentMethod>> call = service.listPaymentMethods(queryFilter);
    return syncCall(call);
  }

  public void listPaymentMethods(QueryFilter queryFilter,
      ApiCallback<List<PaymentMethod>> callback) {
    Call<List<PaymentMethod>> call = service.listPaymentMethods(queryFilter);
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

  public void deletePaymentMethod(String paymentMethodId) throws ApiException {
    Call<Void> call = service.deletePaymentMethod(paymentMethodId);
    syncCall(call);
  }

  public void deletePaymentMethod(String paymentMethodId, ApiCallback<Void> callback) {
    Call<Void> call = service.deletePaymentMethod(paymentMethodId);
    asyncCall(call, callback);
  }

  public PaymentMethod retrievePaymentMethod(String paymentMethodId, QueryFilter queryFilter) throws
      ApiException {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId, queryFilter);
    return syncCall(call);
  }

  public void retrievePaymentMethod(String paymentMethodId, QueryFilter queryFilter,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrievePaymentMethod(paymentMethodId, queryFilter);
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

  public Market retrievePaymentMethodMarket(String paymentMethodId, QueryFilter queryFilter) throws
      ApiException {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId, queryFilter);
    return syncCall(call);
  }

  public void retrievePaymentMethodMarket(String paymentMethodId, QueryFilter queryFilter,
      ApiCallback<Market> callback) {
    Call<Market> call = service.retrievePaymentMethodMarket(paymentMethodId, queryFilter);
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
      QueryFilter queryFilter) throws ApiException {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId, queryFilter);
    return syncCall(call);
  }

  public void retrievePaymentMethodPaymentGateway(String paymentMethodId, QueryFilter queryFilter,
      ApiCallback<PaymentGateway> callback) {
    Call<PaymentGateway> call = service.retrievePaymentMethodPaymentGateway(paymentMethodId, queryFilter);
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
