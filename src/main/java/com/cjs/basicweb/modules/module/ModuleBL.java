package com.cjs.basicweb.modules.module;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.accesspath.AccessPath;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.BusinessLogic;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.core.exception.AppException;

public class ModuleBL extends BusinessLogic {

	public void create(String newFirstEntry, String newName,
			String newDescription, String newParentId,
			List<String> newAccesssPaths, String createBy, Timestamp createDate)
			throws AppException {

		beginTransaction();

		Module module = new Module();
		module.setFirstEntry(newFirstEntry);
		module.setName(newName);
		module.setDescription(newDescription);
		module.setCreateBy(createBy);
		module.setCreateDate(createDate);
		module.setUpdateBy(createBy);
		module.setUpdateDate(createDate);
		module.setRecStatus(GeneralConstants.REC_STATUS_ACTIVE);

		if (newParentId == null || newParentId.trim().isEmpty()) {
			module.setParent(null);
		} else {
			Module parent = (Module) getSession().load(Module.class,
					newParentId);
			module.setParent(parent);
		}

		for (String url : newAccesssPaths) {
			AccessPath accessPath = new AccessPath();
			accessPath.setModule(module);
			accessPath.setUrl(url);
			getSession().save(accessPath);
		}

		getSession().save(module);
		commit();
	}

	public void delete(String id) {
		beginTransaction();
		deleteMsAccessPath(id);
		Module module = (Module) getSession().load(Module.class, id);
		getSession().delete(module);
		commit();
	}

	public List<Module> getAllModules(String id) {
		Criteria criteria = getSession().createCriteria(Module.class);

		@SuppressWarnings("unchecked")
		List<Module> modules = criteria.list();
		return modules;
	}

	public Module getDetail(String moduleId) throws AppException {
		Module module = (Module) getSession().get(Module.class, moduleId);
		return module;
	}

	public List<Module> search(String name, String firstEntry, String parentId) {
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

	public void update(String id, String newFirstEntry, String newName,
			String newDescription, String newParentId,
			List<String> newAccesssPaths, String updateBy, Timestamp updateDate)
			throws AppException {

		beginTransaction();

		Module module = (Module) getSession().load(Module.class, id);
		module.setFirstEntry(newFirstEntry);
		module.setName(newName);
		module.setDescription(newDescription);
		module.setUpdateBy(updateBy);
		module.setUpdateDate(updateDate);

		if (newParentId == null || newParentId.trim().isEmpty()) {
			module.setParent(null);
		} else {
			Module parent = (Module) getSession().load(Module.class,
					newParentId);
			module.setParent(parent);
		}

		deleteMsAccessPath(id);
		for (String url : newAccesssPaths) {
			AccessPath accessPath = new AccessPath();
			accessPath.setModule(module);
			accessPath.setUrl(url);
			getSession().save(accessPath);
		}

		getSession().save(module);
		commit();
	}

	private void deleteMsAccessPath(String moduleId) {
		SQLQuery sqlQuery = getSession().createSQLQuery(
				"DELETE FROM ms_access_path WHERE module_id = :moduleId");
		sqlQuery.setString("moduleId", moduleId);
		sqlQuery.executeUpdate();
	}
}
