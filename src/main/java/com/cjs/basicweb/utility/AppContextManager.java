package com.cjs.basicweb.utility;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cjs.core.UserSessionManager;

public class AppContextManager {

	private static UserSessionManager userSessionManager;

	static {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		userSessionManager = (UserSessionManager) appContext
				.getBean("userSessionManager");
	}

	public static UserSessionManager getUserSessionManager() {
		return userSessionManager;
	}
}
