package io.commercelayer.api.codegen.source;

public interface SourceWriter {

	public void write(ApiWriteable apiWriteable, String destDir) throws SourceException;
	
}
