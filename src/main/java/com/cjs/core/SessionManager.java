package com.cjs.core;

import javax.servlet.http.HttpSession;

import com.cjs.core.exception.AppException;

public interface SessionManager {

	public HttpSession getHttpSessionById(String sessionId) throws AppException;

	public void registerHttpSession(HttpSession httpSession)
			throws AppException;

	public void unregisterHttpSession(String sessionId) throws AppException;
}
