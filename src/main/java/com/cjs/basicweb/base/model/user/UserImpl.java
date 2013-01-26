package com.cjs.basicweb.base.model.user;

import com.cjs.core.User;

public class UserImpl implements User {

	private String userId;

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
