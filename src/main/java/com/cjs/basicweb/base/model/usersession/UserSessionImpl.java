package com.cjs.basicweb.base.model.usersession;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.cjs.core.CJSException;
import com.cjs.core.SessionManager;
import com.cjs.core.User;
import com.cjs.core.UserSession;

public class UserSessionImpl implements UserSession {

	private User user;
	private String sessionId;

	@Inject
	private SessionManager sessionManager;

	public UserSession getFromSession() throws CJSException {
		HttpSession httpSession = sessionManager.getHttpSessionById(sessionId);
		return (UserSession) httpSession.getAttribute("userSession");
	}

	public String getSessionId() {
		return sessionId;
	}

	public User getUser() {
		return user;
	}

	public void registerToHttpSession() throws CJSException {
		HttpSession httpSession = sessionManager.getHttpSessionById(sessionId);
		httpSession.setAttribute("userSession", this);
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
