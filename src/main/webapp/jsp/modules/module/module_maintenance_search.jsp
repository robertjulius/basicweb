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
				<h1>Module Maintenance</h1>
			</td>
		</tr>
	</table>
	<s:form action="/modules/resetusersession/prepareEdit.action">
		<s:actionerror />
		<s:fielderror />

		<s:hidden name="newId" value="" />
		<table class="grid">
			<tr class="rowHeader">
				<td align="center">Module ID</td>
				<td align="center">Module Name</td>
				<td align="center">Action</td>
				<td align="center">Parent</td>
				<td colspan="3"></td>
			</tr>
			<s:iterator value="modules" status="rowstatus">
				<tr
					class="<s:if test='#rowstatus.odd == true'>rowOdd</s:if><s:else>rowEven</s:else>">
					<td align="center"><s:property value="id" /></td>
					<td align="center"><s:property value="name" /></td>
					<td align="center"><s:property value="firstEntry" /></td>
					<td align="center"><s:property value="parent.id" /></td>
					<td><a href="#">Detail</a></td>
					<td><a href="#">Edit</a></td>
					<td><a href="#">Delete</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
</body>
<script type="text/javascript">

</script>
</html>