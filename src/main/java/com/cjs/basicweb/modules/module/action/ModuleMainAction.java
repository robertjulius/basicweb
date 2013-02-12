package com.cjs.basicweb.modules.module.action;

import java.util.List;

import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleMainAction extends FormAction<ModuleForm> {

	private static final long serialVersionUID = 8114275581397242184L;

	private ModuleBL moduleBL;

	public ModuleMainAction() {
		super(ModuleForm.class);
		moduleBL = new ModuleBL();
	}

	public String initial() {
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		String selectedId = getForm().getSelectedId();
		Module module = moduleBL.getDetail(selectedId);
		getForm().setSelected(module);
		return SUCCESS;
	}

	public String prepareEdit() throws AppException {
		List<Item> items = moduleBL.getItems(getForm().getSelectedId());
		getForm().setListParent(items);
		getForm().assignFromEntity("new", getForm().getSelected());
		return SUCCESS;
	}

	public String prepareNew() {
		return SUCCESS;
	}

	public String search() {
		moduleBL.search(getForm());
		return SUCCESS;
	}
}
