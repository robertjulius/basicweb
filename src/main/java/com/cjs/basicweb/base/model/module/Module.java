package com.cjs.basicweb.base.model.module;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cjs.basicweb.base.model.Trackable;
import com.cjs.basicweb.base.model.accesspath.AccessPath;
import com.cjs.basicweb.base.model.usergroup.UserGroup;

@Table(name = "ms_module")
public class Module extends Trackable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "module_name", unique = true, nullable = false)
	private String moduleName;

	private String description;

	@OneToMany(mappedBy = "module")
	private List<AccessPath> accessPaths;

	@ManyToMany(mappedBy = "modules")
	private List<UserGroup> userGroups;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AccessPath> getAccessPaths() {
		return accessPaths;
	}

	public void setAccessPaths(List<AccessPath> accessPaths) {
		this.accessPaths = accessPaths;
	}

	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
}
