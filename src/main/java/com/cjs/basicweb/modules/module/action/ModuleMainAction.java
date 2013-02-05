package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.modules.module.form.ModuleSearchForm;
import com.cjs.struts2.FormAction;

public class ModuleMainAction extends FormAction<ModuleSearchForm> {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleMainAction() {
		super(ModuleSearchForm.class);
	}

	public String initial() {
		return SUCCESS;
	}

	public String prepareNew() {
		return SUCCESS;
	}

	public String search() {
		return SUCCESS;
	}

}
