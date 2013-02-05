package com.cjs.basicweb.modules.login.form;

import com.cjs.basicweb.model.FormBean;

public class LoginForm implements FormBean {

	private String userId;
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
