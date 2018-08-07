package io.commercelayer.api.codegen.service.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenException;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.service.ApiService;

public class ServiceGeneratorExecutor {

	private static final Logger logger = LoggerFactory.getLogger(ServiceGeneratorExecutor.class);
	
	
	public ApiService execute(ApiSchema apiSchema) throws CodegenException {
		
		logger.info("Service Interface Generation started ...");

		ServiceGenerator serviceGenerator = ServiceGeneratorFactory.get(ServiceGeneratorDef.Retrofit);

		try {
			ApiService service = serviceGenerator.generate(apiSchema);
			logger.info("Service Interface Generation successfully terminated.");
			return service;
		} catch (Exception e) {
			logger.error("Service Interface Generation ended with errors.");
			throw new CodegenException(e);
		}

	}

}
