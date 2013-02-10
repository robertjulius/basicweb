package com.cjs.basicweb.model.module;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.GenericDao;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;

public class ModuleDao extends GenericDao<Module> {

	public Module getDetail(String id) throws AppException {
		if (id == null || id.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		Criteria criteria = session.createCriteria(Module.class);
		criteria.add(Restrictions.eq("id", id));
		return (Module) criteria.list().get(0);
	}

	public List<Module> getList(String id, String name, String firstEntry,
			String parentId) {

		Criteria criteria = session.createCriteria(Module.class);

		if (id != null && !id.trim().isEmpty()) {
			criteria.add(Restrictions.like("id", "%" + id + "%"));
		}

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

	public List<Module> getParents() {
		@SuppressWarnings("unchecked")
		List<Module> modules = session.createQuery(
				"from Module where parent = null").list();
		return modules;
	}

}
