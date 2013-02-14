package com.cjs.basicweb.model.module;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.GenericDao;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;

public class ModuleDao extends GenericDao {

	public Module getDetail(String id) throws AppException {

		if (id == null || id.trim().isEmpty()) {
			throw new AppException(
					PropertiesConstants.ERROR_PRIMARY_KEY_REQUIRED);
		}

		Criteria criteria = getSession().createCriteria(Module.class);
		criteria.add(Restrictions.eq("id", id));

		return (Module) criteria.uniqueResult();
	}

	public void create(Module module) {
		getSession().save(module);
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
