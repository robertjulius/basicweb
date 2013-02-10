package com.cjs.basicweb.modules.module.form;

import java.util.List;

import com.cjs.basicweb.model.FormBean;
import com.cjs.basicweb.model.module.Module;

public class ModuleForm extends FormBean {

	private static final long serialVersionUID = 7952657167875968415L;

	private String searchId;
	private String searchName;
	private String searchFirstEntry;
	private String searchParentId;
	private String selectedId;
	private Module selected;
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public String getSearchFirstEntry() {
		return searchFirstEntry;
	}

	public String getSearchId() {
		return searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public String getSearchParentId() {
		return searchParentId;
	}

	public Module getSelected() {
		return selected;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void setSearchFirstEntry(String searchFirstEntry) {
		this.searchFirstEntry = searchFirstEntry;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void setSearchParentId(String searchParentId) {
		this.searchParentId = searchParentId;
	}

	public void setSelected(Module selected) {
		this.selected = selected;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
}
