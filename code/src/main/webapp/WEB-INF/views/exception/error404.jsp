<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource not found - AJM Online Book Store</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty errCode}">
			<h1>Resource Not found - Http 404</h1>
		</c:if>

		<c:if test="${empty errCode}">
			<h1>Page Not Found</h1>
			<p>
			Sorry! We can't find that page. Perhaps that page has moved.
			</p>
		</c:if>

		<c:if test="${not empty errMsg}">
			<h2>${errMsg}</h2>
		</c:if>
	</div>
</body>
</html>