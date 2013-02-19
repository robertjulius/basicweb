package com.cjs.basicweb.modules.usergroupmaintenance.action;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.cjs.basicweb.model.module.Module;
import com.cjs.basicweb.model.usergroup.UserGroup;
import com.cjs.basicweb.modules.login.Privilege;
import com.cjs.basicweb.modules.login.PrivilegeUtils;
import com.cjs.basicweb.modules.usergroupmaintenance.form.UserGroupMaintenanceForm;
import com.cjs.basicweb.modules.usergroupmaintenance.logic.UserGroupMaintenanceBL;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class UserGroupMaintenanceMainAction extends
		FormAction<UserGroupMaintenanceForm, UserGroupMaintenanceBL> {

	private static final long serialVersionUID = 8114275581397242184L;

	public UserGroupMaintenanceMainAction() throws AppException {
		super(UserGroupMaintenanceForm.class, UserGroupMaintenanceBL.class);
	}

	public String confirmEdit() throws AppException {
		return SUCCESS;
	}

	public String confirmNew() throws AppException {
		return confirmEdit();
	}

	public String executeEdit() throws AppException {
		UserGroupMaintenanceForm form = getForm();
		getBL().update(form.getSelectedId(), form.getNewName(),
				form.getNewDescription(), form.getNewModuleIds());
		return SUCCESS;
	}

	public String executeNew() throws AppException {
		return SUCCESS;
	}

	public String initial() {
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		String selectedId = getForm().getSelectedId();
		UserGroup userGroup = getBL().getDetail(selectedId);
		getForm().setOld(userGroup);
		
		List<Module> modules = getForm().getOld().getModules();
		List<String> privilegeIds = new ArrayList<>();
		for (Module module : modules) {
			privilegeIds.add(module.getId());
		}
		TreeMap<String, Privilege> treeMap = PrivilegeUtils.generateTree(
				privilegeIds.toArray(new String[] {}), getBL().getRootModules());
		getRequest().setAttribute("treeMap", treeMap);
		
		return SUCCESS;
	}

	public String prepareEdit() throws AppException {
		UserGroupMaintenanceForm form = getForm();
		form.assignFromEntity("new", form.getOld());		
		
		List<Module> modules = getBL().getChildModules();
		List<String> privilegeIds = new ArrayList<>();
		for (Module module : modules) {
			privilegeIds.add(module.getId());
		}
		TreeMap<String, Privilege> treeMap = PrivilegeUtils.generateTree(
				privilegeIds.toArray(new String[] {}), getBL().getRootModules());
		getRequest().setAttribute("treeMap", treeMap);
		
		List<String> initialModuleIds = new ArrayList<>();
		for (Module module : form.getOld().getModules()) {
			initialModuleIds.add(module.getId());
		}
		getRequest().setAttribute("initialModuleIds", initialModuleIds);

		return SUCCESS;
	}

	public String prepareNew() throws AppException {
		return SUCCESS;
	}

	public String search() {
		String name = getForm().getSearchName();
		String description = getForm().getSearchDescription();

		List<UserGroup> userGroups = getBL().search(name, description);
		getForm().setSearchResult(userGroups);
		return SUCCESS;
	}
}
