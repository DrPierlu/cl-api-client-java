package io.commercelayer.api.codegen.model.generator.impl;

import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.commercelayer.api.codegen.model.ApiModel;
import io.commercelayer.api.codegen.model.Constructor;
import io.commercelayer.api.codegen.model.Field;
import io.commercelayer.api.codegen.model.Method;
import io.commercelayer.api.codegen.model.ModelClass;
import io.commercelayer.api.codegen.model.Type;
import io.commercelayer.api.codegen.model.generator.Annotation;
import io.commercelayer.api.codegen.model.generator.ModelException;
import io.commercelayer.api.codegen.model.generator.ModelGenerator;
import io.commercelayer.api.codegen.schema.ApiAttribute;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.codegen.schema.ApiRequestBody;
import io.commercelayer.api.codegen.schema.ApiSchema;
import io.commercelayer.api.codegen.schema.parser.SchemaUtil;
import io.commercelayer.api.domain.OperationType;
import io.commercelayer.api.util.ModelUtils;

public class JACModelGenerator implements ModelGenerator {
	
	private static final Logger logger = LoggerFactory.getLogger(JACModelGenerator.class);
	
	private static final String PACKAGE_SRC_GEN = "io.commercelayer.api.model"; // ApiResource.class.getPackage().getName();
	

	public ApiModel generateModel(ApiSchema apiSchema) throws ModelException {
		
		try {
			
			logger.info("Generating Class Model ...");
			
			ApiModel model = new ApiModel();
			
			for (ApiPath path : apiSchema.getPaths()) {
				
				String pkg = PACKAGE_SRC_GEN;
				String resName = SchemaUtil.getResourceName(path);
				
				ModelClass mc = model.getModelClass(pkg, resName);
				if (mc == null) {
					
					model.addClass(mc = new ModelClass(pkg, resName, Modifier.PUBLIC));
					
					mc.setComment(mc.getName());
					
					Annotation a = new Annotation(com.github.jasminb.jsonapi.annotations.Type.class);
					mc.addAnnotation(a);
					
//					mc.setExtendedClass(ApiResource.class);

					mc.addConstructor(new Constructor(mc.getName(), Modifier.PUBLIC));
					mc.addConstructor(new Constructor(mc.getName(), Modifier.PUBLIC, new Constructor.Param(Long.class, "id", true)));
					
					createMethodEquals(mc);
					createMethodHashCode(mc);
					createMethodClone(mc);
					
				}
				
				
				
				for (Map.Entry<OperationType, ApiOperation> oe : path.getOperations().entrySet()) {
					
					ApiOperation op = oe.getValue();
					ApiRequestBody rb = op.getRequestBody();
					
					if (rb != null) {
						
						List<ApiAttribute> attributes = rb.getAttributes();
						
						for (ApiAttribute attribute : attributes) {
							String fieldName =  ModelUtils.toCamelCase(attribute.getName());
							Field f = mc.getField(fieldName);
							if (f == null) {
								f = new Field(Modifier.PRIVATE, decodePropertyType(attribute),fieldName);
								mc.addField(f);
							}
							f.setRequiredFor(op.getType(), attribute.isRequired());
							f.setIncludedIn(op.getType(), Boolean.TRUE);
						}
						
					}
					
				}
				
			}
			
			logger.info("Successfully terminated.");
			
			return model;
			
		}
		catch (Exception e) {
			throw new ModelException("Error generating Class Model", e);
		}
		
	}
	
	
	private Type decodePropertyType(ApiAttribute p) {

		Class<?> type = null;
		Class<?> typeGen = null;
		
		switch (p.getType()) {
			case ApiAttribute.Types.STRING: {
				type = String.class;
				if (p.getFormat() != null) {
					switch (p.getFormat()) {
						case ApiAttribute.Formats.DATE_TIME: {
							type = LocalDateTime.class;
							break;
						}
						default:
							type = String.class;
					}
				}
				break;
			}
			case ApiAttribute.Types.INTEGER: {
				type = Integer.class;
				if (p.getFormat() != null) {
					switch (p.getFormat()) {
						case ApiAttribute.Formats.INT32: {
							type = Integer.class;
							break;
						}
						default:
							type = Integer.class;
					}
				}
				break;
			}
			case ApiAttribute.Types.NUMBER: {
				type = Integer.class;
				if (p.getFormat() != null) {
					switch (p.getFormat()) {
						case ApiAttribute.Formats.FLOAT: {
							type = Float.class;
							break;
						}
						default:
							type = Integer.class;
					}
				}
				break;
			}
			case ApiAttribute.Types.BOOLEAN: {
				type = Boolean.class;
				break;
			}
			/*
			case ApiField.Types.ARRAY: {
				type = List.class;
				if (p.getItemType() != null) switch (p.getItemType()) {
					case ApiField.Types.STRING: {
						typeGen = String.class;
						break;
					}
					case ApiField.Types.INTEGER: {
						typeGen = Integer.class;
						break;
					}
					case ApiField.Types.NUMBER: {
						typeGen = Integer.class;
						break;
					}
					case ApiField.Types.OBJECT:
					default:
						typeGen = Object.class;
				}
				break;
			}
			*/
			case ApiAttribute.Types.OBJECT:
			default:
				type = Object.class;
		}

		return new Type(type, typeGen);

	}
	
	
	private void createMethodEquals(final ModelClass mc) {

		Method m = new Method(Modifier.PUBLIC);

		m.addAnnotation(Override.class);

		m.setName("equals");
		m.setReturnType(boolean.class);
		m.addSignatureParam(new Method.Param(Object.class, "o"));
		mc.addImportItem(Objects.class);

		// Method Body
		m.addBodyLine(m.emptyLine());

		m.addBodyLine("if (this == o) return true;");
		m.addBodyLine("if ((o == null) || (getClass() != o.getClass())) return false;");
		m.addBodyLine(m.emptyLine());
		m.addBodyLine("%1$s x = (%1$s)o;", mc.getName());
		m.addBodyLine(m.emptyLine());
		m.addBodyLine("return super.equals(o)");

		for (Field f : mc.getFieldList()) {
			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) m.addBodyLine("\t&& Objects.equals(this.%1$s, x.%1$s)", f.getName());
		}

