package io.commercelayer.api.codegen.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.CodegenException;

public class SourceWriterExecutor {
	
	private static final Logger logger = LoggerFactory.getLogger(SourceWriterExecutor.class);
	
	
	public void execute(ApiWriteable apiWriteable) throws CodegenException {
		
		logger.info("Source Writing started ...");
		
		SourceWriter sourceWriter = SourceWriterFactory.get();

		try {
			sourceWriter.write(apiWriteable, CodegenConfig.getProperty(Module.Source, "output.dir"));
			logger.info("Source Writing successfully terminated.");
		} catch (Exception e) {
			logger.error("Source Writing ended with errors.");
			throw new CodegenException(e);
		}
		
	}

}
