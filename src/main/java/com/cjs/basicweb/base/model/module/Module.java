package com.cjs.basicweb.base.model.module;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.cjs.basicweb.base.model.Trackable;
import com.cjs.basicweb.base.model.accesspath.AccessPath;
import com.cjs.basicweb.base.model.usergroup.UserGroup;

@Entity
@Table(name = "ms_module")
public class Module extends Trackable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	private String description;

	@Column(unique = true)
	private String action;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Module parent;

	@OneToMany(mappedBy = "parent")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Module> childs;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public List<Module> getChilds() {
		return childs;
	}

	public void setChilds(List<Module> childs) {
		this.childs = childs;
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
