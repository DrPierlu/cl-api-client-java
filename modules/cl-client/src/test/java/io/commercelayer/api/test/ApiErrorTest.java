package io.commercelayer.api.test;

import org.apache.commons.lang3.builder.MultilineRecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import io.commercelayer.api.model.common.error.ApiError;
import io.commercelayer.api.util.JSONUtils;

public class ApiErrorTest {
	
	private static final String json = "{\r\n" + 
			"      \"title\": \"must be less than or equal to 10\",\r\n" + 
			"      \"detail\": \"quantity - must be less than or equal to 10\",\r\n" + 
			"      \"code\": \"VALIDATION_ERROR\",\r\n" + 
			"      \"source\": {\r\n" + 
			"        \"pointer\": \"/data/attributes/quantity\"\r\n" + 
			"      },\r\n" + 
			"      \"status\":\"422\",\r\n" + 
			"      \"meta\": {\r\n" + 
			"        \"error\": \"less_than_or_equal_to\",\r\n" + 
			"        \"count\": 10,\r\n" + 
			"        \"value\": 100\r\n" + 
			"      }\r\n" + 
			"    }";

	public static void main(String[] args) {
		
		ApiError ae = JSONUtils.fromJSON(json, ApiError.class);
		
		System.out.println(ReflectionToStringBuilder.toString(ae, new MultilineRecursiveToStringStyle()));
		
		String json = JSONUtils.toJSON(ae);
		
		System.out.println(json);
		
	}
	
}
