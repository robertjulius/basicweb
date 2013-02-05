package com.cjs.basicweb.modules.module.form;

import com.cjs.basicweb.model.FormBean;

public class ModuleInputForm implements FormBean {

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
