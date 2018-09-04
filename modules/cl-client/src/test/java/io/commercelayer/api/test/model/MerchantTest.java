package io.commercelayer.api.test.model;

import org.junit.BeforeClass;
import org.junit.Test;

import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Merchant;
import io.commercelayer.api.service.MerchantService;
import retrofit2.Call;

public class MerchantTest extends AbstractModelTest {
	
	private MerchantService service;
	
	@BeforeClass
	private void initServiceInterface() {
		service = apiCaller.getRawClient(MerchantService.class);
	}
	

	@Test
	public void createMerchantTest() throws ConnectionException, ApiException {
		Merchant merchant = createMerchant(getMerchantTestData_1());
		logger.debug(merchant.toString());
	}
	
	public Merchant createMerchant(Merchant m) throws ApiException, ConnectionException {
		Call<Merchant> call = service.createMerchant(m);
		return apiCaller.execute(call);
	}
	
	public static Merchant getMerchantTestData_1() {
		
		Merchant m = new Merchant();
		
		m.setName("MarioRossiStudio Srl");
		
		return m;
		
	}
	
	
	public static void main(String[] args) throws ConnectionException, ApiException {
		initServiceClient();
		MerchantTest test = new MerchantTest();
		test.initServiceInterface();
		test.createMerchantTest();
	}

}
