package com.cjs.basicweb.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjs.core.UserSession;

class AccessPath implements Serializable {
	private String id;
	private String[] path;

	/**
	 * Returns the id.
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the path.
	 * 
	 * @return String[]
	 */
	public String[] getPath() {
		return path;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            The id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the path.
	 * 
	 * @param path
	 *            The path to set
	 */
	public void setPath(String[] path) {
		this.path = path;
	}

}

/**
 * @author Dave
 */
public class PageFilter implements Filter {
	private FilterConfig filterConfig;

	private static String[] urlDoesntNeedSession, urlDoesntNeedCheckPrivileges;
	private static PageFailAuth failAuth = null;

	public static final String URL_DOESNT_NEED_SESSION = "urlDoesntNeedSession";
	public static final String URL_DOESNT_NEED_CHECK_PRIVILEGES = "urlDoesntNeedCheckPrivileges";

	static {
		refresh();

		Arrays.sort(urlDoesntNeedSession);
		Arrays.sort(urlDoesntNeedCheckPrivileges);
	}

	/**
	 * To load/reload the url file.
	 */
	public static synchronized void refresh() {
		try {

			// load access other path
			String location = Environment.get(Environment.RESOURCE_LOCATION);
			InputStream is = PageFilter.class.getClassLoader()
					.getResourceAsStream(
							location + "/" + "access-other-path.xml");
			if (is != null) {
				// load xml to obj
				XStream x = new XStream();
				InputStreamReader isr = new InputStreamReader(is);
				x.alias("access", List.class);
				x.alias("url", AccessPath.class);
				ArrayList ar = (ArrayList) x.fromXML(isr);
				for (int i = 0; i < ar.size(); i++) {
					AccessPath url = (AccessPath) ar.get(i);
					if (url.getId().trim()
							.equals(URL_DOESNT_NEED_CHECK_PRIVILEGES)) {
						urlDoesntNeedCheckPrivileges = url.getPath();
					} else if (url.getId().trim()
							.equals(URL_DOESNT_NEED_SESSION)) {
						urlDoesntNeedSession = url.getPath();
					}
				}
				LogProducer.get(PrivilegeFcd.LOGGER).info(
						"[PageFilter] The list path is loaded successfully.");
			}

			// load PageFailAuth
			failAuth = (PageFailAuth) Configuration.getAppContext().getBean(
					"pageFailAuthentication");
		} catch (Exception e) {
			LogProducer.get(PrivilegeFcd.LOGGER).error(
					"[PageFilter] The list path is failed.", e);
		}
	}

	/**
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see javax.servlet.Filter#doFilter(ServletRequest, ServletResponse,
	 *      FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		StringBuffer sb = new StringBuffer(request.getRequestURI());
		sb.delete(0, request.getContextPath().length());

		LogProducer.get(PrivilegeFcd.LOGGER).debug(
				"Requested URL:" + sb.toString());
		// check the path whether it needs session or not
		if (Arrays.binarySearch(urlDoesntNeedSession, sb.toString()) >= 0) {
			chain.doFilter(req, resp); // by pass
			return;
		}
		LogProducer.get(PrivilegeFcd.LOGGER).debug("URL need the session.");

		// check the session is existed?
		if (!UserSession.checkSession(request.getSession())) { // if session is
																// not found
			JSPUtils.forward(request, response,
					filterConfig.getServletContext(), failAuth.getExpiredUrl()); // goto
																					// expired
																					// page
			return;
		}

		// check the path is need privileges validation?
		if (Arrays.binarySearch(urlDoesntNeedCheckPrivileges, sb.toString()) >= 0) {
			chain.doFilter(req, resp);
			return;
		}
		LogProducer.get(PrivilegeFcd.LOGGER).debug(
				"URL need the privilege authentication.");

		// check if the url is permitted to access
		if (!UserSession.authenticateUrl(request.getSession(), sb.toString())) { // if
																					// authentication
																					// failed,
																					// go
																					// to
																					// "not authorized"
																					// page
			LogProducer.get(PrivilegeFcd.LOGGER).debug(
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
		 * LogProducer.get(PrivilegeFcd.LOGGER).debug(
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
		 * LogProducer.get(PrivilegeFcd.LOGGER).debug(
		 * "URL Lock Authentication result= currently granted by other user.");
		 * JSPUtils.forward(request, response, filterConfig.getServletContext(),
		 * failAuth.getNotGrantedUrl()); return; }
		 */

		LogProducer.get(PrivilegeFcd.LOGGER).debug(
				"URL Authentication result= authorized.");
		LogProducer.get(PrivilegeFcd.LOGGER).debug(
				"URL Lock Authentication result= granted lock.");
		chain.doFilter(req, resp); // by pass
	}

	/**
	 * Method init.
	 * 
	 * @param config
	 * @throws javax.servlet.ServletException
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		filterConfig = config;
	}

}
