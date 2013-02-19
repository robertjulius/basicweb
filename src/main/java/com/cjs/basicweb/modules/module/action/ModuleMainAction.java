package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

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
		if (validateForm()) {
			getForm().setNewAccessPaths(new ArrayList<String>());
			for (String url : listAccessPaths) {
				if (url == null) {
					continue;
				}
				getForm().getNewAccessPaths().add(url);
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String confirmNew() throws AppException {
		return confirmEdit();
	}

	public String executeEdit() throws AppException {
		ModuleForm form = getForm();
		getBL().update(form.getSelectedId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewAccessPaths());
		return SUCCESS;
	}

	public String executeNew() throws AppException {
		ModuleForm form = getForm();
		getBL().create(form.getSelectedId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewAccessPaths());
		return SUCCESS;
	}

	public List<String> getListAccessPaths() {
		return listAccessPaths;
	}

	public String initial() {
		ModuleForm form = getForm();
		List<Module> modules = getBL().getAllModules(form.getSelectedId());
		modules.add(0, null);
		form.setSelectListParent(modules);
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

	public String prepareNew() throws AppException {
		ModuleForm form = getForm();
		form.assignFromEntity("new", new Module());

		form.setNewParentId(null);
		form.setNewParentName(null);

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
