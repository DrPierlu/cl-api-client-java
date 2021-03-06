package io.commercelayer.api.test;


import io.commercelayer.api.client.common.query.QueryFilter;

public class QueryFilterTest {

	public static void main(String[] args) {
		
		QueryFilter qf = QueryFilter.builder()
			.filter("nome", "Mario")
			.filter("cognome", "Rossi")
			.include("home_address")
			.include("birth_address")
			.sort("cognome", false)
			.sort("nome")
			.fields("birth_address", "city", "state")
			.fields("home_address", "city", "address", "state")
			.param("param1", "value1")
			.param("param2", "value2")
			.page(2, 10)
			.build();
		
		System.out.println(qf.queryString());
		
	}
	
}
