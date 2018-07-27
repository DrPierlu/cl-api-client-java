package io.commercelayer.api.codegen.model.generator;

import io.commercelayer.api.codegen.model.generator.impl.JACModelGenerator;

public class ModelGeneratorFactory {

	private ModelGeneratorFactory() {

	}

	public static ModelGenerator get(ModelGeneratorDef mgd) throws ModelException {

		if (ModelGeneratorDef.JsonApi_Converter.equals(mgd)) {
			return new JACModelGenerator();
		}

		throw new ModelException(String.format("Model Generator non valido o non supportato [%s]", mgd.id()));

	}

}
