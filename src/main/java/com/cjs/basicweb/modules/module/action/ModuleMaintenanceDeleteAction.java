package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.modules.module.ModuleForm;
import com.cjs.basicweb.modules.module.action.ModuleMaintenanceAction;
import com.cjs.core.exception.AppException;

public class ModuleMaintenanceDeleteAction extends ModuleMaintenanceAction {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleMaintenanceDeleteAction() throws AppException {
		super();
	}

	public String executeDelete() throws AppException {
		ModuleForm form = getForm();
		getBL().update(form.getSelectedId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewURLs());
		return SUCCESS;
	}
}
