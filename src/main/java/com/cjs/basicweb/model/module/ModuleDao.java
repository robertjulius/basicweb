package com.cjs.basicweb.model.module;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

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

		return (Module) criteria.uniqueResult();
	}

	// public List<Module> getList(String name, String firstEntry, String
	// parentId) {
	//
	// Criteria criteria = session.createCriteria(Module.class);
	//
	// if (name != null && !name.trim().isEmpty()) {
	// criteria.add(Restrictions.like("name", "%" + name + "%"));
	// }
	//
	// if (firstEntry != null && !firstEntry.trim().isEmpty()) {
	// criteria.add(Restrictions
	// .like("firstEntry", "%" + firstEntry + "%"));
	// }
	//
	// if (parentId != null && !parentId.trim().isEmpty()) {
	// criteria.add(Restrictions.like("parent.id", "%" + parentId + "%"));
	// }
	//
	// @SuppressWarnings("unchecked")
	// List<Module> modules = criteria.list();
	// return modules;
	// }

	public List<Module> getList(String name, String firstEntry, String parentId) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("select module.id, module.name, module.description, module.firstEntry, module.parent.id, module.parent.name");
		stringBuilder.append(" from Module module where 1=1");

		if (name != null && !name.trim().isEmpty()) {
			stringBuilder.append(" and lower(module.name) like %" + name + "%");
		}

		if (firstEntry != null && !firstEntry.trim().isEmpty()) {
			stringBuilder.append(" and lower(module.firstEntry) like %lower("
					+ firstEntry + ")%");
		}

		if (parentId != null && !parentId.trim().isEmpty()) {
			stringBuilder.append(" and lower(module.parent.id) like %lower("
					+ parentId + ")%");
		}

		Query query = session.createQuery(stringBuilder.toString());
		
		query.setResultTransformer(Transformers.aliasToBean(Module.class));

		@SuppressWarnings("unchecked")
		List<Module> modules = query.list();
		return modules;
	}

	public List<Module> getRoots() {
		@SuppressWarnings("unchecked")
		List<Module> modules = session.createQuery(
				"from Module where parent = null").list();
		return modules;
	}

}
