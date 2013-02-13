package com.cjs.basicweb.modules.logout.action;

import com.cjs.basicweb.modules.login.logic.LoginBL;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.cjs.struts2.BaseAction;

public class LogoutExecuteAction extends BaseAction<LoginBL> {

	private static final long serialVersionUID = -3643549719278354411L;

	public LogoutExecuteAction() throws AppException {
		super(LoginBL.class);
	}

	@Override
	public String execute() throws AppException, UserException {
		getSession().invalidate();
		return SUCCESS;
	}
}
