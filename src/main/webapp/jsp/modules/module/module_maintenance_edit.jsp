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
	<s:form action="/modules/module/executeEdit.action" theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<s:hidden name="newId" value="%{selected.id}"/>
		<table class="form">
			<tr>
				<td>
					<table>
						<s:textfield key="resource.moduleName" name="newName" value="%{selected.name}" theme="xhtml"/>
						<s:textfield key="resource.description" name="newDescription" value="%{selected.description}" theme="xhtml"/>
						<s:textfield key="resource.firstEntry" name="newFirstEntry" value="%{selected.firstEntry}" theme="xhtml"/>
						<s:select key="resource.parent" list="listParent" listKey="key" listValue="value" theme="xhtml"/>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table align="right">
						<tr>
							<td><input type="button"
								value="<s:text name="resource.cancel"/>"
								onclick="if (!confirmCancel()) {return;} $(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/module/prepareDetail.action'); $(this).closest('form').submit();" /></td>
							<td><input type="button"
								value="<s:text name="resource.submit"/>"
								onclick="if (confirmAction() {$(this).closest('form').submit();}" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>