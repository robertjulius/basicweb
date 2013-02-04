package com.cjs.basicweb.modules.test.action;

import com.cjs.basicweb.utility.SessionValidationAction;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class TestFirstEntryAction extends SessionValidationAction {
	private static final long serialVersionUID = -3643549719278354411L;

	@Override
	public String executes() throws AppException, UserException {
		return SUCCESS;
	}
}
