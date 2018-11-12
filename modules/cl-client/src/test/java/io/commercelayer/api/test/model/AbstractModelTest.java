package io.commercelayer.api.test.model;

import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.ApiCaller;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.test.TestData;

public abstract class AbstractModelTest<SERVICE> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected static ApiCaller apiCaller;
	
	protected SERVICE service;
	
	
	@BeforeClass
	public static void initServiceClient() {
		ApiToken token = new AuthenticationTest().authenticate();
		apiCaller = new ApiCaller(TestData.getOrganization(), token);
	}
	
	protected void initServiceInterface(Class<SERVICE> serviceInterface) {
		service = apiCaller.getServiceCallFactory(serviceInterface);
	}

	@Before
	protected abstract void initServiceInterface();
	
}
