package com.cjs.basicweb.base.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cjs.basicweb.base.model.Trackable;
import com.cjs.basicweb.base.model.usergroup.UserGroup;
import com.cjs.core.User;

@Entity
@Table(name = "ms_user")
public class UserImpl extends Trackable implements User {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String userId;

	private String username;
	private String password;

	@ManyToOne
	@JoinColumn(name = "user_group_id")
	private UserGroup userGroup;

	@Override
	public String getPassword() {
		return password;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}
}
