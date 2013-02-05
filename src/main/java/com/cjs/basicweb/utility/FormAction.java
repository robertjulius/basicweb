package com.cjs.basicweb.utility;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class FormAction<T> extends ActionSupport implements SessionAware,
		ServletRequestAware, ModelDriven<T> {

	private static final long serialVersionUID = -3643549719278354411L;

	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;

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
