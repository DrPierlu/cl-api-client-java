package io.commercelayer.api.test.model;

import org.junit.Test;

import io.commercelayer.api.client.CustomerServiceClient;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Customer;

public class CustomerTest extends AbstractModelTest<Customer> {
	
	private CustomerServiceClient serviceClient = initServiceClient(CustomerServiceClient.class);
	

	@Test
	public void createCustomerTest() throws ConnectionException, ApiException {
		Customer customer = createCustomer(getCustomerTestData_1());
		logger.debug(customer.toString());
	}
	
	public Customer createCustomer(Customer c) throws ApiException, ConnectionException {
		Customer customer = serviceClient.createCustomer(c);
		return customer;
	}
	
	public static Customer getCustomerTestData_1() {
		
		Customer c = new Customer();
		
		c.setEmail("mariorossi@server.com");
		
		return c;
		
	}

}
