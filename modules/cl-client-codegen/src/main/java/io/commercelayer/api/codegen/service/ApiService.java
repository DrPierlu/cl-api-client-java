package io.commercelayer.api.codegen.service;

import java.util.LinkedList;
import java.util.List;

import com.squareup.javapoet.TypeSpec;

import io.commercelayer.api.codegen.source.ApiWriteable;

public class ApiService implements ApiWriteable {

	private String rootPackage;
	private List<TypeSpec> classes = new LinkedList<>();

	public ApiService(String rootPackage) {
		this.rootPackage = rootPackage;
	}
	
	public List<TypeSpec> getClasses() {
		return classes;
	}

	public void setClasses(List<TypeSpec> classes) {
		this.classes = classes;
	}

	public void addClass(TypeSpec class_) {
		this.classes.add(class_);
	}

	public String getRootPackage() {
		return rootPackage;
	}
	
}
