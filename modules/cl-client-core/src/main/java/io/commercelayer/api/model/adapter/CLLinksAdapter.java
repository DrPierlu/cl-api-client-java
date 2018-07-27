package io.commercelayer.api.model.adapter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

public class CLLinksAdapter extends JsonAdapter<Map<String, String>> {

	@Override
	public Map<String, String> fromJson(JsonReader reader) throws IOException {
		
		Map<String, String> links = new LinkedHashMap<>();
		
		reader.beginObject();
		while (reader.hasNext()) {
			links.put(reader.nextName(), reader.nextString());
		}
		reader.endObject();
		
		return links;
		
	}

	@Override
	public void toJson(JsonWriter writer, Map<String, String> value) throws IOException {
		throw new NotImplementedException("JSON API Links serialization non implemented");
	}

}
