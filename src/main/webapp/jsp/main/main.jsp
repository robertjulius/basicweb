<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<s:head />

<style type="text/css">
#topFrame {
	position: fixed;
	top: 0px;
	left: 0px;
	width: 100%;
	border: none;
}

#leftFrame {
	position: fixed;
	top: 60px;
	left: 0px;
	width: 140px;
	height: 100%;
	border: none;
}

#contentFrame {
	position: fixed;
	top: 60px;
	left: 140px;
	width: 100%;
	height: 100%;
	border: none;
}
</style>

<script type="text/javascript">
	window.onload = function() {
		fitContent($('#topFrame'));
		fitContent($('#leftFrame'));
		adjustSize();
	};

	window.onresize = function() {
		adjustSize();
	};	

	function adjustSize() {
		var width = $(window).width();
		var height = $(window).height();

		$('#leftFrame').css("top", $('#topFrame').height());
		$('#leftFrame').height(height - $('#topFrame').height());

		$('#contentFrame').css("top", $('#topFrame').height());
		$('#contentFrame').css("left", $('#leftFrame').width());
		$('#contentFrame').width(width - $('#leftFrame').width());
		$('#contentFrame').height(height - $('#topFrame').height());
	}
</script>

<title></title>
</head>
<body>
	<iframe id="topFrame" scrolling="no" src="topFrame" name="topFrame"></iframe>
	<iframe id="leftFrame" scrolling="no" src="leftFrame" name="leftFrame"></iframe>
	<iframe id="contentFrame" scrolling="yes" src="home" name="contentFrame"></iframe>
</body>