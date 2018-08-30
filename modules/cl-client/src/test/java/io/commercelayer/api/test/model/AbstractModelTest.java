package io.commercelayer.api.test.model;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.CLApiClient;
import io.commercelayer.api.test.TestData;

public abstract class AbstractModelTest {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected static CLApiClient apiClient;
	
	
	@BeforeClass
	public static void initServiceClient() {
		ApiToken token = null;//new AuthenticationTest().authenticate();
		apiClient = new CLApiClient(TestData.getOrganization(), token);
	}

}
