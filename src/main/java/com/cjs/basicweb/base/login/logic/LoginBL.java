package com.cjs.basicweb.base.login.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.cjs.basicweb.applets.Privilege;
import com.cjs.basicweb.applets.PrivilegeUtils;
import com.cjs.basicweb.base.model.module.Module;
import com.cjs.basicweb.base.model.module.ModuleDao;
import com.cjs.basicweb.base.model.user.UserDao;
import com.cjs.basicweb.base.model.user.UserDaoImpl;
import com.cjs.basicweb.base.model.user.UserImpl;
import com.cjs.basicweb.base.model.usersession.UserSessionImpl;
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
		prepareTreeMenu((UserImpl) user, userSession);
		registerUserSession(user, userSession);

		return user;
	}

	private void prepareTreeMenu(UserImpl user, UserSession userSession) {

		List<Module> modules = user.getUserGroup().getModules();

		List<String> privilegeIds = new ArrayList<>();
		for (Module module : modules) {
			privilegeIds.add(module.getId());
		}

		TreeMap<String, Privilege> treeMap = PrivilegeUtils.generateTree(
				privilegeIds.toArray(new String[] {}), moduleDao.getParents());

		// TreeMap<String, Privilege> treeMap =
		// HtmlMenuGenerator.generateTreeMap(
		// ((UserImpl) user).getUserGroup().getModules(),
		// moduleDao.getParents());

		((UserSessionImpl) userSession).setTreeMap(treeMap);
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
