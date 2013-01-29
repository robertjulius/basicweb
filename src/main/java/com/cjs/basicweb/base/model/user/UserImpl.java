package com.cjs.basicweb.base.model.user;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cjs.basicweb.base.model.Trackable;
import com.cjs.basicweb.base.model.usergroup.UserGroup;
import com.cjs.core.User;

@Table(name = "ms_user")
public class UserImpl extends Trackable implements User {

	private static final long serialVersionUID = -1218882314919256632L;

	private String userId;

	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "user_group_id")
	private UserGroup userGroup;

	public String getPassword() {
		return password;
	}

	public String getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
}
