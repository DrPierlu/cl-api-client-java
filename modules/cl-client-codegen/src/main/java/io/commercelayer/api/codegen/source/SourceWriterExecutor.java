package io.commercelayer.api.codegen.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenException;
import io.commercelayer.api.codegen.model.ApiModel;

public class SourceWriterExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(SourceWriterExecutor.class);
	
	
	public void execute(ApiModel apiModel) throws CodegenException {
		
		logger.info("Source Writing started ...");
		
		SourceWriter sourceWriter = SourceWriterFactory.get();
		
		try {
			sourceWriter.write(apiModel, "E:/test/CL");
			logger.info("Source Writing successfully terminated.");
		} catch (Exception e) {
			logger.error("Source Writing ended with errors.");
			throw new CodegenException(e);
		}
		
	}

}
