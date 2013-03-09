<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="lab" uri="/WEB-INF/custom-tags.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
</head>
<body>
	<table class="form">
		<tr>
			<td><s:form action="/modules/login/executeLogin.action">
					<s:actionerror />
					<s:fielderror />
					<s:textfield key="resource.userId" name="userId" />
					<s:password key="resource.password" name="password" />
					<s:submit key="resource.submit" name="%{resource.submit}" />
				</s:form></td>
		</tr>
		<tr>
			<td>%{userId}</td>
		</tr>
		<tr>
			<td><s:text name="%{userId}"/></td>
		</tr>
		<tr>
			<td><lab:hello name="%{AuserId}" /></td>
		</tr>
	</table>
</body>
</html>