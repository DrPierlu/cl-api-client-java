package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.CreditCard;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.CreditCardService;
import java.util.List;
import retrofit2.Call;

public class CreditCardServiceClient extends AbstractServiceClient {
  protected final CreditCardService service;

  {
    this.service = initServiceCallFactory(CreditCardService.class, CreditCard.class);
  }

  public CreditCardServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public CreditCardServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<CreditCard> listCreditCards(QueryFilter queryFilter) throws ApiException {
    Call<List<CreditCard>> call = service.listCreditCards(queryFilter);
    return syncCall(call);
  }

  public void listCreditCards(QueryFilter queryFilter, ApiCallback<List<CreditCard>> callback) {
    Call<List<CreditCard>> call = service.listCreditCards(queryFilter);
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

  public CreditCard retrieveCreditCard(String creditCardId, QueryFilter queryFilter) throws
      ApiException {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCreditCard(String creditCardId, QueryFilter queryFilter,
      ApiCallback<CreditCard> callback) {
    Call<CreditCard> call = service.retrieveCreditCard(creditCardId, queryFilter);
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

  public Order retrieveCreditCardOrder(String creditCardId, QueryFilter queryFilter) throws
      ApiException {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId, queryFilter);
    return syncCall(call);
  }

  public void retrieveCreditCardOrder(String creditCardId, QueryFilter queryFilter,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveCreditCardOrder(creditCardId, queryFilter);
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
