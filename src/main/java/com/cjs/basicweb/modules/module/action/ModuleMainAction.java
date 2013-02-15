package com.cjs.basicweb.modules.module.action;

import java.util.ArrayList;
import java.util.List;

import com.cjs.basicweb.model.Item;
import com.cjs.basicweb.model.accesspath.AccessPath;
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

	public String confirmEdit() {
		getForm().setNewAccessPaths(new ArrayList<AccessPath>());
		for (String url : listAccessPaths) {
			if (url == null) {
				continue;
			}
			AccessPath accessPath = new AccessPath();
			accessPath.setUrl(url);
			getForm().getNewAccessPaths().add(accessPath);
		}
		getBL().setParent(getForm());
		return SUCCESS;
	}

	public String executeEdit() throws AppException {
		getBL().update(getForm());
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
		getForm().setSelectedParentId(module.getParent().getId());
		return SUCCESS;
	}

	public String prepareEdit() throws AppException {
		List<Item> items = getBL().getItems(getForm().getSelectedId());
		getForm().setSelectListParent(items);
		getForm().assignFromEntity("new", getForm().getOld());
		return SUCCESS;
	}

	public String prepareNew() {
		return SUCCESS;
	}

	public String search() {
		getBL().search(getForm());
		return SUCCESS;
	}

	public void setListAccessPaths(List<String> listAccessPaths) {
		this.listAccessPaths = listAccessPaths;
	}
}
