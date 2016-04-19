<%@page import="cs544.project.onlineshoppingstore.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Book | AJM-Online Book Store</title>
</head>
<body>

	<div class="container">
		<div class="page-header ">
			<h3>Search Results</h3>
		</div>
		<br />
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${totalCount}</strong> result(s) found.
		</div>

		<br />
		<c:forEach var="book" items="${books}" varStatus="rowCounter">
			<c:if test="${rowCounter.count % 3 == 1}">
				<div class="row">
			</c:if>
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<a href="details?i=${book.id }"> <c:choose>
							<c:when test="${empty book.url}">
								<img id="bookCover" src="resources/img/samplecover.jpg"
									alt="${book.title }" class="img-rounded"></img>

							</c:when>

							<c:when test="${not empty book.url }">
								<img id="bookCover" src="${book.url }" alt="${book.title }"
									class="img-rounded"></img>
							</c:when>

						</c:choose>


					</a>
					<div class="caption">
						<h5>
							<a href="details?i=${book.id }"><b>${book.title }</b></a>
						</h5>
						<p class = "text-primary">${book.authorName }</p>

						<c:if test="${book.quantity gt 0 }">
							<p class="text-muted">
								<b>From:</b> $${book.price }
							</p>
						</c:if>


						<c:if test="${book.quantity le 0 }">
							<p class="text-danger">
								<b>Out of Stock</b>
							</p>
						</c:if>
						
					</div>
				</div>
			</div>
			<c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(books)}">
				<br />
			</div>
	</c:if>

	</c:forEach>

	</div>

</body>
</html>