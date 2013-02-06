package com.cjs.basicweb.modules.resetusersession.logic;

import java.util.List;

import com.cjs.basicweb.modules.login.usersession.SimpleSessionManager;
import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;


public class ResetUserSessionBL {

	public List<UserSession> getList() throws AppException {
		return ((SimpleSessionManager) AppContextManager.getSessionManager()).getUserSessions();
	}
	
	public void reset(String userId) throws AppException {
		AppContextManager.getSessionManager().getByUserId(userId).invalidate();
	}
}
