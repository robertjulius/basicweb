package com.cjs.basicweb.modules.resetusersession.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;


public class ResetUserSessionBL {

	public List<UserSession> getList() throws AppException {
		List<UserSession> userSessions = new ArrayList<>();
		
		Map<String, UserSession> map = AppContextManager.getUserSessionManager().getList();
		
		Iterator<String> iterator  = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			UserSession userSession = map.get(key);
			userSessions.add(userSession);
		}
		
		return userSessions;
	}
	
	public void reset(String id) throws AppException {

		AppContextManager.getUserSessionManager().unregisterUserSession(
				id);

		/*
		 * TODO
		 * Find a way to get http session
		 */
		//getSession().invalidate();
	}
}
