package io.commercelayer.api.model.adapter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

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
		throw new UnsupportedOperationException("JSON API Links serialization not implemented");
	}

}
