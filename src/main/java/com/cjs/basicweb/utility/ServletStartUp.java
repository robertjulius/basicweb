package com.cjs.basicweb.utility;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cjs.core.exception.AppException;

public class ServletStartUp extends HttpServlet {
	private static final long serialVersionUID = -789475497301128186L;

	public ServletStartUp() {
		/*
		 * 
		 */
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			AppContextManager.reload(config.getServletContext());
		} catch (AppException e) {
			throw new ServletException(e.getMessage());
		}
	}
}
