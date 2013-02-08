<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head jqueryui="true" />
<link rel="stylesheet"
	href="/basicweb/css/ganesha-table-popupmenu-0.1.css" type="text/css" />
</head>
<body>
	<sj:dialog modal="true" id="popupMenu"
		title="Remote Dialog open on Click" resizable="false" autoOpen="false"
		dialogClass="tablePopop" width="auto" minHeight="0">
		<table cellspacing="0px">
			<tr>
				<td width="20px"></td>
				<td>Detail</td>
				<td width="50px"></td>
			</tr>
			<tr>
				<td></td>
				<td>Edit</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Delete</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td>Cancel</td>
				<td></td>
			</tr>
		</table>
	</sj:dialog>
	<sj:a openDialog="popupMenu">Open</sj:a>
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