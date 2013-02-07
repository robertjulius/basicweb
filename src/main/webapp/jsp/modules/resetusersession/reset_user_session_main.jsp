<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
</head>
<body>
	<table>
		<tr>
			<td>
				<h1>Reset User Session</h1>
			</td>
		</tr>
	</table>
	<table class="grid">
		<tr class="rowHeader">
			<td>User Id</td>
			<td>User Name</td>
		</tr>
		<s:iterator value="userSessions" status="rowstatus">
			<tr
				class="<s:if test='#rowstatus.odd == true'>rowOdd</s:if><s:else>rowEven</s:else>">
				<td><s:property value="user.userId" /></td>
				<td><s:property value="user.name" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>