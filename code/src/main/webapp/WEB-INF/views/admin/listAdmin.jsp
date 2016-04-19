<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin List | AJM-Online Book Store</title>
<style type="text/css">
.navbar {
	margin-bottom: 0px;
}
</style>

</head>
<body>
	<div class="container">
		<div class="page-header ">
			<h3>Admin List</h3>
		</div>

		<div>
			<a href="admin/add" class="btn btn-primary"> Add Admin</a>
		</div>

		<br />

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<c:forEach var="admin" items="${adminList}">
					<tr>
						<td>${admin.name}</td>
						<td>${admin.email}</td>
						<td>
							<form action="admin/update/${admin.id}" method="get">
								<button>Update</button>
							</form>
						</td>
						<td><form action="admin/delete/${admin.id}" method="post">
								<button type="submit">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>