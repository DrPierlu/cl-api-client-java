package io.commercelayer.api.test.model;

import org.junit.Test;

import io.commercelayer.api.client.OrderServiceClient;
import io.commercelayer.api.client.common.query.QueryFilter;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Order;

public class OrderTest extends AbstractModelTest<OrderServiceClient> {

	private OrderServiceClient serviceClient = initServiceClient(OrderServiceClient.class);
	
	
	@Test
	public void retrieveOrderTest() throws ApiException {
		
		Order order = retrieveOrder("2881");
		
		System.out.println(order);
		
		System.out.println(order.getCustomerResource());
		
		System.out.println(order.getLineItemResourceList());
		
		
		
	}
	
	public Order retrieveOrder(String orderId) throws ApiException {
		
		QueryFilter filter = QueryFilter.builder()
				.include(Order.Inclusions.LINE_ITEMS)
				.include(Order.Inclusions.CUSTOMER)
				.build();
		
		Order order = serviceClient.retrieveOrder(orderId, filter);
		
		return order;
		
	}
	
	
	public static void main(String[] args) throws ApiException {
		new OrderTest().retrieveOrderTest();
	}
	
}
