package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleMainAction extends FormAction<ModuleForm, ModuleBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	private List<String> listAccessPaths;

	public ModuleMainAction() throws AppException {
		super(ModuleForm.class, ModuleBL.class);
	}

	public String confirmEdit() throws AppException {
		getForm().setNewAccessPaths(new ArrayList<String>());
		for (String url : listAccessPaths) {
			if (url == null) {
				continue;
			}
			getForm().getNewAccessPaths().add(url);
		}
		return SUCCESS;
	}

	public String executeEdit() throws AppException {
		ModuleForm form = getForm();
		getBL().update(form.getNewId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewAccessPaths());
		return SUCCESS;
	}

	public List<String> getListAccessPaths() {
		return listAccessPaths;
	}

	public String initial() {
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		String selectedId = getForm().getSelectedId();
		Module module = getBL().getDetail(selectedId);
		getForm().setOld(module);
		return SUCCESS;
	}

	public String prepareEdit() throws AppException {
		ModuleForm form = getForm();

		List<Item> items = getBL().getItemsForSelectList(form.getSelectedId());
		form.setSelectListParent(items);

		form.assignFromEntity("new", form.getOld());

		if (form.getOld().getParent() != null) {
			form.setNewParentId(form.getOld().getParent().getId());
			form.setNewParentName(form.getOld().getParent().getName());
		} else {
			form.setNewParentId(null);
			form.setNewParentName(null);
		}

		return SUCCESS;
	}

	public String prepareNew() {
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

	public void setListAccessPaths(List<String> listAccessPaths) {
		this.listAccessPaths = listAccessPaths;
	}
}
