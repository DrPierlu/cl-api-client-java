package io.commercelayer.api.codegen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorExecutor;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaParserExecutor;
import io.commercelayer.api.util.LogUtils;

public class ApiSourceCodeGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiSourceCodeGenerator.class);
	
	public static void main(String[] args) {
		
		logger.info("** CommerceLayer API Client - Source Code Generation **");
		logger.info("Source Code Generation started ...");
		
		try {
			
			logger.info("---------- ---------- ---------- ----------");
			ApiSchema apiSchema = new SchemaParserExecutor().execute();
			logger.info("---------- ---------- ---------- ----------");
			ApiModel apiModel = new ModelGeneratorExecutor().execute(apiSchema);
			logger.info("---------- ---------- ---------- ----------");
			
			logger.info("Source Code Generation successfully terminated.");
			
		} catch (CodegenException e) {
			logger.error(LogUtils.printStackTrace(e));
			logger.info("Source Code Generation ended with errors.");
		}
		
	}

}
