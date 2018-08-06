package io.commercelayer.api.codegen.source;

import io.commercelayer.api.codegen.model.ApiModel;

public interface SourceWriter {

	public void write(ApiModel apiModel, String destDir) throws SourceException;
	
}
