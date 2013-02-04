package com.cjs.basicweb.modules.module.action;

import com.cjs.basicweb.utility.BaseAction;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class ModuleInitialAction extends BaseAction {

	private static final long serialVersionUID = 8114275581397242184L;

	@Override
	public String executes() throws AppException, UserException {
		return SUCCESS;
	}
}
