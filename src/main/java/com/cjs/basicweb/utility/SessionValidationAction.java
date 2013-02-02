package com.cjs.basicweb.utility;

import static com.cjs.basicweb.utility.PropertiesConstants.ERROR_SESSION_EXPIRED;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionSupport;

public abstract class SessionValidationAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = -3643549719278354411L;

	private SessionMap<String, Object> sessionMap;

	@Override
	public final String execute() throws Exception {
		try {
			if (sessionMap.isEmpty()) {
				throw new AppException(ERROR_SESSION_EXPIRED);
			}
			return executes();
		} catch (AppException e) {
			throw e;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return INPUT;
		}
	}

	public abstract String executes() throws AppException, UserException;

	public SessionMap<String, Object> getSession() {
		return sessionMap;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
}
