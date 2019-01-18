package io.commercelayer.api.test.model;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.auth.ApiToken;
import io.commercelayer.api.client.common.AbstractServiceClient;
import io.commercelayer.api.client.exception.AuthException;
import io.commercelayer.api.model.common.ApiOrganization;
import io.commercelayer.api.test.AuthenticationTest;
import io.commercelayer.api.test.TestData;
import io.commercelayer.api.util.LogUtils;

public abstract class AbstractModelTest<MODEL> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	protected <SC extends AbstractServiceClient<?>> SC initServiceClient(Class<SC> clientClass) {
		
		SC client = null;
		
		try {
				
			ApiToken token = new AuthenticationTest().authenticate();
			ApiOrganization organization = TestData.getOrganization();
			
			Constructor<SC> cstr = clientClass.getConstructor(ApiOrganization.class, ApiToken.class);
			client = clientClass.cast(cstr.newInstance(organization, token));
			
			return client;
			
		}
		catch (AuthException | ReflectiveOperationException e) {
			logger.error(LogUtils.printStackTrace(e));
			client = null;
		}
		
		return client;
				
	}

}
