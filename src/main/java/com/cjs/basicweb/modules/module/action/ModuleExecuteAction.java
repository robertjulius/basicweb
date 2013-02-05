package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.modules.module.form.ModuleInputForm;
import com.cjs.struts2.FormAction;

public class ModuleExecuteAction extends FormAction<ModuleInputForm> {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleExecuteAction() {
		super(ModuleInputForm.class);
	}

	public String confirmNew() {

		return SUCCESS;
	}
}
