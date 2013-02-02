package com.cjs.core;

import com.cjs.core.exception.AppException;

public interface UserSessionManager {

	public UserSession getById(String id);

	public void registerUserSession(UserSession userSession)
			throws AppException;

	public void unregisterUserSession(String id) throws AppException;
}
