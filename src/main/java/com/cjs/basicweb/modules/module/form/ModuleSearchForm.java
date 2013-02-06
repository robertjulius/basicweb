package com.cjs.basicweb.modules.module.form;

import com.cjs.basicweb.model.FormBean;

public class ModuleSearchForm extends FormBean {

	private static final long serialVersionUID = 4109986718447597723L;

	private String searchId;
	private String searchName;
	private String searchAction;

	public String getSearchAction() {
		return searchAction;
	}

	public String getSearchId() {
		return searchId;
	}

	public String getSearchName() {
		return searchName;
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
}
