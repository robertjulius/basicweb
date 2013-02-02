package com.cjs.basicweb.modules.login.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.cjs.basicweb.modules.login.logic.LoginBL;
import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginExecuteAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3643549719278354411L;

	private String userId;
	private String password;

	private LoginBL loginBL;
	private UserSession userSession;

	private SessionMap<String, Object> sessionMap;

	public LoginExecuteAction(LoginBL loginBL, UserSession userSession) {
		this.loginBL = loginBL;
		this.userSession = userSession;
	}

	@Override
	public String execute() throws AppException {
		try {
			User user = loginBL.performLogin(userId, password, userSession);
			userSession.setUser(user);
			sessionMap.put(GeneralConstants.USER_SESSION, userSession);
			AppContextManager.getUserSessionManager().registerUserSession(
					userSession);
			return SUCCESS;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return INPUT;
		}
	}

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = (SessionMap<String, Object>) session;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
