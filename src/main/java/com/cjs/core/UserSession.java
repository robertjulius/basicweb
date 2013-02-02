package com.cjs.core;

import com.cjs.core.exception.AppException;

public interface UserSession {
	public User getUser() throws AppException;

	public void setUser(User user) throws AppException;
}
