package com.cjs.core;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.cjs.core.exception.AppException;

public class DefaultSessionManager implements SessionManager {

	/*
	 * Contains session id and the http session it self
	 */
	private static final HashMap<String, HttpSession> sessions = new HashMap<String, HttpSession>();

	public HttpSession getHttpSessionById(String sessionId) {
		return DefaultSessionManager.sessions.get(sessionId);
	}

	public HashMap<String, HttpSession> getSessions() {
		return sessions;
	}

	public void registerHttpSession(HttpSession httpSession) throws AppException
			 {

		if (DefaultSessionManager.sessions.containsValue(httpSession)) {
			throw new AppException("HttpSession '" + httpSession
					+ "' with ID '" + httpSession.getId()
					+ "' already registered");
		}

		String sessionId = httpSession.getId();
		if (DefaultSessionManager.sessions.containsKey(sessionId)) {
			throw new AppException("Session ID '" + sessionId
					+ "' already registered");
		}

		DefaultSessionManager.sessions.put(sessionId, httpSession);
	}

	public void unregisterHttpSession(String sessionId) {
		DefaultSessionManager.sessions.remove(sessionId);
	}
}
