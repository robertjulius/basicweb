package com.cjs.basicweb.modules.module.action;

import java.util.List;

import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.module.ModuleForm;
import com.cjs.core.exception.AppException;

public class ModuleMaintenanceMainAction extends ModuleMaintenanceAction {

	private static final long serialVersionUID = 8114275581397242184L;

	public ModuleMaintenanceMainAction() throws AppException {
		super();
	}

	public String initial() throws AppException {
		ModuleForm form = getForm();
		List<Module> modules = getBL().getAllModules(form.getSelectedId());
		modules.add(0, new Module());
		form.setSelectListParent(modules);
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		String selectedId = getForm().getSelectedId();

		Module module = getBL().getDetail(selectedId);
		ModuleForm form = getForm();
		form.setOld(module);

		return SUCCESS;
	}

	public String search() throws AppException {
		String name = getForm().getSearchName();
		String firstEntry = getForm().getSearchFirstEntry();
		String parentId = getForm().getSearchParentId();

		List<Module> modules = getBL().search(name, firstEntry, parentId);
		getForm().setSearchResult(modules);
		return SUCCESS;
	}
}
