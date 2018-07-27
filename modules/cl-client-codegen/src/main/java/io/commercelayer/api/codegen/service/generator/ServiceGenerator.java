package io.commercelayer.api.codegen.service.generator;

import io.commercelayer.api.codegen.service.ApiService;

public interface ServiceGenerator {

	public void generateService(ApiService apiService) throws ServiceException;

}
