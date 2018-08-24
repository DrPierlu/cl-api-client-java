package io.commercelayer.api.codegen.source;

import io.commercelayer.api.codegen.source.impl.JPoetSourceWriter;

public class SourceWriterFactory {

	private SourceWriterFactory() {

	}

	public static SourceWriter get(SourceWriterDef swd) throws SourceException {
		
		switch (swd) {
			case JPoet:	return new JPoetSourceWriter();
			default: throw new SourceException(String.format("Unsupported Source Writer [%s]", swd.id()));
		}
		
	}

}
