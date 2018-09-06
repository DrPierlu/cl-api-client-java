package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.BillingAddress;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.ShippingAddress;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.OrderService;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

public class OrderServiceClient extends AbstractServiceClient {
  protected OrderService service;

  public OrderServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
    this.service = apiCaller.getServiceCallFactory(OrderService.class, Order.class);
  }

  public OrderServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
    this.service = apiCaller.getServiceCallFactory(OrderService.class, Order.class);
  }

  public Order createOrder(Order order) throws ApiException {
    Call<Order> call = service.createOrder(order);
    return syncCall(call);
  }

  public void createOrder(Order order, ApiCallback<Order> callback) {
    Call<Order> call = service.createOrder(order);
    asyncCall(call, callback);
  }

  public List<Order> listOrders(Map<String, String> queryStringParams) throws ApiException {
    Call<List<Order>> call = service.listOrders(queryStringParams);
    return syncCall(call);
  }

  public void listOrders(Map<String, String> queryStringParams, ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listOrders(queryStringParams);
    asyncCall(call, callback);
  }

  public List<Order> listOrders() throws ApiException {
    Call<List<Order>> call = service.listOrders();
    return syncCall(call);
  }

  public void listOrders(ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listOrders();
    asyncCall(call, callback);
  }

  public void deleteOrder(String orderId) throws ApiException {
    Call<Void> call = service.deleteOrder(orderId);
    syncCall(call);
  }

  public void deleteOrder(String orderId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteOrder(orderId);
    asyncCall(call, callback);
  }

  public Order updateOrder(String orderId, Order order) throws ApiException {
    Call<Order> call = service.updateOrder(orderId, order);
    return syncCall(call);
  }

  public void updateOrder(String orderId, Order order, ApiCallback<Order> callback) {
    Call<Order> call = service.updateOrder(orderId, order);
    asyncCall(call, callback);
  }

  public Order retrieveOrder(String orderId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Order> call = service.retrieveOrder(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrder(String orderId, Map<String, String> queryStringParams,
      ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveOrder(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public Order retrieveOrder(String orderId) throws ApiException {
    Call<Order> call = service.retrieveOrder(orderId);
    return syncCall(call);
  }

  public void retrieveOrder(String orderId, ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveOrder(orderId);
    asyncCall(call, callback);
  }

  public BillingAddress retrieveOrderBillingAddress(String orderId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<BillingAddress> call = service.retrieveOrderBillingAddress(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrderBillingAddress(String orderId, Map<String, String> queryStringParams,
      ApiCallback<BillingAddress> callback) {
    Call<BillingAddress> call = service.retrieveOrderBillingAddress(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public BillingAddress retrieveOrderBillingAddress(String orderId) throws ApiException {
    Call<BillingAddress> call = service.retrieveOrderBillingAddress(orderId);
    return syncCall(call);
  }

  public void retrieveOrderBillingAddress(String orderId, ApiCallback<BillingAddress> callback) {
    Call<BillingAddress> call = service.retrieveOrderBillingAddress(orderId);
    asyncCall(call, callback);
  }

  public Customer retrieveOrderCustomer(String orderId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<Customer> call = service.retrieveOrderCustomer(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrderCustomer(String orderId, Map<String, String> queryStringParams,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveOrderCustomer(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public Customer retrieveOrderCustomer(String orderId) throws ApiException {
    Call<Customer> call = service.retrieveOrderCustomer(orderId);
    return syncCall(call);
  }

  public void retrieveOrderCustomer(String orderId, ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveOrderCustomer(orderId);
    asyncCall(call, callback);
  }

  public List<LineItem> listOrderLineItems(String orderId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId, queryStringParams);
    return syncCall(call);
  }

  public void listOrderLineItems(String orderId, Map<String, String> queryStringParams,
      ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<LineItem> listOrderLineItems(String orderId) throws ApiException {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId);
    return syncCall(call);
  }

  public void listOrderLineItems(String orderId, ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId);
    asyncCall(call, callback);
  }

  public Market retrieveOrderMarket(String orderId, Map<String, String> queryStringParams) throws
      ApiException {
    Call<Market> call = service.retrieveOrderMarket(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrderMarket(String orderId, Map<String, String> queryStringParams,
      ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveOrderMarket(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public Market retrieveOrderMarket(String orderId) throws ApiException {
    Call<Market> call = service.retrieveOrderMarket(orderId);
    return syncCall(call);
  }

  public void retrieveOrderMarket(String orderId, ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveOrderMarket(orderId);
    asyncCall(call, callback);
  }

  public PaymentMethod retrieveOrderPaymentMethod(String orderId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrderPaymentMethod(String orderId, Map<String, String> queryStringParams,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public PaymentMethod retrieveOrderPaymentMethod(String orderId) throws ApiException {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId);
    return syncCall(call);
  }

  public void retrieveOrderPaymentMethod(String orderId, ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId);
    asyncCall(call, callback);
  }

  public List<Shipment> listOrderShipments(String orderId, Map<String, String> queryStringParams)
      throws ApiException {
    Call<List<Shipment>> call = service.listOrderShipments(orderId, queryStringParams);
    return syncCall(call);
  }

  public void listOrderShipments(String orderId, Map<String, String> queryStringParams,
      ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listOrderShipments(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public List<Shipment> listOrderShipments(String orderId) throws ApiException {
    Call<List<Shipment>> call = service.listOrderShipments(orderId);
    return syncCall(call);
  }

  public void listOrderShipments(String orderId, ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listOrderShipments(orderId);
    asyncCall(call, callback);
  }

  public ShippingAddress retrieveOrderShippingAddress(String orderId,
      Map<String, String> queryStringParams) throws ApiException {
    Call<ShippingAddress> call = service.retrieveOrderShippingAddress(orderId, queryStringParams);
    return syncCall(call);
  }

  public void retrieveOrderShippingAddress(String orderId, Map<String, String> queryStringParams,
      ApiCallback<ShippingAddress> callback) {
    Call<ShippingAddress> call = service.retrieveOrderShippingAddress(orderId, queryStringParams);
    asyncCall(call, callback);
  }

  public ShippingAddress retrieveOrderShippingAddress(String orderId) throws ApiException {
    Call<ShippingAddress> call = service.retrieveOrderShippingAddress(orderId);
    return syncCall(call);
  }

  public void retrieveOrderShippingAddress(String orderId, ApiCallback<ShippingAddress> callback) {
    Call<ShippingAddress> call = service.retrieveOrderShippingAddress(orderId);
    asyncCall(call, callback);
  }
}
