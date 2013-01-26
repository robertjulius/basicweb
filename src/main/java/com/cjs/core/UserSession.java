package com.cjs.core;

public interface UserSession {
	public User getUser() throws CJSException;

	public void registerToHttpSession() throws CJSException;

	public void setUser(User user) throws CJSException;
}
