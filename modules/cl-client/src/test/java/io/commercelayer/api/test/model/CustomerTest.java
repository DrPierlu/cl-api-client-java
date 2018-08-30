package io.commercelayer.api.test.model;

import java.util.Arrays;

import org.junit.BeforeClass;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Customer;
import io.commercelayer.api.model.CustomerAddress;
import io.commercelayer.api.service.CustomerService;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.test.TestData;
import retrofit2.Call;

public class CustomerTest extends AbstractModelTest {
	
	private CustomerService service;
	
	@BeforeClass
	private void initServiceInterface() {
		service = apiClient.getRawClient(CustomerService.class);
	}
	
//	public static void main(String[] args) {
//		
//		initServiceClient();
//		
//		Customer customer = new Customer();
//		customer.setEmail("cicciopasticcio@server.it");
//		
//		CustomerAddress address = new CustomerAddress();
//		address.setId("1000");
//		customer.setCustomerAddressResourceList(Arrays.asList(new CustomerAddress[] {address}));
//		
//		Call<Customer> call = service.createCustomer(customer);
//		
//		try {
//			customer = apiClient.execute(call);
//		} catch (ConnectionException | ApiException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(customer);
//		
//	}

}
