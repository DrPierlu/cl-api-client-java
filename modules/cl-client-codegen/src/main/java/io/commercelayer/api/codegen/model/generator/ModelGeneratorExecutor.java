package io.commercelayer.api.codegen.model.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenException;
import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.schema.ApiSchema;

public class ModelGeneratorExecutor {

	private static final Logger logger = LoggerFactory.getLogger(ModelGeneratorExecutor.class);
	
	
	public ApiModel execute(ApiSchema apiSchema) throws CodegenException {
		
		logger.info("Class Model Generation started ...");

		ModelGenerator modelGenerator = ModelGeneratorFactory.get(ModelGeneratorDef.Moshi_JsonApi);

		try {
			ApiModel model = modelGenerator.generateModel(apiSchema);
			logger.info("Class Model Generation successfully terinated.");
			return model;
		} catch (Exception e) {
			logger.error("Class Model Generation ended with errors.");
			throw new CodegenException(e);
		}

	}

}
