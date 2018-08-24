package io.commercelayer.api.model.common.error;

import java.util.Map;

import io.commercelayer.api.model.common.ApiObject;

public final class ApiError extends ApiObject {

	private String title;
	private String detail;
	private String code;
	private Source source;
	private String status;
	private Map<String, String> meta;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<String, String> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, String> meta) {
		this.meta = meta;
	}

	public static final class Source {

		private String pointer;

		public String getPointer() {
			return pointer;
		}

		public void setPointer(String pointer) {
			this.pointer = pointer;
		}

	}

}
