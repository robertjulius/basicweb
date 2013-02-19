package com.cjs.basicweb.modules.usergroupmaintenance.form;

import java.util.List;

import com.cjs.basicweb.model.FormBean;
import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.usergroup.UserGroup;

public class UserGroupMaintenanceForm extends FormBean {

	private static final long serialVersionUID = 7952657167875968415L;

	private String searchId;
	private String searchName;
	private String searchDescription;
	private String selectedId;
	private List<UserGroup> searchResult;

	private UserGroup old;

	private String newId;
	private String newName;
	private String newDescription;
	private List<String> newModules;

	private List<Item> allModules;

	public List<Item> getAllModules() {
		return allModules;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public String getNewId() {
		return newId;
	}

	public List<String> getNewModules() {
		return newModules;
	}

	public String getNewName() {
		return newName;
	}

	public UserGroup getOld() {
		return old;
	}

	public String getSearchDescription() {
		return searchDescription;
	}

	public String getSearchId() {
		return searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public List<UserGroup> getSearchResult() {
		return searchResult;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setAllModules(List<Item> allModules) {
		this.allModules = allModules;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public void setNewModules(List<String> newModules) {
		this.newModules = newModules;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setOld(UserGroup old) {
		this.old = old;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void setSearchResult(List<UserGroup> searchResult) {
		this.searchResult = searchResult;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

}
