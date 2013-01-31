package com.cjs.basicweb.base.login.action;

import com.cjs.basicweb.base.login.logic.LoginBL;
import com.cjs.basicweb.base.model.module.ModuleDao;
import com.cjs.basicweb.testmenu.TestGenerateMenu;
import com.cjs.core.User;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginMainAction extends ActionSupport {
	private static final long serialVersionUID = -3643549719278354411L;

	private LoginBL loginBL;
	private User user;
	private ModuleDao moduleDao = new ModuleDao();

	public LoginMainAction(LoginBL loginBL) {
		this.loginBL = loginBL;
	}

	@Override
	public String execute() {
		TestGenerateMenu.setModules(moduleDao.getList());
		TestGenerateMenu.generateHtmlMenu();
		System.out.println(TestGenerateMenu.getHtmlMenu());
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public String prepare() {
		return INPUT;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
