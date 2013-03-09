package com.cjs.struts2.views.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.cjs.struts2.components.Component.Hello;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloTag extends ComponentTagSupport {
	protected String name;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Hello(stack);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void populateParams() {
		super.populateParams();

		Hello hello = (Hello) component;
		hello.setName(name);
	}
}
