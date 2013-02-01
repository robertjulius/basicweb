package com.cjs.core;

import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public interface UserSession {
	public User getUser() throws AppException, UserException;

	public void registerToHttpSession() throws AppException, UserException;

	public void setUser(User user) throws AppException, UserException;
}
