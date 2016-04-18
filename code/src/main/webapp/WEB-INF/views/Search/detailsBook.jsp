<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.title }|AJM-OnlineBookStore</title>



</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>${book.title }
				<small>${book.publisher }</small>
			</h3>
		</div>
		<br /> <br />
		<div class="row">
			<div class="col-md-3">
				<c:choose>
					<c:when test="${empty book.url }">
						<img id="bookCover" src="resources/img/samplecover.jpg"
							alt="${book.title }" class="img-rounded"></img>

					</c:when>

					<c:when test="${not empty book.url }">
						<img id="bookCover" src="${book.url }" alt="${book.title }"
							class="img-rounded"></img>
					</c:when>

				</c:choose>
				<br /> <br /> <small>
					<p>Language: ${book.language }</p>
					<p>ISBN: ${book.isbn }</p>
					<p>Release Date: ${book.releaseDate }</p>
					<p>Publisher: ${book.publisher }</p>
					<p>Length: ${book.length } pages</p>
					<p>Dimensions: ${book.dimension }</p>

				</small>
			</div>
			<div class="col-md-6">
				<h3>Overview</h3>
				<br />
				<p>${book.description }</p>
			</div>

			<div class="col-md-3">
				<p class="text-muted">
				<h4>${book.bookType}&nbsp;<span class="label label-default">New</span>
				</h4>
				</p>
				<c:if test="${book.quantity gt 0 }">



					<p>
					<h3 class="text-primary">$ ${book.price }</h3>
					</p>
					<p>
						<button class="btn btn-primary" onsubmit="">Add to Cart</button>
					</p>
				</c:if>
				
				<c:if test="${book.quantity le 0 }">
							<h3><p class="text-danger">
								<b>Out of Stock</b>
							</p></h3>
						</c:if>
				
			</div>

		</div>


	</div>
	<br />
	<br />
</body>
</html>