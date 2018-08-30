package io.commercelayer.api.test.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.service.AddressService;
import io.commercelayer.api.util.LogUtils;
import retrofit2.Call;

public class AddressTest extends AbstractModelTest {
	
	private AddressService service;
	
	@Before
	public void initServiceInterface() {
		service = apiClient.getRawClient(AddressService.class);
	}

	
	@Test
	public void createAddressTest() throws ConnectionException, ApiException {
		
		Address in = getAddressTestData_1();
		Address out = createAddress(in);
		logger.debug(out.toString());
		
		assertEquals(in.getFirstName(), out.getFirstName());
		assertEquals(in.getFullAddress(), out.getFullAddress());
		
	}
	
	
	public Address createAddress(Address a) throws ApiException, ConnectionException {
		
		Geocoder g = getGeocoderTestData();
		a.setGeocoderResource(g);
		
		Call<Address> call = service.createAddress(a);
		
		return apiClient.execute(call);

	}
	
	
	@Test
	public void updateAddressTest() throws ConnectionException, ApiException {
		
		Address in = getAddressTestData_2();
		Address out = updateAddress("4156", in);
		logger.debug(out.toString());
		
		assertEquals(in.getFirstName(), out.getFirstName());
		assertEquals(in.getFullAddress(), out.getFullAddress());
		
	}
	
	
	public Address updateAddress(String id, Address a) throws ApiException, ConnectionException {
		
		a.setId(id);
		
		Call<Address> call = service.updateAddress(id, a);
		
		return apiClient.execute(call);
		
	}
	
	
	@Test
	public void listAddressesTest() throws ConnectionException, ApiException {
		List<Address> addresses = listAddresses();
		logger.debug(LogUtils.toString(addresses));
	}
	
	
	public List<Address> listAddresses() throws ApiException, ConnectionException {
		
		Call<List<Address>> apiCall = service.listAddresses();
		
		return apiClient.execute(apiCall);

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
	
}
