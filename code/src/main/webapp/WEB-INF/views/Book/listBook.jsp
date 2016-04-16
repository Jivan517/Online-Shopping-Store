<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Collection | AJM-Online Book Store</title>
<style type="text/css">
.navbar {
	margin-bottom: 0px;
}
</style>

</head>
<body>
	<div class="container">
		<div class="page-header ">
			<h3>Books Collection</h3>
		</div>

		<div>
			<a href="books/add" class="btn btn-primary"> Add Book</a>
		</div>

		<br />

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Title</th>
						<th>ISBN</th>
						<th>Publisher</th>
						<th>ReleaseDate</th>
					</tr>
				</thead>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.title}</td>
						<td>${book.isbn}</td>
						<td>${book.publisher}</td>
						<td>${book.releaseDate}</td>
						<td>
							<form action="books/update/${book.id}" method="get">
								<button>Update</button>
							</form>
						</td>
						<td><form action="books/delete/${book.id}" method="post">
								<button type="submit">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>