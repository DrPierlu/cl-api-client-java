package io.commercelayer.api.codegen.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiModel {

	private Map<String, ClassGroup> classGroups = new HashMap<>();
	
	
	public Map<String, ClassGroup> getClassGroups() {
		return classGroups;
	}
	
	public ClassGroup getClassGroup(String classPackage) {
		return getClassGroups().get(classPackage);
	}
	
	public boolean addClass(ModelClass class_) {
		
		if (class_ == null) return false;
		
		String key = class_.getClassPackage();
		String srcDir = /*ApiModelGen.PACKAGE_TEST.equals(key)? "src/test/java" :*/ "src/main/java";
		ClassGroup cg = this.classGroups.get(key);
		
		if (cg == null) this.classGroups.put(key, cg = new ClassGroup(srcDir));
			
		cg.addClass(class_);
		
		
		return true;
		
	}



	public static final class ClassGroup {
		
		private String sourceDirectory;
		private List<ModelClass> groupClasses = new ArrayList<>();
		
		public ClassGroup(String sourceDirectory) {
			super();
			this.sourceDirectory = sourceDirectory;
		}

		public List<ModelClass> getGroupClasses() {
			return groupClasses;
		}
		
		public void addClass(ModelClass class_) {
			if (!this.groupClasses.contains(class_)) this.groupClasses.add(class_);
			else {
				for (ModelClass mc : this.groupClasses)
					if (mc.equals(class_)) {
						mc.getMethodList().addAll(class_.getMethodList());
						break;
					}
			}
		}

		public String getSourceDirectory() {
			return sourceDirectory;
		}

		public void setSourceDirectory(String sourceDirectory) {
			this.sourceDirectory = sourceDirectory;
		}
		
	}
	
	
	public boolean containsClass(String pkg, ModelClass mc) {
		
		ClassGroup cg = classGroups.get(pkg);
		
		if (cg != null)
			for (ModelClass mc_ : cg.getGroupClasses()) {
				if (mc_.getName().equals(mc.getName())) return true;
			}
		
		return false;
		
	}
	
	
	public ModelClass getModelClass(String pkg, String name) {
		
		ClassGroup cg = classGroups.get(pkg);
		
		if (cg != null)
			for (ModelClass mc_ : cg.getGroupClasses()) {
				if (mc_.getName().equals(name)) return mc_;
			}
		
		return null;
		
	}

}
