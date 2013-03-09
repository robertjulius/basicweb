package com.cjs.servlet.jsp.tagext;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTag extends SimpleTagSupport {

	private String formAction;
	private Integer pageNumber;
	private Integer totalPage;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println(generateHtml());
	}

	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	private String generateHtml() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("<form id=\"paginationForm\" method=\"post\" action=\""
						+ formAction + "\" name=\"paginationForm\">");

		stringBuilder
				.append("<input id=\"pageNumber\" type=\"hidden\" value=\"1\" name=\"pagination.pageNumber\">");
		stringBuilder.append("<table class=\"pagination\">").append("<tbody>")
				.append("<tr>");

		stringBuilder.append("<td>First</td>");
		stringBuilder.append("<td>Previous</td>");

		stringBuilder.append("<td class=\"pageSelected\"><b>1</b></td>");
		stringBuilder
				.append("<td><a href=\"#\" onclick=\"pageGoto('2'); $(this).closest('form').submit();\">2</a></td>");
		stringBuilder
				.append("<td><a href=\"#\" onclick=\"pageGoto('3'); $(this).closest('form').submit();\">3</a></td>");
		stringBuilder
				.append("<td><a href=\"#\" onclick=\"pageGoto('4'); $(this).closest('form').submit();\">4</a></td>");

		stringBuilder
				.append("<td><a href=\"#\" onclick=\"pageNext(); $(this).closest('form').submit();\">Next</a></td>");
		stringBuilder
				.append("<td><a href=\"#\" onclick=\"pageGoto('4'); $(this).closest('form').submit();\">Last</a></td>");

		stringBuilder.append("</tr>").append("</tbody>").append("</table>")
				.append("</form>");

		return stringBuilder.toString();

	}
}
