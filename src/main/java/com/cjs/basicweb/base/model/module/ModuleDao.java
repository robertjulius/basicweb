package com.cjs.basicweb.base.model.module;

import java.util.List;

import com.cjs.basicweb.base.model.GenericDao;

public class ModuleDao extends GenericDao<Module> {

	@SuppressWarnings("unchecked")
	public List<Module> getParents() {
		List<Module> modules = null;
		try {
			modules = session.createQuery("from Module where parent = null")
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modules;
	}

}
