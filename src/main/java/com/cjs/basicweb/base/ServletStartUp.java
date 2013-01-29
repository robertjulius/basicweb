package com.cjs.basicweb.base;

import javax.servlet.http.HttpServlet;

import com.cjs.TestHibernate;

public class ServletStartUp extends HttpServlet {
	private static final long serialVersionUID = -789475497301128186L;

	public ServletStartUp() {
		TestHibernate.main(null);
	}
}
