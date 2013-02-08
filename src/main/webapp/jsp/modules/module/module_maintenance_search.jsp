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
<link rel="stylesheet"
	href="/basicweb/css/ganesha-table-popupmenu-0.1.css" type="text/css" />
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
		<tr>
			<td>
				<table class="grid">
					<thead>
						<tr class="rowHeader">
							<td align="center">Module ID</td>
							<td align="center">Module Name</td>
							<td align="center">Action</td>
							<td align="center">Parent</td>
						</tr>
					</thead>
					<tbody class="selectable">
						<s:iterator value="modules" status="rowstatus">
							<tr
								class="<s:if test='#rowstatus.odd == true'>rowOdd</s:if><s:else>rowEven</s:else>">
								<td align="center"><s:property value="id" /></td>
								<td align="center"><s:property value="name" /></td>
								<td align="center"><s:property value="firstEntry" /></td>
								<td align="center"><s:property value="parent.id" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</td>
		</tr>
	</s:form>
	<s:form action="/modules/module/initial.action">
		<s:submit key="back" />
	</s:form>
</body>
<script type="text/javascript">
	
</script>
</html>