<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<a href="${pageContext.request.contextPath}/publisher/add/" class="btn btn-primary"> Add publisher</a>
		</div>

		<br />

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						
					</tr>
				</thead>
				<c:forEach var="publisher" items="${publisherList}">
					<tr>
						<td>${publisher.name}</td>
						<td>${publisher.phone}</td>
						<td>${publisher.email}</td>
						
						<td>
						
							<form action="${pageContext.request.contextPath}/publisher/update/${publisher.id}" method="get">
								<button>Update</button>
							</form>
						</td>
						<td><form action="${pageContext.request.contextPath}/publisher/delete/${publisher.id}" method="post">
								<button type="submit">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
