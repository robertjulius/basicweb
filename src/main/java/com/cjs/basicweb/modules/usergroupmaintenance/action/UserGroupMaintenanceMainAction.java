package com.cjs.basicweb.modules.usergroupmaintenance.action;

import com.cjs.basicweb.modules.usergroupmaintenance.form.UserGroupMaintenanceForm;
import com.cjs.basicweb.modules.usergroupmaintenance.logic.UserGroupMaintenanceBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class UserGroupMaintenanceMainAction extends FormAction<UserGroupMaintenanceForm, UserGroupMaintenanceBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	public UserGroupMaintenanceMainAction() throws AppException {
		super(UserGroupMaintenanceForm.class, UserGroupMaintenanceBL.class);
	}

	public String confirmEdit() throws AppException {
		return SUCCESS;
	}
	
	public String confirmNew() throws AppException {
		return confirmEdit();
	}

	public String executeEdit() throws AppException {
		return SUCCESS;
	}
	
	public String executeNew() throws AppException {
		return SUCCESS;
	}

	public String initial() {
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		return SUCCESS;
	}

	public String prepareEdit() throws AppException {
		return SUCCESS;
	}

	public String prepareNew() throws AppException {
		return SUCCESS;
	}

	public String search() {
		return SUCCESS;
	}
}
