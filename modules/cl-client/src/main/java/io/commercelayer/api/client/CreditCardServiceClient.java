package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.CreditCard;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CreditCardService;
import java.lang.String;
import java.lang.Void;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class CreditCardServiceClient extends AbstractServiceClient {
  protected CreditCardService service;

  public CreditCardServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(CreditCardService.class, CreditCard.class);
  }

  public CreditCardServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(CreditCardService.class, CreditCard.class);
  }

  public List<CreditCard> listCreditCards(Map<String, String> queryStringParams) throws
      ApiException {
    Call<List<CreditCard>> call = service.listCreditCards(queryStringParams);
    return syncCall(call);
  }

  public void listCreditCards(Map<String, String> queryStringParams,
      ApiCallback<List<CreditCard>> callback) {
    Call<List<CreditCard>> call = service.listCreditCards(queryStringParams);
    asyncCall(call, callback);
  }

  public List<CreditCard> listCreditCards() throws ApiException {
    Call<List<CreditCard>> call = service.listCreditCards();
    return syncCall(call);
  }

  public void listCreditCards(ApiCallback<List<CreditCard>> callback) {
    Call<List<CreditCard>> call = service.listCreditCards();
    asyncCall(call, callback);
  }

  public CreditCard createCreditCard(CreditCard creditCard) throws ApiException {
    Call<CreditCard> call = service.createCreditCard(creditCard);
    return syncCall(call);
  }

  public void createCreditCard(CreditCard creditCard, ApiCallback<CreditCard> callback) {
    Call<CreditCard> call = service.createCreditCard(creditCard);
    asyncCall(call, callback);
  }

  public void deleteCreditCard(String creditCardId) throws ApiException {
    Call<Void> call = service.deleteCreditCard(creditCardId);
    syncCall(call);
  }

  public void deleteCreditCard(String creditCardId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteCreditCard(creditCardId);
    asyncCall(call, callback);
  }

  public CreditCard updateCreditCard(String creditCardId, CreditCard creditCard) throws
      ApiException {
    Call<CreditCard> call = service.updateCreditCard(creditCardId, creditCard);
    return syncCall(call);
  }

  public void updateCreditCard(String creditCardId, CreditCard creditCard,
      ApiCallback<CreditCard> callback) {
    Call<CreditCard> call = service.updateCreditCard(creditCardId, creditCard);
    asyncCall(call, callback);
  }

  public CreditCard retrieveCreditCard(String creditCardId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCreditCard(String creditCardId, Map<String, String> queryStringParams,
      ApiCallback<CreditCard> callback) {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId, queryStringParams);
    asyncCall(call, callback);
  }

  public CreditCard retrieveCreditCard(String creditCardId) throws ApiException {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId);
    return syncCall(call);
  }

  public void retrieveCreditCard(String creditCardId, ApiCallback<CreditCard> callback) {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId);
    asyncCall(call, callback);
  }

  public Order retrieveCreditCardOrder(String creditCardId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveCreditCardOrder(String creditCardId, Map<String, String> queryStringParams,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId, queryStringParams);
    asyncCall(call, callback);
  }

  public Order retrieveCreditCardOrder(String creditCardId) throws ApiException {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId);
    return syncCall(call);
  }

  public void retrieveCreditCardOrder(String creditCardId, ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId);
    asyncCall(call, callback);
  }
}
