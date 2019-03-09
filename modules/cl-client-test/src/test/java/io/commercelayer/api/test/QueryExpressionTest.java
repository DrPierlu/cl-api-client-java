package io.commercelayer.api.test;


import io.commercelayer.api.client.common.query.QueryExpression;
import io.commercelayer.api.client.common.query.QueryExpression.Predicate;

public class QueryExpressionTest {

	public static void main(String[] args) {
		
		QueryExpression qe = (QueryExpression)QueryExpression.builder()
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
			.predicate(Predicate.EQ, "Rome", "city", "state")
			.predicate(Predicate.IN, new String[] {"Val_A", "Val_B", "Val_C"},  "field_1", "field_2")
			.build();
		
		System.out.println(qe.queryString());
		
	}
	
}
