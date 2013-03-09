package com.cjs.struts2.views.jsp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.cjs.struts2.components.Component.Pagination;
import com.opensymphony.xwork2.util.ValueStack;

public class PaginationTag extends ComponentTagSupport {

	private static final long serialVersionUID = 8917772029207863676L;

	private String formAction;
	private String pageNumber;
	private String totalPage;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req,
			HttpServletResponse res) {
		return new Pagination(stack, req.getContextPath());
	}

	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	protected void populateParams() {
		super.populateParams();

		Pagination pagination = (Pagination) component;
		pagination.setFormAction(formAction);
		pagination.setPageNumber(pageNumber);
		pagination.setTotalPage(totalPage);
	}
}
