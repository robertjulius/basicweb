package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.struts2.FormAction;

public class ModuleExecuteAction extends FormAction<ModuleForm> {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleExecuteAction() {
		super(ModuleForm.class);
	}

	public String confirmNew() {

		return SUCCESS;
	}
}
