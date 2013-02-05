package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.utility.BaseAction;

public class ModuleMainAction extends BaseAction {

	private static final long serialVersionUID = 8114275581397242184L;
	
	private String moduleId;
	private String moduleName;
	private String moduleAction;
	private String moduleParent;
	
	public String initial() {
		return SUCCESS;
	}
	
	public String prepareNew() {
		return SUCCESS;
	}
	
	public String search() {
		return SUCCESS;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleAction() {
		return moduleAction;
	}

	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}

	public String getModuleParent() {
		return moduleParent;
	}

	public void setModuleParent(String moduleParent) {
		this.moduleParent = moduleParent;
	}
}
