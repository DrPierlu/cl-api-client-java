package io.commercelayer.api.codegen.schema.parser;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.CodegenException;
import io.commercelayer.api.codegen.schema.ApiSchema;

public class SchemaParserExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(SchemaParserExecutor.class);
	
	private SchemaParserDef def;
	
	public SchemaParserExecutor() {
		this(SchemaParserDef.OpenAPI_V3);
	}
	
	public SchemaParserExecutor(SchemaParserDef def) {
		this.def = def;
		logger.info(String.format("SchemaParser implementation: %s", def.id()));
	}
	
	public ApiSchema execute() throws CodegenException {
		
		logger.info("Schema Parsing started ...");
		
		SchemaParser schemaParser = SchemaParserFactory.get(this.def);
		
		try {
			ApiSchema schema = schemaParser.parse(new URL(CodegenConfig.getProperty(Module.Schema, "parser.url")));
			logger.info("Schema Parsing successfully terminated.");
			return schema;
		} catch (Exception e) {
			logger.error("Schema Parsing ended with errors.");
			throw new CodegenException(e);
		}
		
	}

}
