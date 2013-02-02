package com.cjs.basicweb.utility;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.cjs.basicweb.modules.login.usersession.SimpleUserSession;
import com.cjs.basicweb.utility.path.PathUtils;
import com.cjs.core.UserSession;

public class SimpleFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		StringBuffer stringBuffer = new StringBuffer(request.getRequestURI());
		stringBuffer.delete(0, request.getContextPath().length());

		String targetPath = stringBuffer.toString();

		LoggerFactory.getLogger(getClass()).debug(
				"Requested URL:" + stringBuffer.toString());

		if (PathUtils.isPathNeedSession(targetPath)) {
			LoggerFactory.getLogger(getClass()).debug("URL need the session.");
			if (request.getSession()
					.getAttribute(GeneralConstants.USER_SESSION) == null) {
				JSPUtils.forward(request, response,
						filterConfig.getServletContext(), "session_expired.jsp");
				return;
			}
		}

		
		
		
		if (PathUtils.isModuleNeedPrivilege(accessPath.get(targetPath))) {

			LoggerFactory.getLogger(getClass()).debug("Module need privilege.");

			UserSession userSession = (UserSession) request.getSession()
					.getAttribute(GeneralConstants.USER_SESSION);
			Map<String, String> accessPath = ((SimpleUserSession) userSession).getAccessPath();
			
			
			
			if () == null) {

				JSPUtils.forward(request, response,
						filterConfig.getServletContext(), "not_authorized.jsp");

				return;
			}
		}

		// check the path is need privileges validation?
		if (Arrays.binarySearch(urlDoesntNeedCheckPrivileges,
				stringBuffer.toString()) >= 0) {
			chain.doFilter(req, resp);
			return;
		}
		LoggerFactory.getLogger(getClass()).debug(
				"URL need the privilege authentication.");

		// check if the url is permitted to access
		if (!UserSession.authenticateUrl(request.getSession(),
				stringBuffer.toString())) { // if
			// authentication
			// failed,
			// go
			// to
			// "not authorized"
			// page
			LoggerFactory.getLogger(getClass()).debug(
					"URL Authentication result= not authorized.");
			JSPUtils.forward(request, response,
					filterConfig.getServletContext(),
					failAuth.getNotAuthorizedUrl());
			return;
		}

		// ModuleTracker.addBranch((UserSession)request.getSession().getAttribute("userSession"),
		// sb.toString());
		// Boolean successLock =
		// (Boolean)ModuleTracker.runLock(ModuleTracker.MODE_ADD_BRANCH,
		// (UserSession)request.getSession().getAttribute("userSession"),
		// sb.toString(), null);
		/*
		 * Object successLock =
		 * ModuleTracker.runLock(ModuleTracker.MODE_ADD_BRANCH,
		 * (UserSession)request.getSession().getAttribute("userSession"),
		 * sb.toString(), null);
		 * 
		 * if(successLock instanceof Boolean){ // check whether user has granted
		 * the access to the targeted module Boolean lockSuccess = (Boolean)
		 * successLock; if(lockSuccess.equals(Boolean.FALSE)){
		 * LoggerFactory.getLogger(getClass()).debug(
		 * "URL Lock Authentication result= currently granted by other user.");
		 * JSPUtils.forward(request, response, filterConfig.getServletContext(),
		 * failAuth.getNotGrantedUrl()); return; } } else if(successLock
		 * instanceof Integer){ // check whether user has granted the access to
		 * the targeted module based on his hierarchy-level
		 * (nasional,regional,area,cabang) Integer lockSuccess = (Integer)
		 * successLock; if(lockSuccess.intValue() ==
		 * ModuleTracker.NO_ACCESS_GRANTED){
		 * LogProducer.get(PrivilegeFcd.LOGGER)
		 * .debug("URL Authentication result= not authorized.");
		 * JSPUtils.forward(request, response, filterConfig.getServletContext(),
		 * failAuth.getNotAuthorizedUrl()); return; } } else{
		 * LogProducer.get(PrivilegeFcd
		 * .LOGGER).debug("URL Authentication result= not authorized.");
		 * JSPUtils.forward(request, response, filterConfig.getServletContext(),
		 * failAuth.getNotAuthorizedUrl()); return; }
		 */

		/*
		 * if(successLock.equals(Boolean.FALSE)){
		 * LoggerFactory.getLogger(getClass()).debug(
		 * "URL Lock Authentication result= currently granted by other user.");
		 * JSPUtils.forward(request, response, filterConfig.getServletContext(),
		 * failAuth.getNotGrantedUrl()); return; }
		 */

		LoggerFactory.getLogger(getClass()).debug(
				"URL Authentication result= authorized.");
		LoggerFactory.getLogger(getClass()).debug(
				"URL Lock Authentication result= granted lock.");
		chain.doFilter(req, resp); // by pass
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
