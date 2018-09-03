package io.commercelayer.api.codegen.schema.parser;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;

import io.commercelayer.api.codegen.schema.ApiAttribute;
import io.commercelayer.api.codegen.schema.ApiOperation;
import io.commercelayer.api.codegen.schema.ApiPath;
import io.commercelayer.api.domain.OperationType;

public class SchemaParserUtils {

	private SchemaParserUtils() {
		
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
	
	public static Type decodeAttributeType(ApiAttribute p) {

		Class<?> type = null;
		
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
						case ApiAttribute.Formats.INT64: {
							type = Long.class;
							break;
						}
						default:
							type = Integer.class;
					}
				}
				break;
			}
			case ApiAttribute.Types.NUMBER: {
				type = Float.class;
				if (p.getFormat() != null) {
					switch (p.getFormat()) {
						case ApiAttribute.Formats.FLOAT: {
							type = Float.class;
							break;
						}
						case ApiAttribute.Formats.DOUBLE: {
							type = Double.class;
							break;
						}
						default:
							type = Float.class;
					}
				}
				break;
			}
			case ApiAttribute.Types.BOOLEAN: {
				type = Boolean.class;
				break;
			}
			case ApiAttribute.Types.OBJECT:
			default:
				type = Object.class;
		}

		return type;

	}
	
}
