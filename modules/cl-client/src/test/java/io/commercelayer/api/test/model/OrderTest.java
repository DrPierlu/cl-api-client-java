package io.commercelayer.api.test.model;

import java.util.List;

import org.junit.Test;

import io.commercelayer.api.client.OrderServiceClient;
import io.commercelayer.api.client.common.ApiCallback;
import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Market;
import io.commercelayer.api.model.Order;
import io.commercelayer.api.model.common.error.ApiError;
import io.commercelayer.api.util.LogUtils;
import okhttp3.Request;

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
				.include("line_items")
				.include("customer")
				.build();
		
		Order order = serviceClient.retrieveOrder(orderId, filter);
		
		return order;
		
	}
	
	
	public static void main(String[] args) throws ApiException {
		new OrderTest().retrieveOrderTest();
	}
	
}
