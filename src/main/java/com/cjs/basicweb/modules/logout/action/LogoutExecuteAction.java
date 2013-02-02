package com.cjs.basicweb.modules.logout.action;

import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.basicweb.utility.SessionValidationAction;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class LogoutExecuteAction extends SessionValidationAction {
	private static final long serialVersionUID = -3643549719278354411L;

	private UserSession userSession;

	public LogoutExecuteAction(UserSession userSession) {
		this.userSession = userSession;
	}

	@Override
	public String executes() throws AppException, UserException {

		AppContextManager.getUserSessionManager().unregisterUserSession(
				userSession.getUser().getUserId());

		getSession().invalidate();

		return SUCCESS;
	}
}
