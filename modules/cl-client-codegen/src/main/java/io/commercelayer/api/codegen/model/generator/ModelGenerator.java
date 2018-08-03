package io.commercelayer.api.codegen.model.generator;

import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.schema.ApiSchema;

public interface ModelGenerator {

	public ApiModel generate(ApiSchema apiSchema) throws ModelException;
	
}