		m.addBodyLine(";");
		m.addBodyLine(m.emptyLine());

		mc.addMethod(m);

	}


	private void createMethodHashCode(ModelClass mc) {

		Method m = new Method(Modifier.PUBLIC);

		m.addAnnotation(Override.class);

		m.setName("hashCode");
		m.setReturnType(int.class);
		mc.addImportItem(Objects.class);

		// Method Body
		m.addBodyLine(m.emptyLine());

		m.addBodyLine("return Objects.hash(");

		List<String> fieldList = new ArrayList<>();
		if ((mc.getExtendedClass() != null) && (mc.getExtendedClass().getTypeClass() != null)) for (java.lang.reflect.Field f : mc.getExtendedClass().getTypeClass().getDeclaredFields())
			if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) fieldList.add(f.getName());
		for (Field f : mc.getFieldList())
			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) fieldList.add(f.getName());

		int i = 0;
		StringBuilder sb = new StringBuilder("\t");
		for (String f : fieldList) {
			sb.append(f);
			if (++i != fieldList.size()) sb.append(",");
			if ((i % 5) == 0) {
				m.addBodyLine(sb.toString());
				sb = new StringBuilder("\t");
			}
			else
				sb.append(' ');
		}
		m.addBodyLine(sb.toString());

		m.addBodyLine(");");

		m.addBodyLine(m.emptyLine());

		mc.addMethod(m);

	}


	private void createMethodClone(ModelClass mc) {

		Method m = new Method(Modifier.PUBLIC);

		m.addAnnotation(Override.class);

		m.setName("clone");
		m.setReturnType(new Type(mc.getName()));

		// Method Body
		m.addBodyLine(m.emptyLine());
		m.addBodyLine("%1$s no = new %1$s();", mc.getName());
		m.addBodyLine(m.emptyLine());

		m.addBodyLine("no = super.clone(no);");
		m.addBodyLine(m.emptyLine());

		List<String> fieldList = new ArrayList<>();
		if ((mc.getExtendedClass() != null) && (mc.getExtendedClass().getTypeClass() != null)) for (java.lang.reflect.Field f : mc.getExtendedClass().getTypeClass().getDeclaredFields())
			if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) fieldList.add(f.getName());
		for (Field f : mc.getFieldList())
			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) fieldList.add(f.getName());

		for (String f : fieldList) {
			m.addBodyLine("no.%1$s = this.%1$s;", f);
		}

		m.addBodyLine(m.emptyLine());
		m.addBodyLine("return no;");
		m.addBodyLine(m.emptyLine());

		mc.addMethod(m);

	}

}
