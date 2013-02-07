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
	<table><tr><td>
		<h1>Reset User Session</h1>
	</td></tr></table>
	<table>
		<s:iterator value="userSessions">
			<tr>
				<td><s:property value="user.userId"/></td>
				<td><s:property value="user.password"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>