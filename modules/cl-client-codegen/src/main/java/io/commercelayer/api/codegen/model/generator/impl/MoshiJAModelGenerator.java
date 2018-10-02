package io.commercelayer.api.codegen.model.generator.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.moshi.Json;

import io.commercelayer.api.codegen.CodegenConfig;
import io.commercelayer.api.codegen.CodegenConfig.Module;
import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.model.generator.ModelException;
import io.commercelayer.api.codegen.model.generator.ModelGenerator;
import io.commercelayer.api.codegen.model.generator.ModelGeneratorUtils;
import io.commercelayer.api.codegen.schema.ApiAttribute;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiRelationship;
import io.commercelayer.api.codegen.schema.ApiRelationship.Cardinality;
import io.commercelayer.api.codegen.schema.ApiResponse;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaParserUtils;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import io.commercelayer.api.util.CLInflector;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

public class MoshiJAModelGenerator implements ModelGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(MoshiJAModelGenerator.class);

	
	@Override
	public ApiModel generate(ApiSchema apiSchema) throws ModelException {
		
		ApiModel apiModel = new ApiModel(ModelGeneratorUtils.MODEL_BASE_PACKAGE);
		
		List<String> mainPaths = ModelGeneratorUtils.getMainResourcePaths(apiSchema);
		
		logger.info("Analizing main paths ...");
		for (String mainRes : mainPaths) {
			
			String resName = null;
			Map<String, ApiAttribute> attributes = new LinkedHashMap<>();
			Map<String, Cardinality> relationships = new LinkedHashMap<>();
			
			for (ApiPath path : apiSchema.getPaths()) {

				final String res = path.getResource();
				
				if (res.startsWith(mainRes)) {
					
					List<ApiOperation> ops = new ArrayList<>();
					
					if (res.equals(mainRes)) {
						ops.add(path.getOperations().get(OperationType.POST));
					}
					else
					if (res.endsWith("Id}")) {
						ops.add(path.getOperations().get(OperationType.PATCH));
						ops.add(path.getOperations().get(OperationType.GET));
						resName = ops.get(0).getParameters().get(0).getName();
						resName = resName.substring(0, resName.lastIndexOf("Id"));
						resName = StringUtils.capitalize(resName);
						logger.info("----- ----- ----- -----");
						logger.info("Identified Resource: {}", resName);
					}
					
					
					for (ApiOperation op : ops) {
					
						if (op.getRequestBody() != null) {
							// Request Fields
							for (ApiAttribute attr : op.getRequestBody().getAttributes()) {
								if (ArrayUtils.contains(ModelGeneratorUtils.MODEL_IGNORED_FIELDS, attr.getName())) continue;
								if (!attributes.containsKey(attr.getName())) attributes.put(attr.getName(), attr);
							}
							// Request Relationships
							for (ApiRelationship rel : op.getRequestBody().getRelationships()) {
								if (!relationships.containsKey(rel.getResourceName())) relationships.put(rel.getResourceName(), rel.getCardinality());
							}
						}
						
						// Response Fields
						for (Map.Entry<String, ApiResponse> r : op.getResponses().entrySet()) {
							for (ApiAttribute attr : r.getValue().getAttributes()) {
								if (ArrayUtils.contains(ModelGeneratorUtils.MODEL_IGNORED_FIELDS, attr.getName())) continue;
								if (!attributes.containsKey(attr.getName())) attributes.put(attr.getName(), attr);
							}
						}
						// Response Relationships
						for (Map.Entry<String, ApiResponse> r : op.getResponses().entrySet()) {
							for (ApiRelationship rel : r.getValue().getRelationships())
								if (!relationships.containsKey(rel.getResourceName())) relationships.put(rel.getResourceName(), rel.getCardinality());
						}
						
					}
					
				}
				
			}
			
			logger.info("Creating {} Model Class", resName);
			AnnotationSpec jsonApiAnnot = AnnotationSpec.builder(JsonApi.class)
				.addMember("type", "$S", mainRes.substring(1))
				.build();
			
			TypeSpec.Builder classe = TypeSpec.classBuilder(resName)
				.addModifiers(Modifier.PUBLIC)
				.superclass(ApiResource.class)
				.addAnnotation(jsonApiAnnot)
			;
			
			FieldSpec serialVer = FieldSpec.builder(long.class, "serialVersionUID", Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
				.initializer("$L", CodegenConfig.getProperty(Module.Model, "object.serialVersionUID"))
				.build();
			classe.addField(serialVer);
			
			// Fields
			generateFields(classe, attributes);
			logger.info("{} fields generated", resName);
			
			// Relationships
			generateRelationships(classe, relationships);
			logger.info("{} relationships generated", resName);
			
			
			TypeSpec modelClass = classe.build();
			logger.info("{} Model Class created.", resName);
			
			
			apiModel.addClass(modelClass);
			
		}
		
		
		return apiModel;
		
	}
	
	
	private void setJsonFieldAnnotation(String fieldName, FieldSpec.Builder fieldBuilder) {
		if (fieldName.contains("_")) {
			AnnotationSpec jsonAnnot = AnnotationSpec.builder(Json.class)
				.addMember("name", "$S", fieldName)
				.build();
			fieldBuilder.addAnnotation(jsonAnnot);
		}
	}
	
	private void addResourceField(TypeSpec.Builder classe, FieldSpec field) {
		classe.addField(field);
		classe.addMethod(ModelGeneratorUtils.createMethodGetter(field));
		classe.addMethod(ModelGeneratorUtils.createMethodSetter(field));
	}
	
	
	private void generateRelationships(TypeSpec.Builder classe, Map<String, Cardinality> relationships) {
		
		for (Map.Entry<String, Cardinality> rel : relationships.entrySet()) {
			
			boolean multiRel = Cardinality.HAS_MANY.equals(rel.getValue());
			
			// Relationship field
			final String relFieldName = ModelGeneratorUtils.toCamelCase(rel.getKey());
			final String relFieldNameCap = StringUtils.capitalize(relFieldName);
			
			final String relResName = CLInflector.getInstance().singularize(relFieldNameCap);
			final String relResNameRemapped = CodegenConfig.mapModelResource(relResName);
			final TypeName relResType = ClassName.get(ModelGeneratorUtils.MODEL_BASE_PACKAGE, relResNameRemapped);
			
			final ClassName relClassName = ClassName.get(multiRel? HasMany.class : HasOne.class);
			final TypeName relTypeName = ParameterizedTypeName.get(relClassName, relResType);
			final TypeName relResTypeName = multiRel? ParameterizedTypeName.get(ClassName.get(List.class), relResType) : relResType;
			
			FieldSpec.Builder field = FieldSpec.builder(relTypeName, relFieldName, Modifier.PRIVATE);
			setJsonFieldAnnotation(rel.getKey(), field);
			addResourceField(classe, field.build());
			
			// Relationship get Resource/ResourceList method
			final String relResGetMethodName = String.format("get%sResource%s", relResName, multiRel? "List" : "");
			MethodSpec relResGetMethod = MethodSpec.methodBuilder(relResGetMethodName)
				.addModifiers(Modifier.PUBLIC)
				.returns(relResTypeName)
				.addStatement("return get$L().get(getDocument())", relFieldNameCap)
				.build();
			classe.addMethod(relResGetMethod);
			
			final String relResSetMethodName = String.format("set%sResource%s", relResName, multiRel? "List" : "");
			MethodSpec relResSetMethod = MethodSpec.methodBuilder(relResSetMethodName)
				.addModifiers(Modifier.PUBLIC)
				.addParameter(relResTypeName, relFieldName)
				.addStatement("set$L(new $T<$L>($L$L))", relFieldNameCap, relClassName, relResNameRemapped, relFieldName, multiRel? String.format(".toArray(new %s[0])", relResNameRemapped) : "")
				.build();
			classe.addMethod(relResSetMethod);
			
			// Relationship get Links method
			final String relResLinksMethodName = String.format("get%sLinksMap", relFieldNameCap);
			TypeName linksType = ParameterizedTypeName.get(Map.class, String.class, String.class);
			MethodSpec relResLinksMethod = MethodSpec.methodBuilder(relResLinksMethodName)
				.addModifiers(Modifier.PUBLIC)
				.returns(linksType)
				.addStatement("return ($T)get$L().getLinks().get(new $T())", linksType, relFieldNameCap, CLLinksAdapter.class)
				.addAnnotation(AnnotationSpec.builder(SuppressWarnings.class)
					.addMember("value", "$S", "unchecked")
					.build())
				.build();
			classe.addMethod(relResLinksMethod);
			
		}
		
	}
	
	
	private void generateFields(TypeSpec.Builder classe, Map<String, ApiAttribute> attributes) {
		for (ApiAttribute attr : attributes.values()) {
			FieldSpec.Builder field = FieldSpec.builder(SchemaParserUtils.decodeAttributeType(attr), ModelGeneratorUtils.toCamelCase(attr.getName()), Modifier.PRIVATE);
			setJsonFieldAnnotation(attr.getName(), field);
			addResourceField(classe, field.build());
		}
	}

}
