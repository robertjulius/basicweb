package com.cjs.basicweb.base;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DefaultHttpSessionListener implements HttpSessionListener {

	//private SessionManager sessionManager;

	public void sessionCreated(HttpSessionEvent se) {
//		HttpSession httpSession = se.getSession();
//		try {
//			if (sessionManager == null) {
//				registerSessionManager(se.getSession().getServletContext());
//			}
//			sessionManager.registerHttpSession(httpSession);
//		} catch (CJSException e) {
//			LoggerFactory.getLogger(getClass()).error(e.getMessage(), e);
//		} finally {
//			LoggerFactory.getLogger(getClass()).info(
//					"HttpSession '" + httpSession + "' with ID '"
//							+ httpSession.getId() + "' created");
//		}
	}

	public void sessionDestroyed(HttpSessionEvent se) {
//		HttpSession httpSession = se.getSession();
//		String sessionId = httpSession.getId();
//		try {
//			if (sessionManager == null) {
//				registerSessionManager(se.getSession().getServletContext());
//			}
//			sessionManager.unregisterHttpSession(sessionId);
//		} catch (CJSException e) {
//			LoggerFactory.getLogger(getClass()).error(e.getMessage(), e);
//		} finally {
//			LoggerFactory.getLogger(getClass()).info(
//					"HttpSession '" + httpSession + "' with ID '" + sessionId
//							+ "' destroyed");
//		}
	}

	private void registerSessionManager(ServletContext context) {
//		sessionManager = (SessionManager) WebApplicationContextUtils
//				.getWebApplicationContext(context).getBean("sessionManager");

	}
}
