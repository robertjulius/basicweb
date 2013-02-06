package com.cjs.basicweb.modules.resetusersession.form;

import java.util.List;

import com.cjs.basicweb.model.FormBean;
import com.cjs.core.UserSession;

public class ResetUserSessionForm extends FormBean {

	private static final long serialVersionUID = -497930027977555847L;

	private String userId = "test";
	private List<UserSession> userSessions;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<UserSession> getUserSessions() {
		return userSessions;
	}

	public void setUserSessions(List<UserSession> userSessions) {
		this.userSessions = userSessions;
	}
}
