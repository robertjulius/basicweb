package com.cjs.basicweb.modules.login.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.cjs.basicweb.model.accesspath.AccessPath;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.model.module.ModuleDao;
import com.cjs.basicweb.model.user.SimpleUser;
import com.cjs.basicweb.model.user.UserDao;
import com.cjs.basicweb.modules.login.Privilege;
import com.cjs.basicweb.modules.login.PrivilegeUtils;
import com.cjs.basicweb.modules.login.usersession.SimpleUserSession;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class LoginBL {

	private ModuleDao moduleDao;
	private UserDao userDao;

	public LoginBL() {
		moduleDao = new ModuleDao();
		userDao = new UserDao();
	}

	public User performLogin(String userId, String password,
			UserSession userSession) throws UserException, AppException {
		User user = userDao.getDetail(userId);
		if (user == null) {
			throw new UserException(PropertiesConstants.INVALID_LOGIN_USERID);
		}

		validatePassword(user, password);
		prepareTreeMenu(user, userSession);
		setAccessPath(user, userSession);

		return user;
	}

	private void prepareTreeMenu(User user, UserSession userSession) {

		List<Module> modules = ((SimpleUser) user).getUserGroup().getModules();

		List<String> privilegeIds = new ArrayList<>();
		for (Module module : modules) {
			privilegeIds.add(module.getId());
		}

		TreeMap<String, Privilege> treeMap = PrivilegeUtils.generateTree(
				privilegeIds.toArray(new String[] {}), moduleDao.getParents());

		((SimpleUserSession) userSession).setTreeMap(treeMap);
	}

	private void setAccessPath(User user, UserSession userSession) {

		Map<String, String> map = ((SimpleUserSession) userSession)
				.getAccessPath();

		List<Module> modules = ((SimpleUser) user).getUserGroup().getModules();
		for (Module module : modules) {
			List<AccessPath> accessPaths = module.getAccessPaths();
			for (AccessPath accessPath : accessPaths) {
				map.put(accessPath.getUrl(), accessPath.getModule().getId());
			}
		}

	}

	private void validatePassword(User user, String password)
			throws UserException {

		if (!user.getPassword().equals(password)) {
			throw new UserException(PropertiesConstants.INVALID_LOGIN_PASSWORD);
		}
	}
}
