package com.cjs.basicweb.modules.usergroupmaintenance.action;

import java.sql.Timestamp;

import com.cjs.basicweb.model.user.SimpleUser;
import com.cjs.basicweb.modules.usergroupmaintenance.UserGroupMaintenanceForm;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;

public class UserGroupMaintenanceDeleteAction extends
		UserGroupMaintenanceAction {

	private static final long serialVersionUID = 8114275581397242184L;

	public UserGroupMaintenanceDeleteAction() throws AppException {
		super();
	}

	public String executeDelete() throws AppException {
		UserSession userSession = (UserSession) getSession().get(
				GeneralConstants.USER_SESSION);

		SimpleUser user = (SimpleUser) userSession.getUser();

		UserGroupMaintenanceForm form = getForm();
		try {
			getBL().delete(form.getSelectedId(), user.getId(),
					new Timestamp(System.currentTimeMillis()));
			return SUCCESS;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return ERROR;
		}

	}
}
