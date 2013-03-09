package com.cjs.servlet.jsp.tagext;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	private StringWriter sw = new StringWriter();

	private String message;

	@Override
	public void doTag() throws JspException, IOException {
		if (message != null) {
			/* Use message from attribute */
			JspWriter out = getJspContext().getOut();
			out.println(message);
		} else {
			/* use message from the body */
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

	public void setMessage(String msg) {
		message = msg;
	}

}
