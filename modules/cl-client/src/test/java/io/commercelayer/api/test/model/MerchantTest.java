package io.commercelayer.api.test.model;

import org.junit.Test;

import io.commercelayer.api.client.MerchantServiceClient;
import io.commercelayer.api.client.exception.ApiException;
import io.commercelayer.api.client.exception.ConnectionException;
import io.commercelayer.api.model.Merchant;

public class MerchantTest extends AbstractModelTest<Merchant> {
	
	private MerchantServiceClient serviceClient = initServiceClient(MerchantServiceClient.class);

	@Test
	public void createMerchantTest() throws ConnectionException, ApiException {
		Merchant merchant = createMerchant(getMerchantTestData_1());
		logger.debug(merchant.toString());
	}
	
	public Merchant createMerchant(Merchant m) throws ApiException, ConnectionException {
		Merchant merchant = serviceClient.createMerchant(m);
		return merchant;
	}
	
	public static Merchant getMerchantTestData_1() {
		
		Merchant m = new Merchant();
		
		m.setName("MarioRossiStudio Srl");
		
		return m;
		
	}

}
