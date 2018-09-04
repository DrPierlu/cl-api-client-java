package io.commercelayer.api.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.commercelayer.api.client.common.QueryFilter;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.service.AddressService;
import retrofit2.Call;

public class AddressTest extends AbstractModelTest {
	
	private AddressService service;
	
	@Before
	public void initServiceInterface() {
		service = apiCaller.getRawClient(AddressService.class);
	}

	
	@Test
	public void createAddressTest() throws ConnectionException, ApiException {
		
		Address in = getAddressTestData_1();
		Address out = createAddress(in);
		logger.debug(out.toString());
		
		assertEquals(in.getFirstName(), out.getFirstName());
		assertNotNull(out.getFullAddress());
		
	}
	
	
	public Address createAddress(Address a) throws ApiException, ConnectionException {
		
		Geocoder g = getGeocoderTestData();
		a.setGeocoderResource(g);
		
		Call<Address> call = service.createAddress(a);
		
		return apiCaller.execute(call);

	}
	
	
	@Test
	public void retrieveAddressTest() throws ConnectionException, ApiException {
		
		String id = "2753";
		
		Address a = retrieveAddress(id);
		logger.debug(a.toString());
		
		assertNotNull(a);
		assertNotNull(a.getFullAddress());
		assertEquals(id, a.getId());
		
	}
	
	
	public Address retrieveAddress(String id) throws ConnectionException, ApiException {
		
		Call<Address> call = service.retrieveAddress(id);
		
		return apiCaller.execute(call);
		
	}
	
	
	@Test
	public void updateAddressTest() throws ConnectionException, ApiException {
		
		Address in = getAddressTestData_2();
		Address out = updateAddress("2753", in);
		logger.debug(out.toString());
		
		assertEquals(in.getFirstName(), out.getFirstName());
		assertNotNull(out.getFullAddress());
		
	}
	
	
	public Address updateAddress(String id, Address a) throws ApiException, ConnectionException {
		
		a.setId(id);
		
		Call<Address> call = service.updateAddress(id, a);
		
		return apiCaller.execute(call);
		
	}
	
	
	@Test
	public void listAddressesTest() throws ConnectionException, ApiException {
		
//		QueryFilter filter = QueryFilter.builder()
//				.fields("addresses", "created_at", "first_name")
//				.sort("created_at", false)
//				.page(2, 2)
//				.build();
//		List<Address> addresses = listAddresses(filter);
		
		List<Address> addresses = listAddresses();
		
		for (Address a : addresses) logger.debug(a.toString());
		
	}
	
	
	public List<Address> listAddresses() throws ApiException, ConnectionException {
		
		Call<List<Address>> apiCall = service.listAddresses();
		
		return apiCaller.execute(apiCall);

	}
	
	public List<Address> listAddresses(QueryFilter filter) throws ApiException, ConnectionException {
		
		Call<List<Address>> apiCall = service.listAddresses(filter);
		
		return apiCaller.execute(apiCall);

	}
	
	
	public static Address getAddressTestData_1() {
		
		Address a = new Address();
		
		a.setLine1("Via Roma");
		a.setCity("Siena");
		a.setZipCode("53100");
		a.setStateCode("SI");
		a.setCountryCode("IT");
		a.setPhone("0577123456789");
		a.setFirstName("Mario");
		a.setLastName("Rossi");
		
		return a;
		
	}
	
	public static Address getAddressTestData_2() {
		
		Address a = new Address();
		
		a.setLine1("Via Milano");
		a.setCity("Poggibonsi");
		a.setZipCode("53036");
		a.setStateCode("SI");
		a.setCountryCode("IT");
		a.setPhone("0577987654321");
		a.setFirstName("Luigi");
		a.setLastName("Verdi");
		
		return a;
		
	}
	
	public static Geocoder getGeocoderTestData() {
		
		Geocoder g = new Geocoder();
		
		g.setId("1000");
		
		return g;
		
	}
	
	
	public static void main(String[] args) throws ConnectionException, ApiException {
		initServiceClient();
		AddressTest test = new AddressTest();
		test.initServiceInterface();
		test.listAddressesTest();
	}
	
}
