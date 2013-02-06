<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />
<sj:head jqueryui="true" jquerytheme="cupertino" scriptPath="/template/"/>
</head>
<body>
	<table>
		<tr>
			<td>
				<div class="form">
					<s:form action="/modules/login/executeLogin.action" method="post">
						<s:actionerror />
						<s:fielderror />
						<div class="input">
							<s:label key="userId" />
							<br />
							<s:textfield name="userId" />
						</div>
						<div class="input">
							<s:label key="password" />
							<br />
							<s:password name="password" />
						</div>
						<div class="input">
							<s:submit key="submit" />
						</div>
					</s:form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>