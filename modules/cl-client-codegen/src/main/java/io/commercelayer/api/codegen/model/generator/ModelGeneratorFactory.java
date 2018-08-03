package io.commercelayer.api.codegen.model.generator;

import io.commercelayer.api.codegen.model.generator.impl.MoshiJAModelGenerator;

public class ModelGeneratorFactory {

	private ModelGeneratorFactory() {

	}

	public static ModelGenerator get(ModelGeneratorDef mgd) throws ModelException {

		switch (mgd) {
			case Moshi_JsonApi:	return new MoshiJAModelGenerator();
			case JsonApi_Converter:
			default: throw new ModelException(String.format("Unsupported Api Model Generator [%s]", mgd.id()));
		}

	}

}
