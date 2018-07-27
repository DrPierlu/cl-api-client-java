package io.commercelayer.api.codegen.schema.parser;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenException;
import io.commercelayer.api.codegen.schema.ApiSchema;

public class SchemaParserExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(SchemaParserExecutor.class);
	
	
	public ApiSchema execute() throws CodegenException {
		
		logger.info("Schema Parsing started ...");
		
		SchemaParser schemaParser = SchemaParserFactory.get(SchemaParserDef.OpenAPI_V3);
		
		try {
			ApiSchema schema = schemaParser.parse(new URL(CodegenConfig.getProperty("schema.parser.url")));
			logger.info("Schema Parsing successfully terinated.");
			return schema;
		} catch (Exception e) {
			logger.error("Schema Parsing ended with errors.");
			throw new CodegenException(e);
		}
		
	}

}
