package io.commercelayer.api.codegen.model.generator.impl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.moshi.Json;

import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.model.generator.ModelException;
import io.commercelayer.api.codegen.model.generator.ModelGenerator;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorUtils;
import io.commercelayer.api.codegen.schema.ApiAttribute;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiRelationship;
import io.commercelayer.api.codegen.schema.ApiRelationship.Cardinality;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaParserUtils;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import io.commercelayer.api.util.Inflector;
import io.commercelayer.api.util.ModelUtils;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

public class MoshiJAModelGenerator implements ModelGenerator {
	
	public static final String MODEL_BASE_PACKAGE = "io.commercelayer.api.model";

	@Override
	public ApiModel generateModel(ApiSchema apiSchema) throws ModelException {
		
		ApiModel apiModel = new ApiModel();
		
		List<String> mainPaths = new LinkedList<>();
		for (ApiPath path : apiSchema.getPaths()) {
			String res = path.getResource();
			if (res.indexOf('/') == res.lastIndexOf('/')) {
				mainPaths.add(res);
				System.out.println(res);
			}
		}
		
		
		for (String mainRes : mainPaths) {
			
			String resName = null;
			Map<String, ApiAttribute> attributes = new LinkedHashMap<>();
			Map<String, Cardinality> relationships = new LinkedHashMap<>();
			
			for (ApiPath path : apiSchema.getPaths()) {

				final String res = path.getResource();
				
				if (res.startsWith(mainRes)) {
					
					ApiOperation op = null;
					
					if (res.equals(mainRes)) {
						op = path.getOperations().get(OperationType.POST);
					}
					else
					if (res.endsWith("Id}")) {
						op = path.getOperations().get(OperationType.PATCH);
						resName = op.getParameters().get(0).getName();
						resName = resName.substring(0, resName.lastIndexOf("Id"));
						resName = StringUtils.capitalize(resName);
					}
					
					if ((op == null) || (op.getRequestBody() == null)) continue;
					
					
					// Fields
					for (ApiAttribute attr : op.getRequestBody().getAttributes()) {
						if ("reference".equalsIgnoreCase(attr.getName())) continue;
						if ("metadata".equalsIgnoreCase(attr.getName())) continue;
						if (!attributes.containsKey(attr.getName())) attributes.put(attr.getName(), attr);
					}
					
					
					// Relationships
					for (ApiRelationship rel : op.getRequestBody().getRelationships()) {
						if (!relationships.containsKey(rel.getResourceName())) relationships.put(rel.getResourceName(), rel.getCardinality());
					}
					
				}
				
			}
			
			AnnotationSpec jsonApiAnnot = AnnotationSpec.builder(JsonApi.class)
				.addMember("type", "$S", mainRes.substring(1))
				.build();
			
			TypeSpec.Builder classe = TypeSpec.classBuilder(resName)
				.addModifiers(Modifier.PUBLIC)
				.superclass(ApiResource.class)
				.addAnnotation(jsonApiAnnot)
			;
			
			
			// Fields
			for (ApiAttribute attr : attributes.values()) {
				
				FieldSpec.Builder field = FieldSpec.builder(SchemaParserUtils.decodeAttributeType(attr), ModelUtils.toCamelCase(attr.getName()))
					.addModifiers(Modifier.PRIVATE);
				if (attr.getName().contains("_")) {
					AnnotationSpec jsonAnnot = AnnotationSpec.builder(Json.class)
						.addMember("name", "$S", attr.getName())
						.build();
					field.addAnnotation(jsonAnnot);
				}
				
				addResourceField(classe, field.build());
				
			}
			
			
			// Relationships
			for (Map.Entry<String, Cardinality> rel : relationships.entrySet()) {
				
				// Relationship field
				String relResName = StringUtils.capitalize(Inflector.getInstance().singularize(rel.getKey()));
				ClassName relResType = ClassName.get(MODEL_BASE_PACKAGE, relResName);
				
				ClassName cn = ClassName.get(Cardinality.HAS_ONE.equals(rel.getValue()) ? HasOne.class : HasMany.class);
				TypeName tn = ParameterizedTypeName.get(cn, relResType);
				
				FieldSpec field = FieldSpec.builder(tn, rel.getKey(), Modifier.PRIVATE).build();
				addResourceField(classe, field);
				
				// Relationship get Resource method
				MethodSpec relResMethod = MethodSpec.methodBuilder(String.format("get%sResource", relResName))
					.addModifiers(Modifier.PUBLIC)
					.returns(relResType)
					.addStatement("return get$T().get(getDocument())", relResType)
					.build();
				classe.addMethod(relResMethod);
				
				// Relationship get Links method
				TypeName linksType = ParameterizedTypeName.get(Map.class, String.class, String.class);
				MethodSpec relResLinks = MethodSpec.methodBuilder(String.format("get%sLinksMap", relResName))
					.addModifiers(Modifier.PUBLIC)
					.returns(linksType)
					.addStatement("return ($T)get$T().getLinks().get(new $T())", linksType, relResType, CLLinksAdapter.class)
					.addAnnotation(AnnotationSpec.builder(SuppressWarnings.class)
						.addMember("value", "$S", "unchecked")
						.build())
					.build();
				classe.addMethod(relResLinks);
				
//				@SuppressWarnings("unchecked")
				
			}
			
			
			TypeSpec modelClass = classe.build();
			
			JavaFile javaFile = JavaFile.builder(MODEL_BASE_PACKAGE, modelClass).build();

			try {
				javaFile.writeTo(Paths.get("E:/test/CL"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return apiModel;
		
	}
	
	
	private void addResourceField(TypeSpec.Builder classe, FieldSpec field) {
		classe.addField(field);
		classe.addMethod(ModelGeneratorUtils.createMethodGetter(field));
		classe.addMethod(ModelGeneratorUtils.createMethodSetter(field));
	}

}
