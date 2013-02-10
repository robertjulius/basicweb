<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
</head>
<body>
	<table>
		<tr>
			<td><h1>
					<s:text name="resource.page.title" />
				</h1></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="right"><s:form
					action="/modules/???/prepareNew.action" method="post">
					<s:submit key="resource.create.new" />
				</s:form></td>
		</tr>
		<tr>
			<td><hr /></td>
		</tr>
		<tr>
			<td><s:form action="/modules/???/search.action" method="post">
					<s:actionerror />
					<s:fielderror />
					<s:textfield key="resource.???" />
					<s:textfield key="resource.???" />
					<s:textfield key="resource.???" />
					<s:textfield key="resource.???" />
					<s:submit key="resource.search" />
				</s:form></td>
		</tr>
	</table>
</body>
</html>