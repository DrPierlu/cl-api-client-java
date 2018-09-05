package io.commercelayer.api.codegen.schema.parser;

import java.net.URL;

import io.commercelayer.api.codegen.schema.ApiSchema;

public interface SchemaParser {

	public ApiSchema parse(URL schemaUrl) throws SchemaException;
	
}
