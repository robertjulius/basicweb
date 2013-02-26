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
				<h1>
					<s:text name="resource.page.title" />
				</h1>
			</td>
		</tr>
	</table>
	<s:form action="/modules/usermaintenance/executeUpdate.action"
		theme="simple">
		<s:if test="hasActionErrors()">
			<table>
				<s:actionerror />
				<s:fielderror />
			</table>
		</s:if>
		<table class="form">
			<tr>
				<td>
					<table class="grid" id="grid1">
						<thead>
							<tr>
								<td colspan="2"><s:text name="resource.userInformation" /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="right"><s:text name="resource.userId" /></td>
								<td align="left"><s:label name="old.userId" /></td>
							</tr>
							<tr>
								<td align="right"><s:text name="resource.userName" /></td>
								<td align="left"><s:label name="old.name" /></td>
							</tr>
							<tr>
								<td align="right"><s:text name="resource.userGroup" /></td>
								<td align="left"><s:label name="old.userGroup.name" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table class="grid" id="grid2">
						<thead>
							<tr>
								<td colspan="2"><s:text name="resource.userInformation" /></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td align="right"><s:text name="resource.userId" /></td>
								<td align="left"><s:label name="newUserId" /></td>
							</tr>
							<tr>
								<td align="right"><s:text name="resource.userName" /></td>
								<td align="left"><s:label name="newName" /></td>
							</tr>
							<tr>
								<td align="right"><s:text name="resource.userGroup" /></td>
								<td align="left"><s:label name="newUserGroupName" /></td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td><input type="button"
								value="<s:text name="resource.back"/>"
								onclick="$(this).closest('form').attr('action', '<%=request.getContextPath()%>/modules/usermaintenance/formUpdate.action'); $(this).closest('form').submit();" /></td>
							<td><input type="button"
								value="<s:text name="resource.submit"/>"
								onclick="$(this).closest('form').submit();" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</s:form>
</body>
<script type="text/javascript">
	window.onload = function() {
		stripeTable($('table#grid1'));
		stripeTable($('table#grid2'));
	}
</script>
</html>