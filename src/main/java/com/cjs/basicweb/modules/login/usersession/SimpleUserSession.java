package com.cjs.basicweb.modules.login.usersession;

import java.util.TreeMap;

import com.cjs.basicweb.modules.login.Privilege;
import com.cjs.core.User;
import com.cjs.core.UserSession;

public class SimpleUserSession implements UserSession {

	private User user;
	private TreeMap<String, Privilege> treeMap;
	private String[] accessPath;

	public String[] getAccessPath() {
		return accessPath;
	}

	public TreeMap<String, Privilege> getTreeMap() {
		return treeMap;
	}

	@Override
	public User getUser() {
		return user;
	}

	public void setAccessPath(String[] accessPath) {
		this.accessPath = accessPath;
	}

	public void setTreeMap(TreeMap<String, Privilege> treeMap) {
		this.treeMap = treeMap;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}
}
