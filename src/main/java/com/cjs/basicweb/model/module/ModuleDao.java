package com.cjs.basicweb.model.module;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.GenericDao;

public class ModuleDao extends GenericDao<Module> {

	public ModuleDao() {
		super(Module.class);
	}

	public List<Module> getList(String name, String firstEntry, String parentId) {

		Criteria criteria = getSession().createCriteria(Module.class);

		if (name != null && !name.trim().isEmpty()) {
			criteria.add(Restrictions.like("name", "%" + name + "%"));
		}

		if (firstEntry != null && !firstEntry.trim().isEmpty()) {
			criteria.add(Restrictions
					.like("firstEntry", "%" + firstEntry + "%"));
		}

		if (parentId != null && !parentId.trim().isEmpty()) {
			criteria.add(Restrictions.like("parent.id", "%" + parentId + "%"));
		}

		@SuppressWarnings("unchecked")
		List<Module> modules = criteria.list();
		return modules;
	}

	public List<Module> getRoots() {
		@SuppressWarnings("unchecked")
		List<Module> modules = getSession().createQuery(
				"from Module where parent = null").list();
		return modules;
	}
}
