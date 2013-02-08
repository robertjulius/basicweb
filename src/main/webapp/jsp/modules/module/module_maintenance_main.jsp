<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head jqueryui="true" />
<s:head />
</head>
<body>
	<sj:dialog modal="true" id="mydialog3"
		title="Remote Dialog open on Click" resizable="false" width="auto" dialogClass="tablePopop" height="100">
		<table width="100">
			<tr>
				<td>Detail</td>
			</tr>
			<tr>
				<td>Edit</td>
			</tr>
			<tr>
				<td>Delete</td>
			</tr>
			<tr>
				<td><hr /></td>
			</tr>
			<tr>
				<td>Cancel</td>
			</tr>
		</table>
	</sj:dialog>
	<table>
		<tr>
			<td><h1>Module Maintenance</h1></td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="right"><s:form
					action="/modules/module/prepareNew.action" method="post">
					<s:submit key="create.new" />
				</s:form></td>
		</tr>
		<tr>
			<td><hr /></td>
		</tr>
		<tr>
			<td><s:form action="/modules/module/search.action" method="post">
					<s:actionerror />
					<s:fielderror />
					<s:textfield key="searchId" />
					<s:textfield key="searchName" />
					<s:textfield key="searchAction" />
					<s:textfield key="searchParent" />
					<s:submit key="Search" />
				</s:form></td>
		</tr>
	</table>
</body>
</html>