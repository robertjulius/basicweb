package com.cjs.core;

import java.util.Map;

import com.cjs.core.exception.AppException;

public interface UserSessionManager {

	public UserSession getById(String id);

	public Map<String, UserSession> getList() throws AppException;

	public void registerUserSession(UserSession userSession)
			throws AppException;
	
	public void unregisterUserSession(String id) throws AppException;
}
