package io.commercelayer.api.client.common;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class QueryFilter extends LinkedHashMap<String, String> {

	private static final long serialVersionUID = -4968770304692953164L;
	
	private QueryFilter() {
		
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static QueryFilter empty() {
		return new Builder().build();
	}
	
	private QueryFilter putMap(Map<String, String> map) {
		if ((map != null) && !map.isEmpty()) super.putAll(map);
		return this;
	}
	
	public String queryString() {
		StringBuilder qs = new StringBuilder();
		for (Map.Entry<String, String> entry : this.entrySet()) {
			if (qs.length() > 0) qs.append('&');
			qs.append(entry.getKey()).append('=').append(entry.getValue());
		}
		return qs.toString();
	}
	
	
	
	public static final class Builder {
		
		private Map<String, String> queryStringParams = new LinkedHashMap<>();
		private List<String> includedResources = new LinkedList<>();
		private Map<String, Set<String>> sparseFieldsets = new LinkedHashMap<>();
		private List<String> sortFields = new LinkedList<>();
		private Map<String, String> filterFields = new LinkedHashMap<>();
		private Integer pageNumber;
		private Integer pageSize;
		
		private Builder() {
			
		}
		
		public Builder param(String key, String value) {
			this.queryStringParams.put(key, value);
			return this;
		}
		
		public Builder params(Map<String, String> params) {
			this.queryStringParams.putAll(params);
			return this;
		}
		
		public Builder include(String resource) {
			this.includedResources.add(resource);
			return this;
		}
		
		public Builder include(List<String> resources) {
			this.includedResources.addAll(resources);
			return this;
		}
		
		public Builder fields(String resource, String... fields) {
			
			if (StringUtils.isBlank(resource)) return this;
			if ((fields == null) || (fields.length == 0)) return this;
			
			Set<String> filter = this.sparseFieldsets.get(resource);
			if (filter == null) filter = new LinkedHashSet<>();
			for (String f : fields) {
				if (!filter.contains(f)) filter.add(f);
			}
			this.sparseFieldsets.put(resource, filter);
			
			return this;
			
		}
		
		public Builder field(String resource, String field) {
			this.fields(resource, new String[] { field });
			return this;
		}
		
		public Builder sort(String field) {
			return sort(field, true);
		}
		
		public Builder sort(String field, boolean ascending) {
			this.sortFields.add((ascending? "" : "-").concat(field));
			return this;
		}
		
		public Builder filter(String filter, String value) {
			this.filterFields.put(filter, value);
			return this;
		}
		
		public Builder page(Integer number, Integer size) {
			this.pageNumber = number;
			this.pageSize = size;
			return this;
		}
		
		public QueryFilter build() {
			
			QueryFilter qf = new QueryFilter();
			
			qf.putMap(buildFilterQueryMap())
			  .putMap(buildIncludedQueryMap())
			  .putMap(buildSparseFieldsetsQueryMap())
			  .putMap(buildSortQueryMap())
			  .putMap(this.queryStringParams)
			;
			
			if (this.pageNumber != null) qf.put("page[number]", String.valueOf(this.pageNumber));
			if (this.pageSize != null) qf.put("page[size]", String.valueOf(this.pageSize));
			
			return qf;
			
		}
		
		
		private Map<String, String> buildFilterQueryMap() {
			Map<String, String> params = new LinkedHashMap<>();
			for (Map.Entry<String, String> filter : this.filterFields.entrySet()) {
				params.put(String.format("filter[%s]", filter.getKey()), filter.getValue());
			}
			return params;
		}
		
		
		private Map<String, String> buildSparseFieldsetsQueryMap() {
			Map<String, String> params = new LinkedHashMap<>();
			for (Map.Entry<String, Set<String>> fieldset : this.sparseFieldsets.entrySet()) {
				if (fieldset.getValue().isEmpty()) continue;
				params.put(String.format("fields[%s]", fieldset.getKey()), StringUtils.join(fieldset.getValue(), ','));
			}
			return params;
		}
		
		
		private Map<String, String> buildIncludedQueryMap() {
			Map<String, String> params = new LinkedHashMap<>();
			if (!this.includedResources.isEmpty()) params.put("include", StringUtils.join(this.includedResources, ','));
			return params;
		}
		
		
		private Map<String, String> buildSortQueryMap() {
			Map<String, String> params = new LinkedHashMap<>();
			if (!this.sortFields.isEmpty()) params.put("sort", StringUtils.join(this.sortFields, ','));
			return params;			
		}
		
	}

}
