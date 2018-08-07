package io.commercelayer.api.codegen.service.generator;

import io.commercelayer.api.codegen.service.generator.impl.RetrofitServiceGenerator;

public class ServiceGeneratorFactory {

	private ServiceGeneratorFactory() {

	}

	public static ServiceGenerator get(ServiceGeneratorDef sgd) throws ServiceException {

		switch (sgd) {
			case Retrofit:	return new RetrofitServiceGenerator();
			default: throw new ServiceException(String.format("Unsupported Api Service Generator [%s]", sgd.id()));
		}

	}
	
}
