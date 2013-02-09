package com.cjs.basicweb.modules.module.logic;

import com.cjs.basicweb.model.module.ModuleDao;
import com.cjs.basicweb.modules.module.form.ModuleForm;

public class ModuleBL {

	private ModuleDao moduleDao;

	public ModuleBL() {
		moduleDao = new ModuleDao();
	}

	public void search(ModuleForm form) {
		form.setModules(moduleDao.getList(form.getSearchId(),
				form.getSearchName(), form.getSearchFirstEntry(),
				form.getSearchParentId()));
	}
}
