<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head />
<link rel="stylesheet"
	href="/basicweb/css/ganesha-table-popupmenu-0.1.css" type="text/css" />
</head>
<body>
	<table>
		<tr>
			<td>
				<h1>
					<s:text name="resource.page.title" />
				</h1>
			</td>
		</tr>
	</table>
	<s:form action="/modules/???/prepareDetail.action" theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<s:hidden name="???"/>
		<table>
			<tr>
				<td>
					<table class="grid">
						<thead>
							<tr align="center">
								<td><s:text name="resource.???" /></td>
								<td><s:text name="resource.???" /></td>
								<td><s:text name="resource.???" /></td>
								<td><s:text name="resource.???" /></td>
							</tr>
						</thead>
						<tbody class="selectable">
							<s:iterator value="???" status="rowstatus">
								<tr
									onclick="$(this).closest('form').find('input#prepareDetail_???').val('<s:property value="???" />'); $(this).closest('form').submit();"
									class="<s:if test='#rowstatus.odd == true'>rowOdd</s:if><s:else>rowEven</s:else>">
									<td><s:property value="???" /></td>
									<td><s:property value="???" /></td>
									<td><s:property value="???" /></td>
									<td><s:property value="???" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</td>
			</tr>
			<tr align="center">
				<td>
					<table>
						<tr>
							<td><input type="button"
								value="<s:text name="resource.back"/>"
								onclick="$(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/???/initial.action'); $(this).closest('form').submit();" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>