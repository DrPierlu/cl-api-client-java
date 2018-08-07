package io.commercelayer.api.codegen.service.generator;

import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.service.ApiService;

public interface ServiceGenerator {

	public ApiService generate(ApiSchema apiSchema) throws ServiceException;

}
