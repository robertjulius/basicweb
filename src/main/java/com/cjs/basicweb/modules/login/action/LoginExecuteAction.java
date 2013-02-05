package com.cjs.basicweb.modules.login.action;

import com.cjs.basicweb.modules.login.form.LoginForm;
import com.cjs.basicweb.modules.login.logic.LoginBL;
import com.cjs.basicweb.modules.login.usersession.SimpleUserSession;
import com.cjs.basicweb.utility.AppContextManager;
import com.cjs.basicweb.utility.GeneralConstants;
import com.cjs.core.User;
import com.cjs.core.UserSession;
import com.cjs.core.exception.AppException;
import com.cjs.core.exception.UserException;
import com.cjs.struts2.FormAction;

public class LoginExecuteAction extends FormAction<LoginForm> {

	private static final long serialVersionUID = -3643549719278354411L;

	private LoginBL loginBL;
	private UserSession userSession;

	public LoginExecuteAction() {
		super(LoginForm.class);
		loginBL = new LoginBL();
		userSession = new SimpleUserSession();
	}

	@Override
	public String execute() throws AppException {
		try {
			User user = loginBL.performLogin(getForm().getUserId(), getForm()
					.getPassword(), userSession);
			userSession.setUser(user);
			getSession().put(GeneralConstants.USER_SESSION, userSession);
			AppContextManager.getUserSessionManager().registerUserSession(
					userSession);
			return SUCCESS;
		} catch (UserException e) {
			addActionError(e.getMessageId());
			return INPUT;
		}
	}
}
