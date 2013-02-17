package com.cjs.basicweb.modules.module.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.BusinessLogic;
import com.cjs.core.exception.AppException;

public class ModuleBL extends BusinessLogic {

	public Module getDetail(String moduleId) throws AppException {
		Module load = (Module) getSession().get(Module.class, moduleId);
		return load;
	}

	public List<Item> getItemsForSelectList(String id) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(null, null));

		Criteria criteria = getSession().createCriteria(Module.class);
		List<?> list = criteria.list();
		for (Object object : list) {
			Module module = (Module) object;
			if (module.getId().equals(id)) {
				continue;
			} else {
				items.add(new Item(module.getId(), module.getName()));
			}
		}
		return items;
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
			List<String> newAccesssPaths) throws AppException {

		beginTransaction();

		Module module = (Module) getSession().load(Module.class, id);
		module.setFirstEntry(newFirstEntry);
		module.setName(newName);
		module.setDescription(newDescription);
		module.setParent(null);

		getSession().save(module);
		commit();

		// accessPathDao.deleteByModuleId(module.getId());
		//
		// List<AccessPath> accessPaths = form.getNewAccessPaths();
		// for (AccessPath accessPath : accessPaths) {
		// accessPath.setModule(module);
		// accessPathDao.save(accessPath);
		// }
		//
		// Module parent = moduleDao.load(form.getSelectedParentId());
		// module.setParent(parent);

		// moduleDao.save(module);
	}
}
