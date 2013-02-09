package com.cjs.basicweb.modules.resetusersession.action;

import com.cjs.basicweb.modules.login.usersession.SimpleUserSession;
import com.cjs.basicweb.modules.resetusersession.form.ResetUserSessionForm;
import com.cjs.basicweb.modules.resetusersession.logic.ResetUserSessionBL;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.struts2.FormAction;

public class ResetUserSessionMainAction extends
		FormAction<ResetUserSessionForm> {

	private static final long serialVersionUID = 8924100755506310829L;

	private ResetUserSessionBL resetUserSessionBL;

	public ResetUserSessionMainAction() {
		super(ResetUserSessionForm.class);
		resetUserSessionBL = new ResetUserSessionBL();
	}

	public String executeReset() throws AppException {
		resetUserSessionBL.reset(getForm().getUserId());
		return SUCCESS;
	}

	public String initial() throws AppException {
		getForm().setUserSessions(resetUserSessionBL.getList());
		return SUCCESS;
	}

	public String prepareDetail() throws AppException {
		UserSession userSession = resetUserSessionBL.getDetail(getForm().getUserId());
		getForm().setTobeReset((SimpleUserSession) userSession);
		return SUCCESS;
	}
}
