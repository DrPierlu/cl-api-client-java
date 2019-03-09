package io.commercelayer.api.client;

import io.commercelayer.api.auth.ApiAuth;
import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.LineItem;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.PaymentMethod;
import io.commercelayer.api.model.Shipment;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.service.OrderService;
import java.util.List;
import retrofit2.Call;

public class OrderServiceClient extends AbstractServiceClient<OrderService> {
  {
    initServiceCallFactory(OrderService.class, Order.class);
  }

  public OrderServiceClient(ApiOrganization apiOrg, ApiAuth apiAuth) throws AuthException {
    super(apiOrg, apiAuth);
  }

  public OrderServiceClient(ApiOrganization apiOrg, ApiToken apiToken) throws AuthException {
    super(apiOrg, apiToken);
  }

  public List<Order> listOrders(QueryFilter queryFilter) throws ApiException {
    Call<List<Order>> call = service.listOrders(queryFilter);
    return syncCall(call);
  }

  public void listOrders(QueryFilter queryFilter, ApiCallback<List<Order>> callback) {
    Call<List<Order>> call = service.listOrders(queryFilter);
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

  public Order createOrder(Order order, QueryFilter queryFilter) throws ApiException {
    Call<Order> call = service.createOrder(order, queryFilter);
    return syncCall(call);
  }

  public void createOrder(Order order, QueryFilter queryFilter, ApiCallback<Order> callback) {
    Call<Order> call = service.createOrder(order, queryFilter);
    asyncCall(call, callback);
  }

  public Order createOrder(Order order) throws ApiException {
    Call<Order> call = service.createOrder(order);
    return syncCall(call);
  }

  public void createOrder(Order order, ApiCallback<Order> callback) {
    Call<Order> call = service.createOrder(order);
    asyncCall(call, callback);
  }

  public Order updateOrder(String orderId, Order order, QueryFilter queryFilter) throws
      ApiException {
    Call<Order> call = service.updateOrder(orderId, order, queryFilter);
    return syncCall(call);
  }

  public void updateOrder(String orderId, Order order, QueryFilter queryFilter,
      ApiCallback<Order> callback) {
    Call<Order> call = service.updateOrder(orderId, order, queryFilter);
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

  public Order retrieveOrder(String orderId, QueryFilter queryFilter) throws ApiException {
    Call<Order> call = service.retrieveOrder(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrder(String orderId, QueryFilter queryFilter, ApiCallback<Order> callback) {
    Call<Order> call = service.retrieveOrder(orderId, queryFilter);
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

  public void deleteOrder(String orderId) throws ApiException {
    Call<Void> call = service.deleteOrder(orderId);
    syncCall(call);
  }

  public void deleteOrder(String orderId, ApiCallback<Void> callback) {
    Call<Void> call = service.deleteOrder(orderId);
    asyncCall(call, callback);
  }

  public List<Address> retrieveOrderBillingAddress(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Address>> call = service.retrieveOrderBillingAddress(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrderBillingAddress(String orderId, QueryFilter queryFilter,
      ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveOrderBillingAddress(orderId, queryFilter);
    asyncCall(call, callback);
  }

  public List<Address> retrieveOrderBillingAddress(String orderId) throws ApiException {
    Call<List<Address>> call = service.retrieveOrderBillingAddress(orderId);
    return syncCall(call);
  }

  public void retrieveOrderBillingAddress(String orderId, ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveOrderBillingAddress(orderId);
    asyncCall(call, callback);
  }

  public Customer retrieveOrderCustomer(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<Customer> call = service.retrieveOrderCustomer(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrderCustomer(String orderId, QueryFilter queryFilter,
      ApiCallback<Customer> callback) {
    Call<Customer> call = service.retrieveOrderCustomer(orderId, queryFilter);
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

  public List<LineItem> listOrderLineItems(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId, queryFilter);
    return syncCall(call);
  }

  public void listOrderLineItems(String orderId, QueryFilter queryFilter,
      ApiCallback<List<LineItem>> callback) {
    Call<List<LineItem>> call = service.listOrderLineItems(orderId, queryFilter);
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

  public Market retrieveOrderMarket(String orderId, QueryFilter queryFilter) throws ApiException {
    Call<Market> call = service.retrieveOrderMarket(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrderMarket(String orderId, QueryFilter queryFilter,
      ApiCallback<Market> callback) {
    Call<Market> call = service.retrieveOrderMarket(orderId, queryFilter);
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

  public PaymentMethod retrieveOrderPaymentMethod(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrderPaymentMethod(String orderId, QueryFilter queryFilter,
      ApiCallback<PaymentMethod> callback) {
    Call<PaymentMethod> call = service.retrieveOrderPaymentMethod(orderId, queryFilter);
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

  public List<Shipment> listOrderShipments(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Shipment>> call = service.listOrderShipments(orderId, queryFilter);
    return syncCall(call);
  }

  public void listOrderShipments(String orderId, QueryFilter queryFilter,
      ApiCallback<List<Shipment>> callback) {
    Call<List<Shipment>> call = service.listOrderShipments(orderId, queryFilter);
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

  public List<Address> retrieveOrderShippingAddress(String orderId, QueryFilter queryFilter) throws
      ApiException {
    Call<List<Address>> call = service.retrieveOrderShippingAddress(orderId, queryFilter);
    return syncCall(call);
  }

  public void retrieveOrderShippingAddress(String orderId, QueryFilter queryFilter,
      ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveOrderShippingAddress(orderId, queryFilter);
    asyncCall(call, callback);
  }

  public List<Address> retrieveOrderShippingAddress(String orderId) throws ApiException {
    Call<List<Address>> call = service.retrieveOrderShippingAddress(orderId);
    return syncCall(call);
  }

  public void retrieveOrderShippingAddress(String orderId, ApiCallback<List<Address>> callback) {
    Call<List<Address>> call = service.retrieveOrderShippingAddress(orderId);
    asyncCall(call, callback);
  }
}
