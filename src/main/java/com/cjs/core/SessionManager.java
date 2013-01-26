package com.cjs.core;

import javax.servlet.http.HttpSession;

public interface SessionManager {

	public HttpSession getHttpSessionById(String sessionId) throws CJSException;

	public void registerHttpSession(HttpSession httpSession)
			throws CJSException;

	public void unregisterHttpSession(String sessionId) throws CJSException;
}
