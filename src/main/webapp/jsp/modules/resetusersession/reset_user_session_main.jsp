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
		<s:iterator value="userSessions" status="userSessionsStatus">
			<tr>
				<s:if test="#userSessionsStatus.even == true">
					<td style="background: #CCCCCC"><s:property /></td>
				</s:if>
				<s:else>
					<td><s:property /></td>
				</s:else>
			</tr>
		</s:iterator>
	</table>
</body>
</html>