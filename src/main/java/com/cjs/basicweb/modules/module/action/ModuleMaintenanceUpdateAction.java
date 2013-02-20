package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.basicweb.modules.module.logic.ModuleBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleMaintenanceUpdateAction extends
		FormAction<ModuleForm, ModuleBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	private List<String> listAccessPaths;

	public ModuleMaintenanceUpdateAction() throws AppException {
		super(ModuleForm.class, ModuleBL.class);
	}

	public String executeUpdate() throws AppException {
		ModuleForm form = getForm();
		getBL().update(form.getSelectedId(), form.getNewFirstEntry(),
				form.getNewName(), form.getNewDescription(),
				form.getNewParentId(), form.getNewURLs());
		return SUCCESS;
	}

	public List<String> getListAccessPaths() {
		return listAccessPaths;
	}

	public String prepareUpdate() throws AppException {
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

	public void setListAccessPaths(List<String> listAccessPaths) {
		this.listAccessPaths = listAccessPaths;
	}

	public String validateUpdate() throws AppException {
		if (validateForm()) {
			getForm().setNewURLs(new ArrayList<String>());
			for (String url : listAccessPaths) {
				if (url == null || url.trim().isEmpty()) {
					continue;
				}
				getForm().getNewURLs().add(url);
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
