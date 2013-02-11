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
	private Module selected;
	private List<Module> searchResult;

	private String newId;
	private String newFirstEntry;
	private String newName;
	private String newDescription;
	private String newParentId;

	private List<Item> listParent;

	public List<Item> getListParent() {
		return listParent;
	}

	public List<Module> getSearchResult() {
		return searchResult;
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

	public void setListParent(List<Item> listParent) {
		this.listParent = listParent;
	}

	public void setSearchResult(List<Module> searchResult) {
		this.searchResult = searchResult;
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
