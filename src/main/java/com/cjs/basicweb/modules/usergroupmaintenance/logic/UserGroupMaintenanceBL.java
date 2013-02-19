package com.cjs.basicweb.modules.usergroupmaintenance.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.model.usergroup.UserGroup;
import com.cjs.basicweb.modules.BusinessLogic;
import com.cjs.core.exception.AppException;

public class UserGroupMaintenanceBL extends BusinessLogic {

	public void create(String id, String newName, String newDescription,
			List<String> newModules) throws AppException {

		beginTransaction();

		UserGroup userGroup = new UserGroup();
		userGroup.setName(newName);
		userGroup.setDescription(newDescription);

		userGroup.getModules().clear();
		for (String moduleId : newModules) {
			Module module = (Module) getSession().load(Module.class, moduleId);
			userGroup.getModules().add(module);
		}

		getSession().save(userGroup);
		commit();
	}

	public List<Module> getChildModules() {
		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.or(Restrictions.isNull("childs"),
				Restrictions.isEmpty("childs")));

		@SuppressWarnings("unchecked")
		List<Module> modules = criteria.list();
		return modules;
	}

	public UserGroup getDetail(String userGroupId) throws AppException {
		UserGroup userGroup = (UserGroup) getSession().get(UserGroup.class,
				userGroupId);
		return userGroup;
	}

	public List<Module> getRootModules() {
		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.isNull("parent.id"));

		@SuppressWarnings("unchecked")
		List<Module> modules = criteria.list();
		return modules;
	}

	public List<UserGroup> search(String name, String description) {
		Criteria criteria = getSession().createCriteria(UserGroup.class);
		if (name != null && !name.trim().isEmpty()) {
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}

		if (description != null && !description.trim().isEmpty()) {
			criteria.add(Restrictions.like("description", "%" + description
					+ "%"));
		}

		@SuppressWarnings("unchecked")
		List<UserGroup> userGroups = criteria.list();
		return userGroups;
	}

	public void update(String id, String newName, String newDescription,
			List<String> newModules) throws AppException {

		beginTransaction();

		UserGroup userGroup = (UserGroup) getSession()
				.load(UserGroup.class, id);
		userGroup.setName(newName);
		userGroup.setDescription(newDescription);

		userGroup.getModules().clear();
		for (String moduleId : newModules) {
			Module module = (Module) getSession().load(Module.class, moduleId);
			userGroup.getModules().add(module);
		}

		getSession().save(userGroup);
		commit();
	}
}
