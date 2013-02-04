package com.cjs.basicweb.utility;

import java.io.IOException;

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
import com.cjs.core.UserSession;

public class SimpleFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		/*
		 * Do nothing
		 */
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String url = request.getRequestURI();
		url = url.substring(request.getContextPath().length());

		LoggerFactory.getLogger(getClass()).debug("Requested URL:" + url);

		if (isUrlNeedSession(url)) {
			LoggerFactory.getLogger(getClass()).debug("URL need the session.");

			UserSession userSession = (UserSession) request.getSession()
					.getAttribute(GeneralConstants.USER_SESSION);

			if (userSession == null) {
				JSPUtils.forward(request, response, filterConfig
						.getServletContext(), AppContextManager.getPageFail()
						.getSessionExpiredPage());
				return;
			}

			if (isUrlNeedPrivilege(url)) {
				LoggerFactory.getLogger(getClass()).debug(
						"Module need privilege.");
				String[] paths = ((SimpleUserSession) userSession)
						.getAccessPath();
				if (!isValidPath(url, paths)) {
					JSPUtils.forward(request, response, filterConfig
							.getServletContext(), AppContextManager
							.getPageFail().getNotAuthorizedPage());
					return;
				} else {
					LoggerFactory.getLogger(getClass()).debug(
							"URL Authentication result = authorized.");
				}
			}
		}

		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	private boolean isUrlNeedPrivilege(String url) {
		for (String testUrl : AppContextManager.getPageFail()
				.getUrlDoesntNeedPrivilege()) {
			if (testUrl.equals(url)) {
				return false;
			}
		}
		return true;
	}

	private boolean isUrlNeedSession(String url) {
		for (String testUrl : AppContextManager.getPageFail()
				.getUrlDoesntNeedSession()) {
			if (testUrl.equals(url)) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidPath(String url, String[] paths) {
		for (String testUrl : paths) {
			if (testUrl.equals(url)) {
				return true;
			}
		}
		return false;
	}
}
