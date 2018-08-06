package io.commercelayer.api.codegen.model.generator;


import javax.lang.model.element.Modifier;

import org.apache.commons.lang3.StringUtils;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

public class ModelGeneratorUtils {
	
	public static final String MODEL_BASE_PACKAGE = "io.commercelayer.api.model";
	public static final String[] IGNORED_FIELDS = {
		"reference",
		"metadata",
		"created_at",
		"updated_at",
		"id"
	};

	private ModelGeneratorUtils() {
		
	}
	
	
//	public static void createMethodEquals(final ModelClass mc) {
//
//		Method m = new Method(Modifier.PUBLIC);
//
//		m.addAnnotation(Override.class);
//
//		m.setName("equals");
//		m.setReturnType(boolean.class);
//		m.addSignatureParam(new Method.Param(Object.class, "o"));
//		mc.addImportItem(Objects.class);
//
//		// Method Body
//		m.addBodyLine(m.emptyLine());
//
//		m.addBodyLine("if (this == o) return true;");
//		m.addBodyLine("if ((o == null) || (getClass() != o.getClass())) return false;");
//		m.addBodyLine(m.emptyLine());
//		m.addBodyLine("%1$s x = (%1$s)o;", mc.getName());
//		m.addBodyLine(m.emptyLine());
//		m.addBodyLine("return super.equals(o)");
//
//		for (Field f : mc.getFieldList()) {
//			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) m.addBodyLine("\t&& Objects.equals(this.%1$s, x.%1$s)", f.getName());
//		}
//
//		m.addBodyLine(";");
//		m.addBodyLine(m.emptyLine());
//
//		mc.addMethod(m);
//
//	}
//
//
//	public static void createMethodHashCode(ModelClass mc) {
//
//		Method m = new Method(Modifier.PUBLIC);
//
//		m.addAnnotation(Override.class);
//
//		m.setName("hashCode");
//		m.setReturnType(int.class);
//		mc.addImportItem(Objects.class);
//
//		// Method Body
//		m.addBodyLine(m.emptyLine());
//
//		m.addBodyLine("return Objects.hash(");
//
//		List<String> fieldList = new ArrayList<>();
//		if ((mc.getExtendedClass() != null) && (mc.getExtendedClass().getTypeClass() != null)) for (java.lang.reflect.Field f : mc.getExtendedClass().getTypeClass().getDeclaredFields())
//			if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) fieldList.add(f.getName());
//		for (Field f : mc.getFieldList())
//			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) fieldList.add(f.getName());
//
//		int i = 0;
//		StringBuilder sb = new StringBuilder("\t");
//		for (String f : fieldList) {
//			sb.append(f);
//			if (++i != fieldList.size()) sb.append(",");
//			if ((i % 5) == 0) {
//				m.addBodyLine(sb.toString());
//				sb = new StringBuilder("\t");
//			}
//			else
//				sb.append(' ');
//		}
//		m.addBodyLine(sb.toString());
//
//		m.addBodyLine(");");
//
//		m.addBodyLine(m.emptyLine());
//
//		mc.addMethod(m);
//
//	}
//
//
//	public static void createMethodClone(ModelClass mc) {
//
//		Method m = new Method(Modifier.PUBLIC);
//
//		m.addAnnotation(Override.class);
//
//		m.setName("clone");
//		m.setReturnType(new Type(mc.getName()));
//
//		// Method Body
//		m.addBodyLine(m.emptyLine());
//		m.addBodyLine("%1$s no = new %1$s();", mc.getName());
//		m.addBodyLine(m.emptyLine());
//
//		m.addBodyLine("no = super.clone(no);");
//		m.addBodyLine(m.emptyLine());
//
//		List<String> fieldList = new ArrayList<>();
//		if ((mc.getExtendedClass() != null) && (mc.getExtendedClass().getTypeClass() != null)) for (java.lang.reflect.Field f : mc.getExtendedClass().getTypeClass().getDeclaredFields())
//			if (Modifier.isPrivate(f.getModifiers()) && !Modifier.isStatic(f.getModifiers())) fieldList.add(f.getName());
//		for (Field f : mc.getFieldList())
//			if (Modifier.isPrivate(f.getModifier()) && !Modifier.isStatic(f.getModifier())) fieldList.add(f.getName());
//
//		for (String f : fieldList) {
//			m.addBodyLine("no.%1$s = this.%1$s;", f);
//		}
//
//		m.addBodyLine(m.emptyLine());
//		m.addBodyLine("return no;");
//		m.addBodyLine(m.emptyLine());
//
//		mc.addMethod(m);
//
//	}
	
	
	public static MethodSpec createMethodSetter(FieldSpec field) {
		
		boolean _start = field.name.startsWith("_");
				
		String methodName = "set".concat(StringUtils.capitalize(field.name.replaceFirst("_", "")));
		if (_start) methodName = methodName.concat("_");
		
		MethodSpec method = MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.addParameter(field.type, field.name)
			.addStatement("this.$N = $L", field, field.name)
			.build();
		
		return method;
		
	}
	
	
	public static MethodSpec createMethodGetter(FieldSpec field) {
		
		boolean _start = field.name.startsWith("_");
		
		String methodName = "get".concat(StringUtils.capitalize(field.name.replaceFirst("_", "")));
		if (_start) methodName = methodName.concat("_");
		
		MethodSpec method = MethodSpec.methodBuilder(methodName)
			.addModifiers(Modifier.PUBLIC)
			.returns(field.type)
			.addStatement("return this.$N", field)
			.build();
		
		return method;
		
	}
	
}
