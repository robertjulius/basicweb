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

	private String newId;
	private String newName;
	private String newFirstEntry;
	private Module newParent;

	private String oldId = "test";
	private String oldName;
	private String oldFirstEntry;
	private Module oldParent;

	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public String getNewFirstEntry() {
		return newFirstEntry;
	}

	public String getNewId() {
		return newId;
	}

	public String getNewName() {
		return newName;
	}

	public Module getNewParent() {
		return newParent;
	}

	public String getOldFirstEntry() {
		return oldFirstEntry;
	}

	public String getOldId() {
		return oldId;
	}

	public String getOldName() {
		return oldName;
	}

	public Module getOldParent() {
		return oldParent;
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

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public void setNewFirstEntry(String newFirstEntry) {
		this.newFirstEntry = newFirstEntry;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setNewParent(Module newParent) {
		this.newParent = newParent;
	}

	public void setOldFirstEntry(String oldFirstEntry) {
		this.oldFirstEntry = oldFirstEntry;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public void setOldParent(Module oldParent) {
		this.oldParent = oldParent;
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
}
