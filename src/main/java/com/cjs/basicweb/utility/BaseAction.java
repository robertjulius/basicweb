package com.cjs.basicweb.utility;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware {

	private static final long serialVersionUID = -3643549719278354411L;

	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;

	@Override
	public final String execute() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> moduleSession = (Map<String, Object>) sessionMap
					.get(GeneralConstants.MODULE_SESSION);
			if (moduleSession == null) {
				moduleSession = new ConcurrentHashMap<String, Object>();
				sessionMap.put(GeneralConstants.MODULE_SESSION, moduleSession);
			}

			String initial = request.getParameter("initial");
			if (initial.trim().equalsIgnoreCase("true")) {
				moduleSession.clear();
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> getModuleSession() {
		return (Map<String, Object>) sessionMap
				.get(GeneralConstants.MODULE_SESSION);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public SessionMap<String, Object> getSession() {
		return sessionMap;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public final void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
}
