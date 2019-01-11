package io.commercelayer.api.codegen.test;

import java.util.SortedMap;
import java.util.TreeMap;

public final class ApiSecurityMap {
	
	private final SortedMap<String, Permissions> resourcePermissions = new TreeMap<>();
	
	SortedMap<String, Permissions> getPermissions() {
		return this.resourcePermissions;
	}
	
	public void setResourcePermissions(String resourceName, Permissions permissions) {
		this.resourcePermissions.put(resourceName, permissions);
	}
	
	public void setResourcePermissions(String resourceName, boolean create, boolean read, boolean update, boolean delete) {
		setResourcePermissions(resourceName, new Permissions(create, read, update, delete));
	}
	
	public Permissions getResourcePermissions(String resourceName) {
		Permissions p = this.resourcePermissions.get(resourceName);
		return (p == null)? new Permissions() : p;
	}

	public final static class Permissions {
		
		private boolean create;
		private boolean read;
		private boolean update;
		private boolean delete;
		
		private Permissions() {
			
		}
		
		Permissions(boolean create, boolean read, boolean update, boolean delete) {
			this.create = create;
			this.read = read;
			this.update = update;
			this.delete = delete;
		}
		
		public boolean create() {
			return this.create;
		}
		
		public boolean read() {
			return this.read;
		}
		
		public boolean update() {
			return this.update;
		}
		
		public boolean delete() {
			return this.delete;
		}
		
		public String toString() {
			return String.format("[create=%s, read=%s, update=%s, delete=%s]", create, read, update, delete);
		}
		
	}
	
}
