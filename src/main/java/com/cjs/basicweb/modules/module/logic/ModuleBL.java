package com.cjs.basicweb.modules.module.logic;

import java.util.ArrayList;
import java.util.List;
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

public class ModuleBL {

	private ModuleDao moduleDao;

	public ModuleBL() {
		moduleDao = new ModuleDao();
	}
	
	public void checkDuplicate() {
		
	}

	public User performLogin(String userId, String password,
			UserSession userSession) throws UserException, AppException {
		User user = userDao.getDetail(userId);
		if (user == null) {
			throw new UserException(PropertiesConstants.INVALID_LOGIN_USERID);
		}

		validatePassword(user, password);
		prepareTreeMenu(user, userSession);
		((SimpleUserSession) userSession)
				.setAccessPath(prepareAccessPath(user));

		return user;
	}

	private String[] prepareAccessPath(User user) {
		List<String> result = new ArrayList<>();
		List<Module> modules = ((SimpleUser) user).getUserGroup().getModules();
		for (Module module : modules) {
			List<AccessPath> accessPaths = module.getAccessPaths();
			for (AccessPath accessPath : accessPaths) {
				result.add(accessPath.getUrl());
			}
		}
		return result.toArray(new String[] {});
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

	private void validatePassword(User user, String password)
			throws UserException {

		if (!user.getPassword().equals(password)) {
			throw new UserException(PropertiesConstants.INVALID_LOGIN_PASSWORD);
		}
	}
}
