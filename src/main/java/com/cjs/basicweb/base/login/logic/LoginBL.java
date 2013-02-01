package com.cjs.basicweb.base.login.logic;

import com.cjs.basicweb.base.model.user.UserDao;
import com.cjs.basicweb.base.model.user.UserDaoImpl;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionContext;

public class LoginBL {

	private UserDao userDao = new UserDaoImpl();

	public User performLogin(String username, String password,
			UserSession userSession) throws UserException, AppException {
		User user = userDao.getDetail(username);

		validatePassword(user, username, password);
		registerUserSession(user, userSession);

		return user;
	}

	private void registerUserSession(User user, UserSession userSession)
			throws AppException, UserException {
		userSession.setUser(user);
		// userSession.registerToHttpSession();
		ActionContext.getContext().getSession().put("userSession", userSession);
	}

	private void validatePassword(User user, String username, String password)
			throws UserException {

		if (user == null) {
			throw new UserException("login.username.invalid");
		}

		if (!user.getPassword().equals(password)) {
			throw new UserException("login.password.invalid");
		}
	}
}
