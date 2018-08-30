package io.commercelayer.api.test.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import io.commercelayer.api.model.Address;
import io.commercelayer.api.model.Geocoder;
import io.commercelayer.api.model.adapter.BooleanAdapter;
import io.commercelayer.api.model.adapter.ZonedDateTimeAdapter;
import moe.banana.jsonapi2.ArrayDocument;
import moe.banana.jsonapi2.Document;
import moe.banana.jsonapi2.ResourceAdapterFactory;

public class AddressJsonTest {

	public static void main(String[] args) {

		String test = "from";

		if ("to".equalsIgnoreCase(test))
			toJson();
		else
			try {
				fromJson();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	private static void fromJson() throws IOException {
	
		byte[] file = Files.readAllBytes(Paths.get("src/test/resources", "address.json"));
		
		String json = new String(file);
		
		System.out.println(json);
		
		JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder()
				.add(Address.class)
				.add(Geocoder.class)
				.build();

		Moshi moshi = new Moshi.Builder()
				.add(jsonApiAdapterFactory)
//				.add(new Rfc3339DateJsonAdapter())
				.add(ZonedDateTime.class, new ZonedDateTimeAdapter())
				.add(Boolean.class, new BooleanAdapter())
				.build();

//		Address address = moshi.adapter(Address.class).fromJson(json);
		
		ArrayDocument<Address> addresses = moshi.adapter(Document.class).fromJson(json).asArrayDocument();
		
		Address address = addresses.get(0);
		
		System.out.println(address);
		
		System.out.println("META: " + address.getMetaMap());
		System.out.println("LINKS: " + address.getLinksMap());
		
		Map<String, String> gl = address.getGeocoderLinksMap();
		System.out.println(gl);
		
		System.out.println(address.getGeocoderResource());
		
	}

	private static void toJson() {

		Address address = new Address();

		address.setLine1("line1value");
		address.setCity("cityvalue");
		address.setZipCode("zipcodevalue");
		address.setStateCode("IT");
		address.setCountryCode("IT");
		address.setPhone("12345567");
		address.setCreatedAt(ZonedDateTime.now(ZoneId.systemDefault()));

		JsonAdapter.Factory jsonApiAdapterFactory = ResourceAdapterFactory.builder()
			.add(Address.class).build();

		Moshi moshi = new Moshi.Builder().add(jsonApiAdapterFactory)
				.add(ZonedDateTime.class, new ZonedDateTimeAdapter()).build();

		String json = moshi.adapter(Address.class).toJson(address);

		System.out.println(json);

	}

}
