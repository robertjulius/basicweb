package com.cjs.basicweb.base.logout.action;

import com.cjs.core.User;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutMainAction extends ActionSupport {
	private static final long serialVersionUID = -3643549719278354411L;

	private User user;

	@Override
	public String execute() {
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
