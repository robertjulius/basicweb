package com.cjs.struts2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cjs.basicweb.model.activitylog.ActivityLog;
import com.cjs.basicweb.model.user.SimpleUser;
import com.cjs.basicweb.modules.BusinessLogic;
import com.cjs.basicweb.modules.ModuleSession;
import com.cjs.basicweb.utility.CommonUtils;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.basicweb.utility.GeneralConstants.ActionType;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.utils.MappingUtils;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction<T> extends ActionSupport implements
		SessionAware, ServletRequestAware {

	private static final long serialVersionUID = -3643549719278354411L;

	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;
	private T logic;

	public BaseAction(Class<T> clazz) throws AppException {
		try {
			if (BusinessLogic.class.isAssignableFrom(clazz)) {
				this.logic = clazz.newInstance();
			} else {
				throw new AppException(
						PropertiesConstants.ERROR_CREATE_BUSINESS_LOGIC);
			}
		} catch (InstantiationException e) {
			throw new AppException(
					PropertiesConstants.ERROR_CREATE_BUSINESS_LOGIC);
		} catch (IllegalAccessException e) {
			throw new AppException(
					PropertiesConstants.ERROR_CREATE_BUSINESS_LOGIC);
		}
	}

	public final String chainAction() {
		return SUCCESS;
	}

	public T getBL() {
		return logic;
	}

	public ModuleSession getModuleSession() {
		return (ModuleSession) sessionMap.get(GeneralConstants.MODULE_SESSION);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public SessionMap<String, Object> getSession() {
		return sessionMap;
	}

	public UserSession getUserSession() {
		return (UserSession) getSession().get(GeneralConstants.USER_SESSION);
	}

	public final String redirectAction() {
		return SUCCESS;
	}

	public final void saveActivityLog(ActionType actionType,
			Object affectedObject) throws AppException {
		String description = MappingUtils.getObjectValues(affectedObject);
		saveActivityLog(actionType, description);
	}

	public final void saveActivityLog(ActionType actionType, String description)
			throws AppException {

		SimpleUser user = (SimpleUser) getUserSession().getUser();

		ActivityLog log = new ActivityLog();
		log.setUser(user.getId());
		log.setUserId(user.getUserId());
		log.setUserName(user.getName());
		log.setActionClass(this.getClass().getSimpleName());
		log.setActionType(String.valueOf(actionType));
		log.setDescription(description);
		log.setActionDate(CommonUtils.getCurrentTimestamp());

		BusinessLogic businessLogic = (BusinessLogic) getBL();
		businessLogic.beginTransaction();
		businessLogic.getSession().save(log);
		businessLogic.commit();
	}

	@Override
	public final void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public final void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
}
