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
	<s:form action="/modules/resetusersession/executeReset.action"
		theme="simple">
		<table>
			<tr>
				<td><s:actionerror /> <s:fielderror /> <s:hidden key="userId" />
					<table class="grid">
						<thead>
							<tr>
								<td colspan="2"><s:text name="userSessionInformation" /></td>
							</tr>
						</thead>
						<tbody>
							<s:label key="userId" name="tobeReset.user.userId" theme="xhtml" />
							<s:label key="userName" name="tobeReset.user.name" theme="xhtml" />
							<s:set var="loginTime">
								<s:date name="tobeReset.loginTime" format="dd-MMM-yyyy HH:mm:ss" />
							</s:set>
							<s:label name="tobeReset.loginTime" label="Login Time"
								value="%{loginTime}" theme="xhtml" />
						</tbody>
					</table></td>
			</tr>
			<tr align="center">
				<td>
					<table>
						<tr>
							<td><input type="button" value="<s:text name="back"/>"
								onclick="$('#executeReset').get(0).setAttribute('action', '<%=request.getContextPath()%>/modules/resetusersession/initial.action'); $('#executeReset').submit();" /></td>
							<td><input type="button" value="<s:text name="reset"/>"
								onclick="if (confirmAction()) {$('#executeReset').submit();}" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>