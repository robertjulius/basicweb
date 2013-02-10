package com.cjs.basicweb.modules.module.logic;

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
		form.setModules(moduleDao.getList(form.getSearchId(),
				form.getSearchName(), form.getSearchFirstEntry(),
				form.getSearchParentId()));
	}
}
