package io.commercelayer.api.model.adapter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

public class CLMetaAdapter extends JsonAdapter<Map<String, String>> {

	@Override
	public Map<String, String> fromJson(JsonReader reader) throws IOException {
		
		Map<String, String> meta = new LinkedHashMap<>();
		
		reader.beginObject();
		while (reader.hasNext()) {
			meta.put(reader.nextName(), reader.nextString());
		}
		reader.endObject();
		
		return meta;
		
	}

	@Override
	public void toJson(JsonWriter writer, Map<String, String> value) throws IOException {
		throw new UnsupportedOperationException("JSON API Meta serialization non implemented");
	}

}
