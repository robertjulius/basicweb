package com.cjs.basicweb.modules.module;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.accesspath.AccessPath;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.BusinessLogic;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.basicweb.utility.PropertiesConstants;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class ModuleBL extends BusinessLogic {

	public Module create(String newFirstEntry, String newName,
			String newDescription, String newParentId,
			List<String> newAccesssPaths, String createBy, Timestamp createDate)
			throws AppException {

		beginTransaction();

		Module module = new Module();
		if (newFirstEntry != null && newFirstEntry.trim().isEmpty()) {
			newFirstEntry = null;
		}
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

		return module;
	}

	public void delete(String id) throws UserException, AppException {
		checkDependencyToMsPrivilege(id);

		beginTransaction();

		Module module = (Module) getSession().load(Module.class, id);
		recursiveDelete(module);

		commit();
	}

	public List<Module> getAllModules(String id) throws AppException {
		Criteria criteria = getSession().createCriteria(Module.class);

		@SuppressWarnings("unchecked")
		List<Module> modules = criteria.list();
		return modules;
	}

	public Module getDetail(String moduleId) throws AppException {
		Module module = (Module) getSession().get(Module.class, moduleId);
		return module;
	}

	public List<Module> search(String name, String firstEntry, String parentId)
			throws AppException {
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

	public Module update(String id, String newFirstEntry, String newName,
			String newDescription, String newParentId,
			List<String> newAccesssPaths, String updateBy, Timestamp updateDate)
			throws AppException {

		beginTransaction();

		Module module = (Module) getSession().load(Module.class, id);
		if (newFirstEntry != null && newFirstEntry.trim().isEmpty()) {
			newFirstEntry = null;
		}
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

		return module;
	}

	private void checkDependencyToMsPrivilege(String moduleId)
			throws UserException, AppException {
		SQLQuery sqlQuery = getSession()
				.createSQLQuery(
						"select COUNT(1) FROM ms_privilege WHERE module_id = :moduleId");
		sqlQuery.setString("moduleId", moduleId);
		BigInteger count = (BigInteger) sqlQuery.list().get(0);
		if (count.intValue() > 0) {
			throw new UserException(
					PropertiesConstants.MODULE_MAINTENANCE_DELETE_FAILED_DEPENDENCY_ACCESSPATH);
		}
	}

	private void deleteMsAccessPath(String moduleId) throws AppException {
		SQLQuery sqlQuery = getSession().createSQLQuery(
				"DELETE FROM ms_access_path WHERE module_id = :moduleId");
		sqlQuery.setString("moduleId", moduleId);
		sqlQuery.executeUpdate();
	}

	private void recursiveDelete(Module module) throws UserException,
			AppException {
		if (!module.getChilds().isEmpty()) {
			List<Module> childs = module.getChilds();
			for (Module child : childs) {
				recursiveDelete(child);
			}
		}
		deleteMsAccessPath(module.getId());
		getSession().delete(module);
	}
}