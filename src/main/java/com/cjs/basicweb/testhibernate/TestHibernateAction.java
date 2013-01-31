package com.cjs.basicweb.testhibernate;

import com.cjs.basicweb.base.model.module.ModuleDao;
import com.opensymphony.xwork2.ActionSupport;

public class TestHibernateAction extends ActionSupport {

	private static final long serialVersionUID = 7984761719326443248L;

	private ModuleDao moduleDao = new ModuleDao();

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
