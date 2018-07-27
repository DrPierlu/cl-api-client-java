package io.commercelayer.api.codegen.schema.parser;

import io.commercelayer.api.codegen.schema.parser.impl.OpenAPIParserV3;

public class SchemaParserFactory {

	private SchemaParserFactory() {

	}

	public static SchemaParser get(SchemaParserDef schemaParser) throws SchemaException {

		if (SchemaParserDef.OpenAPI_V3.equals(schemaParser)) {
			return new OpenAPIParserV3();
		}

		throw new SchemaException(String.format("Specifica Schema API non valida o non supportata %s", schemaParser.specInfo()));

	}

}
