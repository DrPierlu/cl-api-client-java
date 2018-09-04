package io.commercelayer.api.codegen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorDef;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorExecutor;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaParserDef;
import io.commercelayer.api.codegen.schema.parser.SchemaParserExecutor;
import io.commercelayer.api.codegen.service.ApiService;
import io.commercelayer.api.codegen.service.generator.ServiceGeneratorDef;
import io.commercelayer.api.codegen.service.generator.ServiceGeneratorExecutor;
import io.commercelayer.api.codegen.source.SourceWriterDef;
import io.commercelayer.api.codegen.source.SourceWriterExecutor;
import io.commercelayer.api.util.LogUtils;

public class ApiSourceCodeGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiSourceCodeGenerator.class);
	
	public static void main(String[] args) {
		
		logger.info("** CommerceLayer API Client - Source Code Generation **");
		logger.info("Source Code Generation started ...");
		
		try {
			
			logger.info("---------- ---------- ---------- ----------");
			ApiSchema apiSchema = new SchemaParserExecutor(SchemaParserDef.OpenAPI_V3).execute();
			logger.info("---------- ---------- ---------- ----------");
			ApiModel apiModel = new ModelGeneratorExecutor(ModelGeneratorDef.Moshi_JsonApi).execute(apiSchema);
			logger.info("---------- ---------- ---------- ----------");
			new SourceWriterExecutor(SourceWriterDef.JPoet).execute(apiModel);
			logger.info("---------- ---------- ---------- ----------");
			ApiService apiServiceRes = new ServiceGeneratorExecutor(ServiceGeneratorDef.Retrofit_Resource).execute(apiSchema);
			logger.info("---------- ---------- ---------- ----------");
			new SourceWriterExecutor(SourceWriterDef.JPoet).execute(apiServiceRes);
			logger.info("---------- ---------- ---------- ----------");
//			ApiService apiServiceDoc = new ServiceGeneratorExecutor(ServiceGeneratorDef.Retrofit_Document).execute(apiSchema);
//			logger.info("---------- ---------- ---------- ----------");
//			new SourceWriterExecutor(SourceWriterDef.JPoet).execute(apiServiceDoc);
//			logger.info("---------- ---------- ---------- ----------");
			ApiService apiServiceDoc = new ServiceGeneratorExecutor(ServiceGeneratorDef.Retrofit_Resource_Client).execute(apiSchema);
			logger.info("---------- ---------- ---------- ----------");
			new SourceWriterExecutor(SourceWriterDef.JPoet).execute(apiServiceDoc);
			logger.info("---------- ---------- ---------- ----------");
			
			logger.info("Source Code Generation successfully terminated.");
			
		} catch (CodegenException e) {
			logger.error(LogUtils.printStackTrace(e));
			logger.info("Source Code Generation ended with errors.");
		}
		
	}

}
