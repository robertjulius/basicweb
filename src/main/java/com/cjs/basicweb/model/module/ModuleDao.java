package com.cjs.basicweb.model.module;

import java.util.List;

import com.cjs.basicweb.model.GenericDao;

public class ModuleDao extends GenericDao<Module> {

	public List<Module> getList(String id, String name, String action,
			String parent) {
		@SuppressWarnings("unchecked")
		List<Module> modules = session.createQuery("from Module module").list();
		return modules;
	}

	public List<Module> getParents() {
		@SuppressWarnings("unchecked")
		List<Module> modules = session.createQuery(
				"from Module where parent = null").list();
		return modules;
	}

}
