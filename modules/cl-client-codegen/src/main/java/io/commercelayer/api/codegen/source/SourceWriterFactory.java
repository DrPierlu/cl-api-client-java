package io.commercelayer.api.codegen.source;

import io.commercelayer.api.codegen.source.impl.JPoetSourceWriter;

public class SourceWriterFactory {

	private SourceWriterFactory() {

	}

	public static SourceWriter get() throws SourceException {
		return new JPoetSourceWriter();
	}

}
