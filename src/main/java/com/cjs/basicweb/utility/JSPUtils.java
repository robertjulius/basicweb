package com.cjs.basicweb.utility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

public class JSPUtils {

	public static void forward(HttpServletRequest request,
			HttpServletResponse response, ServletContext context,
			String targetPath) {

		RequestDispatcher rd = context.getRequestDispatcher(targetPath);

		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			LoggerFactory.getLogger(JSPUtils.class).error(e.getMessage(), e);
		} catch (IOException e) {
			LoggerFactory.getLogger(JSPUtils.class).error(e.getMessage(), e);
		}

	}
}
