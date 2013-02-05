package com.cjs.basicweb.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cjs.basicweb.model.Trackable;
import com.cjs.basicweb.model.usergroup.UserGroup;
import com.cjs.core.User;

@Entity
@Table(name = "ms_user")
public class SimpleUser extends Trackable implements User {

	private static final long serialVersionUID = -1218882314919256632L;

	@Id
	private String id;

	@Column(name = "user_id", unique = true, nullable = false)
	private String userId;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "user_group_id")
	private UserGroup userGroup;

	public String getFullName() {
		return fullName;
	}

	public String getId() {
		return id;
	}

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

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setId(String id) {
		this.id = id;
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
		setUserId(userId);
	}
}