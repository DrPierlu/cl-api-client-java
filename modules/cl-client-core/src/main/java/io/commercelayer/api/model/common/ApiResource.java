package io.commercelayer.api.model.common;

import java.time.ZonedDateTime;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.adapter.CLMetaAdapter;
import io.commercelayer.api.util.JSONUtils;
import io.commercelayer.api.util.LogUtils;
import moe.banana.jsonapi2.Resource;

public class ApiResource extends Resource {

	private static final long serialVersionUID = -1988168104060681488L;
	
	@Json(name = "created_at")
	private ZonedDateTime createdAt;
	@Json(name = "updated_at")
	private ZonedDateTime updatedAt;
	private Map<String, String> metadata;
	private String reference;


	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		setCreatedAt(ZonedDateTime.parse(createdAt));
	}

	public ZonedDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		setUpdatedAt(ZonedDateTime.parse(updatedAt));
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, LogUtils.TO_STRING_STYLE);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getLinksMap() {
		return (Map<String, String>)getLinks().get(new CLLinksAdapter());
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getMetaMap() {
		return (Map<String, String>)getMeta().get(new CLMetaAdapter());
	}
	
}
