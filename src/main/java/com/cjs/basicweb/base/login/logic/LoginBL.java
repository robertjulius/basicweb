package com.cjs.basicweb.base.login.logic;

import com.cjs.basicweb.base.model.user.UserDao;
import com.cjs.core.User;
import com.cjs.core.exception.UserException;

public class LoginBL {

	private UserDao userDao;

	public LoginBL(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean validatePassword(String userId, String password)
			throws UserException {

		User user = userDao.getDetail(userId);

		if (!user.getPassword().equals(password)) {
			throw new UserException("password.invalid");
		}

		return true;
	}
}
