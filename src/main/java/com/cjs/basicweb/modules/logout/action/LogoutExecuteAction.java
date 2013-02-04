package com.cjs.basicweb.modules.logout.action;

import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.basicweb.utility.SessionValidationAction;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class LogoutExecuteAction extends SessionValidationAction {
	private static final long serialVersionUID = -3643549719278354411L;

	@Override
	public String executes() throws AppException, UserException {

		UserSession userSession = (UserSession) getSession().get(
				GeneralConstants.USER_SESSION);

		AppContextManager.getUserSessionManager().unregisterUserSession(
				userSession.getUser().getUserId());

		getSession().invalidate();

		return SUCCESS;
	}
}
