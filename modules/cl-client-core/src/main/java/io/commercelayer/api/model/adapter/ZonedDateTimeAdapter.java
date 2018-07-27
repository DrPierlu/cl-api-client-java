package io.commercelayer.api.model.adapter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

public class ZonedDateTimeAdapter extends JsonAdapter<ZonedDateTime> {

	@Override
	public ZonedDateTime fromJson(JsonReader reader) throws IOException {
		return ZonedDateTime.parse(reader.nextString());
	}

	@Override
	public void toJson(JsonWriter writer, ZonedDateTime value) throws IOException {
		Date date = Date.from(value.toInstant());
		writer.value( new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(date));
	}

}
