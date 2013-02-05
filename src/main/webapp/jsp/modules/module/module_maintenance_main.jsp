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
				<div class="form">
					<s:form action="/modules/module/prepareNew.action"
						method="post">
						<s:submit key="Create New" />
					</s:form>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="form">
					<s:form action="/modules/module/search.action" method="post">
						<s:actionerror />
						<s:fielderror />
						<div class="input">
							<s:label key="moduleId" />
							<br />
							<s:textfield name="moduleId" />
						</div>
						<div class="input">
							<s:label key="moduleName" />
							<br />
							<s:textfield name="moduleName" />
						</div>
						<div class="input">
							<s:label key="moduleAction" />
							<br />
							<s:textfield name="moduleAction" />
						</div>
						<div class="input">
							<s:label key="moduleParent" />
							<br />
							<s:textfield name="moduleParent" />
						</div>
						<s:submit key="Search" />
					</s:form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>