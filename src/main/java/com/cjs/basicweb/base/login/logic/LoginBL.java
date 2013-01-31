package com.cjs.basicweb.base.login.logic;

import java.util.List;

import com.cjs.basicweb.base.model.module.Module;
import com.cjs.basicweb.base.model.module.ModuleDao;
import com.cjs.basicweb.base.model.user.UserDao;
import com.cjs.basicweb.utility.HtmlMenuGenerator;
import com.cjs.core.User;
import com.cjs.core.exception.UserException;

public class LoginBL {

	private UserDao userDao;
	private ModuleDao moduleDao = new ModuleDao();

	public LoginBL(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getHtmlMenu() {
		List<Module> modules = moduleDao.getParents();
		String htmlMenu = HtmlMenuGenerator.generateHtmlMenu(modules);
		return htmlMenu;
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
