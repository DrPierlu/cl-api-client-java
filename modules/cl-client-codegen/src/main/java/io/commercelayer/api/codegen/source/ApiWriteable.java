package io.commercelayer.api.codegen.source;

import java.util.List;

import com.squareup.javapoet.TypeSpec;

public interface ApiWriteable {

	
	public List<TypeSpec> getClasses();

	public String getRootPackage();
	
}
