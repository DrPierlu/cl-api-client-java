package io.commercelayer.api.client.common.query;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.commercelayer.api.util.StringUtils;

public class QueryExpression extends QueryFilter {

	private static final long serialVersionUID = -1026214184592582064L;

	private QueryExpression() {
		super();
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static String describe(Predicate predicate) {
		return (predicate == null)? "" : predicate.description();
	}
	
	
	public static final class Builder extends QueryFilter.Builder {
		
		private Map<String, String> predicates = new LinkedHashMap<>();
		
		private Builder() {
			super();
		}
		
		public Builder predicate(Predicate predicate, String[] values, String... fields) {
			return this.predicate(predicate, Arrays.asList(values), fields);
		}
		
		public Builder predicate(Predicate predicate, List<String> values, String... fields) {
			return this.predicate(predicate, StringUtils.join(values, ','), fields);
		}
		
		public Builder predicate(Predicate predicate, String value, String... fields) {
	        if (fields == null) return this;
	        String key = StringUtils.join(Arrays.asList(fields), "_or_").concat("_").concat(predicate.code);
	        this.predicates.put(key, value);
	        return this;
	    }

		
		
		public QueryFilter build() {

			QueryExpression qe = new QueryExpression();
			qe.putMap(super.build());
			
			qe.putMap(buildPredicatesMap());

			return qe;
		
		}
		
		
		private Map<String, String> buildPredicatesMap() {
			Map<String, String> params = new LinkedHashMap<>();
			for (Map.Entry<String, String> predicate : this.predicates.entrySet()) {
				params.put(String.format("filter[q][%s]", predicate.getKey()), predicate.getValue());
			}
			return params;
		}
		
		public Builder param(String key, String value) {
			super.param(key, value);
			return this;
		}
		
		public Builder params(Map<String, String> params) {
			super.params(params);
			return this;
		}
		
		public Builder include(String resource) {
			super.include(resource);
			return this;
		}
		
		public Builder include(List<String> resources) {
			super.include(resources);
			return this;
		}
		
		public Builder fields(String resource, String... fields) {
			super.fields(resource, fields);
			return this;
		}
		
		public Builder field(String resource, String field) {
			super.field(resource, field);
			return this;
		}
		
		public Builder sort(String field) {
			return this.sort(field, true);
		}
		
		public Builder sort(String field, boolean ascending) {
			super.sort(field, ascending);
			return this;
		}
		
		public Builder filter(String filter, String value) {
			super.filter(filter, value);
			return this;
		}
		
		public Builder page(Integer number, Integer size) {
			super.page(number, size);
			return this;
		}
		
		public Builder pageSize(Integer size) {
			super.pageSize(size);
			return this;
		}
		
		public Builder pageNumber(Integer number) {
			super.pageNumber(number);
			return this;
		}
		
	}
	
	
	// Predicate
	public static enum Predicate {
		
		EQ("eq", "equals"),
        EQ_ANY("eq_any", "equals any"),
        EQ_ALL("eq_all", "equals all"),
        NOT_EQ("not_eq", "not equal to"),
        NOT_EQ_ANY("not_eq_any", "not equal to any"),
        NOT_EQ_ALL("not_eq_all", "not equal to all"),
        MATCHES("matches", "matches"),
        MATCHES_ANY("matches_any", "matches any"),
        MATCHES_ALL("matches_all", "matches all"),
        DOES_NOT_MATCH("does_not_match", "doesn't match"),
        DOES_NOT_MATCH_ANY("does_not_match_any", "doesn't match any"),
        DOES_NOT_MATCH_ALL("does_not_match_all", "doesn't match all"),
        LT("lt", "less than"),
        LT_ANY("lt_any", "less than any"),
        LT_ALL("lt_all", "less than all"),
        LTEQ("lteq", "less than or equal to"),
        LTEQ_ANY("lteq_any", "less than or equal to any"),
        LTEQ_ALL("lteq_all", "less than or equal to all"),
        GT("gt", "greater than"),
        GT_ANY("gt_any", "greater than any"),
        GT_ALL("gt_all", "greater than all"),
        GTEQ("gteq", "greater than or equal to"),
        GTEQ_ANY("gteq_any", "greater than or equal to any"),
        GTEQ_ALL("gteq_all", "greater than or equal to all"),
        IN("in", "in"),
        IN_ANY("in_any", "in any"),
        IN_ALL("in_all", "in all"),
        NOT_IN("not_in", "not in"),
        NOT_IN_ANY("not_in_any", "not in any"),
        NOT_IN_ALL("not_in_all", "not in all"),
        CONT("cont", "contains"),
        CONT_ANY("cont_any", "contains any"),
        CONT_ALL("cont_all", "contains all"),
        NOT_CONT("not_cont", "doesn't contain"),
        NOT_CONT_ANY("not_cont_any", "doesn't contain any"),
        NOT_COPNT_ALL("not_cont_all", "doesn't contain all"),
        START("start", "starts with"),
        START_ANY("start_any", "starts with any"),
        START_ALL("start_all", "starts with all"),
        NOT_START("not_start", "doesn't start with"),
        NOT_START_ANY("not_start_any", "doesn't start with any"),
        NOT_START_ALL("not_start_all", "doesn't start with all"),
        END("end", "ends with"),
        END_ANY("end_any", "ends with any"),
        END_ALL("end_all", "ends with all"),
        NOT_END("not_end", "doesn't end with"),
        NOT_END_ANY("not_end_any", "doesn't end with any"),
        NOT_END_ALL("not_end_all", "doesn't end with all"),
        TRUE("true", "is true"),
        FALSE("false", "is false"),
        PRESENT("present", "is present"),
        BLANK("blank", "is blank"),
        NULL("null", "is null"),
        NOT_NULL("not_null", "is not null");
	
	
		private String code;
		private String description;
		
		
		private Predicate(String code, String description) {
			this.code = code;
			this.description = description;
		}
		
		public String code() {
			return this.code;
		}
		
		public String description() {
			return this.description;
		}
		
	}
	
}
