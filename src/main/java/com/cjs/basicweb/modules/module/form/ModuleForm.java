package com.cjs.basicweb.modules.module.form;

import java.util.List;

import com.cjs.basicweb.model.FormBean;
import com.cjs.basicweb.model.module.Module;

public class ModuleForm extends FormBean {

	private static final long serialVersionUID = 7952657167875968415L;

	private String searchId;
	private String searchName;
	private String searchAction;
	private String searchParent;

	private String newId;
	private String newName;

	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public String getNewId() {
		return newId;
	}

	public String getNewName() {
		return newName;
	}

	public String getSearchAction() {
		return searchAction;
	}

	public String getSearchId() {
		return searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public String getSearchParent() {
		return searchParent;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setSearchAction(String searchAction) {
		this.searchAction = searchAction;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void setSearchParent(String searchParent) {
		this.searchParent = searchParent;
	}
}
