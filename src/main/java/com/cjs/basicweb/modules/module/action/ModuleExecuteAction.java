package com.cjs.basicweb.modules.module.action;

import java.util.List;

import com.cjs.basicweb.modules.module.form.ModuleForm;
import com.cjs.struts2.FormAction;

public class ModuleExecuteAction extends FormAction<ModuleForm> {

	private static final long serialVersionUID = 8114275581397242184L;
	
	private List<String> listAccessPaths;

	public ModuleExecuteAction() {
		super(ModuleForm.class);
	}

	public String confirmEdit() {
		for (String accessPath : listAccessPaths) {
			System.out.println(accessPath);
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
