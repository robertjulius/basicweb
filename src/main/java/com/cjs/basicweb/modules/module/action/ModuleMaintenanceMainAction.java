package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.model.accesspath.AccessPath;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleMaintenanceMainAction extends
		FormAction<ModuleForm, ModuleBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleMaintenanceMainAction() throws AppException {
		super(ModuleForm.class, ModuleBL.class);
	}

	public String initial() {
		ModuleForm form = getForm();
		List<Module> modules = getBL().getAllModules(form.getSelectedId());
		modules.add(0, new Module());
		form.setSelectListParent(modules);
		return SUCCESS;
	}

	public String search() {
		String name = getForm().getSearchName();
		String firstEntry = getForm().getSearchFirstEntry();
		String parentId = getForm().getSearchParentId();

		List<Module> modules = getBL().search(name, firstEntry, parentId);
		getForm().setSearchResult(modules);
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		String selectedId = getForm().getSelectedId();

		Module module = getBL().getDetail(selectedId);
		ModuleForm form = getForm();
		form.setOld(module);

		if (form.getNewURLs() == null) {
			form.setNewURLs(new ArrayList<String>());
		} else {
			form.getNewURLs().clear();
		}

		for (AccessPath accessPath : module.getAccessPaths()) {
			form.getNewURLs().add(accessPath.getUrl());
		}

		return SUCCESS;
	}
}
