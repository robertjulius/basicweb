package com.cjs.basicweb.modules.login.usersession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.UserSession;
import com.cjs.core.UserSessionManager;
import com.cjs.core.exception.AppException;

public class SimpleUserSessionManager implements UserSessionManager {

	private Map<String, UserSession> map = new ConcurrentHashMap<>();

	@Override
	public UserSession getById(String id) {
		return map.get(id);
	}

	@Override
	public void registerUserSession(UserSession userSession)
			throws AppException {
		if (map.containsKey(userSession.getUser().getUserId())) {
			throw new AppException(
					PropertiesConstants.ERROR_DUPLICATE_REGISTER_USERSESSION);
		}
	}

	@Override
	public void unregisterUserSession(String id) throws AppException {
		map.remove(id);
	}
}
