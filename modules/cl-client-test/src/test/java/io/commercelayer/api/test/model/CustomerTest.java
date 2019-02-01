package io.commercelayer.api.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.commercelayer.api.client.CustomerServiceClient;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.exception.ApiException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.test.TestData;

public class CustomerTest extends AbstractModelTest<Customer> {
	
	private CustomerServiceClient serviceClient = initServiceClient(CustomerServiceClient.class);

	

	@Test
	public void customerTest() throws ConnectionException, ApiException {
		
		Customer customer = createCustomer(getCustomerTestData_X());
		logger.debug(customer.toString());
		
		Customer a = retrieveCustomer(customer.getId());
		logger.debug(a.toString());
		
		assertNotNull(a);
		assertNotNull(a.getEmail());
		assertEquals(customer.getId(), a.getId());
		assertEquals(customer, a);
		
		
	}
	
	public Customer createCustomer(Customer c) throws ApiException, ConnectionException {
		return serviceClient.createCustomer(c);
	}
	

	
	public Customer retrieveCustomer(String id) throws ConnectionException, ApiException {
		return serviceClient.retrieveCustomer(id);
	}
	
	
	public static Customer getCustomerTestData_X() {
		
		Customer c = new Customer();
		
		c.setEmail(String.format("test.user.%s@server.com", TestData.getRandomId(5)));
		
		return c;
		
	}

}
