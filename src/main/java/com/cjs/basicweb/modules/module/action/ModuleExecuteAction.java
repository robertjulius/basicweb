package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.basicweb.utility.BaseAction;

public class ModuleExecuteAction extends BaseAction {

	private static final long serialVersionUID = 8114275581397242184L;
	
	private String moduleId;
	private String moduleName;
	private String moduleAction;
	private String moduleParent;
	
	public String confirmNew() {
		Module module = new Module();
		module.setId(moduleId);
		module.setName(moduleName);
		module.setAction(moduleAction);
		
		Module parent = new Module();
		parent.setId(moduleParent);
		module.setParent(parent);
		
		ModuleBL moduleBL = new ModuleBL();
		moduleBL.checkDuplicate();
		
		return SUCCESS;
	}

	public String getModuleAction() {
		return moduleAction;
	}

	public String getModuleId() {
		return moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getModuleParent() {
		return moduleParent;
	}

	public void setModuleAction(String moduleAction) {
		this.moduleAction = moduleAction;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setModuleParent(String moduleParent) {
		this.moduleParent = moduleParent;
	}
}
