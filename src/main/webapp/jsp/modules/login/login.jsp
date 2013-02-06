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
	<s:form action="/modules/login/executeLogin.action">
		<s:actionerror />
		<s:fielderror />
		<s:textfield key="userId" />
		<s:password key="password" />
		<s:submit key="submit" />
	</s:form>
</body>
</html>