package com.cjs.basicweb.utility;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cjs.core.UserSessionManager;
import com.cjs.core.exception.AppException;

public class AppContextManager {

	private static AppContextManager instance;

	private UserSessionManager userSessionManager;
	private PageFail pageFail;

	public static PageFail getPageFail() {
		return instance.pageFail;
	}

	public static UserSessionManager getUserSessionManager() {
		return instance.userSessionManager;
	}

	public static void reload(ServletContext context) throws AppException {
		if (instance == null) {
			instance = new AppContextManager();

			WebApplicationContext webAppContext = WebApplicationContextUtils
					.getWebApplicationContext(context);

			instance.userSessionManager = (UserSessionManager) webAppContext
					.getBean("userSessionManager");

			instance.pageFail = (PageFail) webAppContext.getBean("pageFail");

		} else {
			throw new AppException(PropertiesConstants.ERROR_APPCONFIG_RELOAD);
		}
	}
}
