package com.cjs.basicweb.modules.logout.action;

import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.cjs.struts2.BaseAction;

public class LogoutExecuteAction extends BaseAction {
	private static final long serialVersionUID = -3643549719278354411L;

	@Override
	public String execute() throws AppException, UserException {
		getSession().invalidate();
		return SUCCESS;
	}
}
