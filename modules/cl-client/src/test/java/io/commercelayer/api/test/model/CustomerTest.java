package io.commercelayer.api.test.model;

import org.junit.BeforeClass;
import org.junit.Test;

import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.service.CustomerService;
import retrofit2.Call;

public class CustomerTest extends AbstractModelTest {
	
	private CustomerService service;
	
	@BeforeClass
	private void initServiceInterface() {
		service = apiCaller.getServiceCallFactory(CustomerService.class);
	}
	

	@Test
	public void createCustomerTest() throws ConnectionException, ApiException {
		Customer customer = createCustomer(getCustomerTestData_1());
		logger.debug(customer.toString());
	}
	
	public Customer createCustomer(Customer c) throws ApiException, ConnectionException {
		Call<Customer> call = service.createCustomer(c);
		return apiCaller.call(call);
	}
	
	public static Customer getCustomerTestData_1() {
		
		Customer c = new Customer();
		
		c.setEmail("mariorossi@server.com");
		
		return c;
		
	}
	
	
	public static void main(String[] args) throws ConnectionException, ApiException {
		initServiceClient();
		CustomerTest test = new CustomerTest();
		test.initServiceInterface();
		test.createCustomerTest();
	}

}
