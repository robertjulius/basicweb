package com.cjs.basicweb.base.model.usergroup;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cjs.basicweb.base.model.Trackable;
import com.cjs.basicweb.base.model.module.Module;
import com.cjs.core.User;

@Table(name = "ms_user_group")
public class UserGroup extends Trackable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(unique = true, nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "ms_privilege", joinColumns = @JoinColumn(name = "user_group_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))
	private List<Module> modules;

	@OneToMany(mappedBy = "userGroups")
	private List<User> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
