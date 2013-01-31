package com.cjs.basicweb.base.model.user;

import javax.persistence.Column;
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
	private String id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "user_group_id")
	private UserGroup userGroup;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
	public String getUserId() {
		return id;
	}

	@Override
	public void setUserId(String userId) {
		setId(userId);		
	}
}
