<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
		<script type="text/javascript">
		function confirmDelete(delForm, delUrl) { 
		    if (confirm("Are you sure you wnat to delete this Publishe ? Associated Books will also be deleted !! ")) {
		        delForm.action = delUrl;          
		        return true;                      
		    }
		    return false;                         
		}

	</script>
</head>
<body>
<div class="container">
		<div class="page-header ">
			<h3>Publishers List</h3>
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
								<button class = "btn btn-info">Update</button>
							</form>
						</td>
						<td><form action="${pageContext.request.contextPath}/publisher/delete/${publisher.id}" method="post"
											onsubmit="return confirmDelete(this, '${pageContext.request.contextPath}/publisher/delete/${publisher.id}')">
								<button type="submit" class = "btn btn-danger">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
