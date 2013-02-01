package com.cjs.basicweb.base.login.logic;

import java.util.TreeMap;

import com.cjs.basicweb.applets.Privilege;
import com.cjs.basicweb.base.model.module.ModuleDao;
import com.cjs.basicweb.base.model.user.UserDao;
import com.cjs.basicweb.base.model.user.UserDaoImpl;
import com.cjs.basicweb.base.model.user.UserImpl;
import com.cjs.basicweb.base.model.usersession.UserSessionImpl;
import com.cjs.basicweb.utility.HtmlMenuGenerator;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.opensymphony.xwork2.ActionContext;

public class LoginBL {

	private ModuleDao moduleDao = new ModuleDao();
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
		
		TreeMap<String, Privilege> treeMap = HtmlMenuGenerator.generateTreeMap(
				((UserImpl) user).getUserGroup().getModules(),
				moduleDao.getParents());
		
		((UserSessionImpl) userSession).setTreeMap(treeMap);
		
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
