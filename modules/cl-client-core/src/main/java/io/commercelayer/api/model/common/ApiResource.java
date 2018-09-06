package io.commercelayer.api.model.common;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.ZonedDateTime;
import java.util.Map;

import com.squareup.moshi.Json;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.adapter.CLMetaAdapter;
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
		
		Class<?> classe = getClass();
		Field[] fields = classe.getDeclaredFields();
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(classe.getSimpleName()).append("->[");
		
		builder.append("id=").append(getId());
		
		
		if (fields != null)
			for (Field field : fields) {
				
//				if ((field.getModifiers() & Modifier.STATIC) > 0) continue;
				if (Modifier.isStatic(field.getModifiers())) continue;
				
				builder.append(", ");
				builder.append(field.getName());
				builder.append("=");
				
				Object value = null;
				try {
					field.setAccessible(true);
					value = field.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					value = null;
				}
//				builder.append(String.valueOf(value));
				builder.append((value == null)? "<null>" : value.toString());
				
			}
		
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", metadata=");
		builder.append(metadata);
		builder.append(", reference=");
		builder.append(reference);
		
		builder.append("]");
		
		return builder.toString();
		
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
