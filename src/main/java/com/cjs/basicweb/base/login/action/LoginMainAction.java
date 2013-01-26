package com.cjs.basicweb.base.login.action;

import com.cjs.basicweb.base.login.logic.LoginBL;
import com.cjs.core.User;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginMainAction extends ActionSupport {
	private static final long serialVersionUID = -3643549719278354411L;

	private LoginBL loginBL;
	private User user;

	public LoginMainAction(LoginBL loginBL) {
		this.loginBL = loginBL;
	}

	@Override
	public String execute() {
		try {
			loginBL.validatePassword(user.getUserId(), user.getPassword());
			return SUCCESS;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return INPUT;
		}
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
