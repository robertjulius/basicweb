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
</head>
<body>
	<table>
		<tr>
			<td>
				<h1>Reset User Session</h1>
			</td>
		</tr>
	</table>
	<s:form action="/modules/resetusersession/prepareDetail.action"
		theme="simple">
		<s:actionerror />
		<s:fielderror />
		<s:hidden key="userId" />
		<table class="grid">
			<thead>
				<tr align="center">
					<td>User Id</td>
					<td>User Name</td>
					<td>Login Time</td>
				</tr>
			</thead>
			<tbody class="selectable">
				<s:iterator value="userSessions" status="rowstatus">
					<tr
						onclick="$('[name=\'userId\']').val('<s:property value="user.userId" />'); $('#prepareDetail').submit()"
						class="<s:if test='#rowstatus.odd == true'>rowOdd</s:if><s:else>rowEven</s:else>">
						<td><s:property value="user.userId" /></td>
						<td><s:property value="user.name" /></td>
						<td><s:date name="loginTime" format="dd-MMM-yyyy HH:mm:ss" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
</body>
</html>