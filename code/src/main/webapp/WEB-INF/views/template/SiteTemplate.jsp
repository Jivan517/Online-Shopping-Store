<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>AJM - Online Book Store</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<!-- <link rel="stylesheet" href="resources/css/screen.css" type="text/css" -->
<!-- 	media="screen, projection"></link> -->
<!-- <link rel="stylesheet" href="resources/css/print.css" type="text/css" -->
<!-- 	media="print"></link> -->
<link href="favicon.ico" rel="icon" type="image/x-icon" />
<style>

</style>
</head>
<body>
	<div class="container-fluid" style="border: #C1C1C1 solid 1px; border-radius: 10px; margin:5px;">
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- Menu Page -->
		<div class="col-md-12" style="background-color: #FCFCFC;">
			<tiles:insertAttribute name="menu" />
		</div>
		<!-- Body Page -->
		<div class="col-md-12" style="height:500px;">
			<tiles:insertAttribute name="body" />
		</div>
		<!-- Footer Page -->
		<tiles:insertAttribute name="footer" />
	</div>


	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>