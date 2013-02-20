package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleMaintenanceDeleteAction extends
		FormAction<ModuleForm, ModuleBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleMaintenanceDeleteAction() throws AppException {
		super(ModuleForm.class, ModuleBL.class);
	}

	public String executeDelete() throws AppException {
		ModuleForm form = getForm();
		getBL().update(form.getSelectedId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewURLs());
		return SUCCESS;
	}
}
