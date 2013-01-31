package com.cjs.basicweb.base.model.module;

import java.util.List;

import com.cjs.basicweb.base.model.GenericDao;

public class ModuleDao extends GenericDao<Module> {

	@SuppressWarnings("unchecked")
	public List<Module> getList() {	
		List<Module> courses = null;
		try {
			courses = session.createQuery("from Module").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
	
}
