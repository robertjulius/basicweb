package com.cjs.basicweb.modules.module.form;

import java.util.List;

import com.cjs.basicweb.model.FormBean;
import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.module.Module;

public class ModuleForm extends FormBean {

	private static final long serialVersionUID = 7952657167875968415L;

	private String searchId;
	private String searchName;
	private String searchFirstEntry;
	private String searchParentId;
	private String selectedId;
	private List<Module> searchResult;

	private Module old;

	private String newId;
	private String newFirstEntry;
	private String newName;
	private String newDescription;
	private String newParentId;
	private String newParentName;
	private List<String> newAccessPaths;

	private List<Item> selectListParent;
	private String selectedParentId;

	public List<String> getNewAccessPaths() {
		return newAccessPaths;
	}

	public String getNewDescription() {
		return newDescription;
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

	public String getNewParentId() {
		return newParentId;
	}

	public String getNewParentName() {
		return newParentName;
	}

	public Module getOld() {
		return old;
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

	public List<Module> getSearchResult() {
		return searchResult;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public String getSelectedParentId() {
		return selectedParentId;
	}

	public List<Item> getSelectListParent() {
		return selectListParent;
	}

	public void setNewAccessPaths(List<String> newAccessPaths) {
		this.newAccessPaths = newAccessPaths;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
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

	public void setNewParentId(String newParentId) {
		this.newParentId = newParentId;
	}

	public void setNewParentName(String newParentName) {
		this.newParentName = newParentName;
	}

	public void setOld(Module old) {
		this.old = old;
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

	public void setSearchResult(List<Module> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	public void setSelectedParentId(String selectedParentId) {
		this.selectedParentId = selectedParentId;
	}

	public void setSelectListParent(List<Item> selectListParent) {
		this.selectListParent = selectListParent;
	}
}
