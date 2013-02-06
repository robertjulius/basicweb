package com.cjs.basicweb.modules.module.form;

import com.cjs.basicweb.model.FormBean;

public class ModuleInputForm extends FormBean {

	private static final long serialVersionUID = 7952657167875968415L;

	private String id;
	private String name;
	private String action;

	public String getAction() {
		return action;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
