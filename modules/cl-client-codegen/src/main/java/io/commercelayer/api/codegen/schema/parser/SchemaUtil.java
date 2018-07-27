package io.commercelayer.api.codegen.schema.parser;

import org.apache.commons.lang3.StringUtils;

import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.domain.OperationType;

public class SchemaUtil {

	private SchemaUtil() {
		
	}
	
	public static String getResourceName(ApiPath path) {
		
		String resName = null;
		
		ApiOperation op = path.getOperations().get(OperationType.PATCH);
		if (op != null) {
			if ((op.getParameters() != null) && !op.getParameters().isEmpty()) {
				resName = op.getParameters().get(0).getName();
				if (resName.endsWith("Id")) resName = resName.substring(0, resName.lastIndexOf("Id"));
				resName = StringUtils.capitalize(resName);
			}
		}
		
		return resName;
		
	}
	
}
