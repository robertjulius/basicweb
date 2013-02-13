package com.cjs.basicweb.modules.module.logic;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.model.module.ModuleDao;
import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.core.exception.AppException;

public class ModuleBL {

	private ModuleDao moduleDao;

	public ModuleBL() {
		moduleDao = new ModuleDao();
	}

	public Module getDetail(String moduleId) throws AppException {
		Module module = moduleDao.getDetail(moduleId);
		return module;
	}

	public void search(ModuleForm form) {
		form.setSearchResult(moduleDao.getList(form.getSearchName(),
				form.getSearchFirstEntry(), form.getSearchParentId()));
	}

	public List<Item> getItems(String id) {
		List<Item> items = new ArrayList<>();
		List<Module> modules = moduleDao.getList(null, null, null);
		for (Module module : modules) {
			if (module.getId().equals(id)) {
				continue;
			} else {
				items.add(new Item(module.getId(), module.getName()));
			}
		}
		return items;
	}

	public void validateForm() {

	}
}
