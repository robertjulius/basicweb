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
	private List<UserGroup> searchResult;

	private UserGroup old;

	private String newId;
	private String newName;
	private String newDescription;
	private List<String> newModules;

	private List<Item> allModules;

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchDescription() {
		return searchDescription;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;
	}

	public List<UserGroup> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<UserGroup> searchResult) {
		this.searchResult = searchResult;
	}

	public UserGroup getOld() {
		return old;
	}

	public void setOld(UserGroup old) {
		this.old = old;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public List<String> getNewModules() {
		return newModules;
	}

	public void setNewModules(List<String> newModules) {
		this.newModules = newModules;
	}

	public List<Item> getAllModules() {
		return allModules;
	}

	public void setAllModules(List<Item> allModules) {
		this.allModules = allModules;
	}
}
