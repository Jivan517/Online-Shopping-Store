<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
</head>
<body>
<div class="container">
		<div class="page-header ">
			<h3>Books Collection</h3>
		</div>

		<div>
			<a href="${pageContext.request.contextPath}/author/add/" class="btn btn-primary"> Add author</a>
		</div>

		<br />

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Phone</th>
						<th>Email</th>
						
					</tr>
				</thead>
				<c:forEach var="author" items="${authorList}">
					<tr>
						<td>${author.firstName}</td>
						<td>${author.lastName}</td>
						<td>${author.phone}</td>
						<td>${author.email}</td>
						
						<td>
							<form action="${pageContext.request.contextPath}/author/update/${author.id}" method="get">
								<button>Update</button>
							</form>
						</td>
						<td><form action="${pageContext.request.contextPath}/author/delete/${author.id}" method="post">
								<button type="submit">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
