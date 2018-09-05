package io.commercelayer.api.codegen.schema.parser;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
	
	public static Type decodeAttributeType(ApiAttribute attribute) {
		Type type = AttributeTypeMapper.decode(attribute);
		return (type == null)? Object.class : type;
	}
	
	
	
	/**
	 * 
	 * ATTRIBUTE TYPE MAPPER
	 * 
	 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.1.md#dataTypes">OpenAPI Specification V3.0.1 Data Types</a>
	 *
	 * 	Common Name		type		format		Comments
	 *	integer			integer		int32		signed 32 bits
	 *	long			integer		int64		signed 64 bits
	 *	float			number		float	
	 *	double			number		double	
	 *	string			string		
	 *	byte			string		byte		base64 encoded characters
	 *	binary			string		binary		any sequence of octets
	 *	boolean			boolean		
	 *	date			string		date		As defined by full-date - RFC3339
	 *	dateTime		string		date-time	As defined by date-time - RFC3339
	 *	password		string		password	A hint to UIs to obscure input.
	 */
	private static final class AttributeTypeMapper {
		
		private static final HashMap<String, Map<String, Class<?>>> TYPE_MAP = new HashMap<>();
		
		private AttributeTypeMapper() {
			
		}
		
		static {
			
			Map<String, Class<?>> typeMap;
			
			// INTEGER
			typeMap = new HashMap<>();
			
			typeMap.put(StringUtils.EMPTY, Integer.class);
			typeMap.put(ApiAttribute.Formats.INT32, Integer.class);
			typeMap.put(ApiAttribute.Formats.INT64, Long.class);
			
			TYPE_MAP.put(ApiAttribute.Types.INTEGER, typeMap);
			
			
			// NUMBER
			typeMap = new HashMap<>();
			
			typeMap.put(StringUtils.EMPTY, Float.class);
			typeMap.put(ApiAttribute.Formats.FLOAT, Float.class);
			typeMap.put(ApiAttribute.Formats.DOUBLE, Double.class);
			
			TYPE_MAP.put(ApiAttribute.Types.NUMBER, typeMap);
			
			
			// STRING
			typeMap = new HashMap<>();
			
			typeMap.put(StringUtils.EMPTY, String.class);
			typeMap.put(ApiAttribute.Formats.PASSWORD, String.class);
			typeMap.put(ApiAttribute.Formats.BYTE, byte[].class);
			typeMap.put(ApiAttribute.Formats.BINARY, byte[].class);
			typeMap.put(ApiAttribute.Formats.DATE, LocalDate.class);
			typeMap.put(ApiAttribute.Formats.DATE_TIME, LocalDateTime.class);
			
			TYPE_MAP.put(ApiAttribute.Types.STRING, typeMap);
			
			
			// NUMBER
			typeMap = new HashMap<>();
			
			typeMap.put(StringUtils.EMPTY, Boolean.class);
			
			TYPE_MAP.put(ApiAttribute.Types.BOOLEAN, typeMap);
			
		}
		
		
		public static Class<?> decode(ApiAttribute attribute) {
			
			Class<?> type = null;
			
			if (attribute != null) {
				Map<String, Class<?>> typeMap = TYPE_MAP.get(attribute.getType());
				if ((typeMap != null) && !typeMap.isEmpty()) {
					String format = StringUtils.isEmpty(attribute.getFormat())? "" : attribute.getFormat();
					type = typeMap.get(format);
				}
			}
			
			return type;
			
		}
		
	}
	
}
