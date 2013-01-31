package com.cjs.basicweb.base;

import com.cjs.basicweb.base.login.logic.LoginBL;
import com.opensymphony.xwork2.ActionSupport;

public class LeftFrameAction extends ActionSupport {
	private static final long serialVersionUID = -3643549719278354411L;

	private LoginBL loginBL;

	public LeftFrameAction(LoginBL loginBL) {
		this.loginBL = loginBL;
	}

	public String getHtmlMenu() {
		return loginBL.getHtmlMenu();
	}
}
