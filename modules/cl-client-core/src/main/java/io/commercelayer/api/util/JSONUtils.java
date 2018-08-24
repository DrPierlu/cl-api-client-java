package io.commercelayer.api.util;

import java.io.IOException;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.config.ApiConfig;
import io.commercelayer.api.model.adapter.BooleanAdapter;
import io.commercelayer.api.model.adapter.ZonedDateTimeAdapter;
import moe.banana.jsonapi2.Resource;
import moe.banana.jsonapi2.ResourceAdapterFactory;

public class JSONUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);
	
	public static <T> JsonAdapter<T> getJSONAdapter(Class<T> class_) {

		Moshi.Builder moshiBuilder = new Moshi.Builder();
		
		if (Resource.class.isAssignableFrom(class_)) {
			JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder().build();
			moshiBuilder.add(jsonApiAdapterFactory);
		}
			
		Moshi moshi = moshiBuilder
			.add(ZonedDateTime.class, new ZonedDateTimeAdapter())
			.add(Boolean.class, new BooleanAdapter())
			.build();
		
		JsonAdapter<T> jsonAdapter = moshi.adapter(class_);
		if (ApiConfig.testModeEnabled()) jsonAdapter = jsonAdapter.indent("    ");
		
		return jsonAdapter;
		
	}
	
	public static String toJSON(Object o) {
		return getJSONAdapter(Object.class).toJson(o);
	}
	
	public static String toJSON(Resource r) {
		return getJSONAdapter(Resource.class).toJson(r);
	}
	
	
	public static <T> T fromJSON(String json, Class<T> class_) {		
		try {
			return getJSONAdapter(class_).fromJson(json);
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}	
	}
	
}
