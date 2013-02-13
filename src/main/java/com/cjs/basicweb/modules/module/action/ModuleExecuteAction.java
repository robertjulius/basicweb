package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.model.accesspath.AccessPath;
import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ModuleExecuteAction extends FormAction<ModuleForm> {

	private static final long serialVersionUID = 8114275581397242184L;

	private List<String> listAccessPaths;

	public ModuleExecuteAction() throws AppException {
		super(ModuleForm.class);
	}

	public String confirmEdit() {
		getForm().setNewAccessPaths(new ArrayList<AccessPath>());
		for (String url : listAccessPaths) {
			if (url == null) {
				continue;
			}
			AccessPath accessPath = new AccessPath();
			accessPath.setUrl(url);
			/*
			 * TODO accessPath.setModule();
			 */
			getForm().getNewAccessPaths().add(accessPath);
		}
		return SUCCESS;
	}

	public String confirmNew() {
		return SUCCESS;
	}

	public List<String> getListAccessPaths() {
		return listAccessPaths;
	}

	public void setListAccessPaths(List<String> listAccessPaths) {
		this.listAccessPaths = listAccessPaths;
	}
}
