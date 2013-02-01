package com.cjs.basicweb.base.model.usersession;

import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import com.cjs.basicweb.applets.Privilege;
import com.cjs.core.SessionManager;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;

public class UserSessionImpl implements UserSession {

	private User user;
	private String sessionId;
	private TreeMap<String, Privilege> treeMap;

	private SessionManager sessionManager;

	public UserSessionImpl(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public UserSession getFromSession() throws AppException {
		HttpSession httpSession = sessionManager.getHttpSessionById(sessionId);
		return (UserSession) httpSession.getAttribute("userSession");
	}

	public String getSessionId() {
		return sessionId;
	}

	public User getUser() {
		return user;
	}

	public void registerToHttpSession() throws AppException {
		HttpSession httpSession = sessionManager.getHttpSessionById(sessionId);
		httpSession.setAttribute("userSession", this);
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TreeMap<String, Privilege> getTreeMap() {
		return treeMap;
	}

	public void setTreeMap(TreeMap<String, Privilege> treeMap) {
		this.treeMap = treeMap;
	}
}
