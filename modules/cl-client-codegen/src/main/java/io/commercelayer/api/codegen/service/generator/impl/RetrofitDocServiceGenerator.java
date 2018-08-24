package io.commercelayer.api.codegen.service.generator.impl;

import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.service.generator.ServiceGenerator;
import io.commercelayer.api.codegen.service.generator.ServiceGeneratorUtils;
import io.commercelayer.api.domain.OperationType;
import moe.banana.jsonapi2.Document;
import retrofit2.Call;

public class RetrofitDocServiceGenerator extends RetrofitServiceGenerator implements ServiceGenerator {
	
	protected TypeName getOperationReturnType(String resource, ApiOperation operation) {
		if (OperationType.DELETE.equals(operation.getType())) return ParameterizedTypeName.get(Call.class, Void.class);
		else return ParameterizedTypeName.get(Call.class, Document.class);
	}
	
	protected String getServiceBasePackage() {
		return ServiceGeneratorUtils.SERVICE_BASE_PACKAGE.concat(".document");
	}

}
