<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>Welcome | AMJ-Online Book Store</title>
</head>
<body>


	<br />
	<br />


	<div class="container">
		<div class="page-header ">
			<h3>Recently Viewed Items and Featured Products</h3>
			<hr
				style="background: #454545; color: #ddd; clear: both; float: none; width: 100%; height: .1em; margin: 0 0 1.45em; border: none;" />
		</div>
		<br /> <br />
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
						<p class="text-primary">${book.authorName }</p>
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
			<c:if
				test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(books)}">
				<br />
	</div>
	</c:if>

	</c:forEach>

	</div>

	<br />
	<br />
</body>
</html>
