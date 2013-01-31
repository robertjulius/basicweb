package com.cjs.basicweb.testhibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cjs.basicweb.base.model.module.Module;
import com.cjs.basicweb.base.model.module.ModuleDao;
import com.cjs.basicweb.testmenu.TestGenerateMenu;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.opensymphony.xwork2.ActionSupport;

public class TestHibernateAction extends ActionSupport {

	private static final long serialVersionUID = 7984761719326443248L;

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	private ModuleDao moduleDao = new ModuleDao();
	
	@Override
	public String execute() throws Exception {
		List<Module> modules = moduleDao.getList();
		TestGenerateMenu.setModules(modules);
		TestGenerateMenu.generateHtmlMenu();
		String htmlMenu = TestGenerateMenu.getHtmlMenu();
		System.out.println(htmlMenu);
		return SUCCESS;
	}
}
