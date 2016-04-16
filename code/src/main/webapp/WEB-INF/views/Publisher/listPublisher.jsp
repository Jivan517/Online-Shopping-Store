<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
</head>
<body>
<h1>AJM</h1>
	<h2>AJM | List of Publishers</h2>
	<br>
	<a href="<spring:url value="/add" />" > Add Publisher</a>
	<table>

		<thead>
			<tr>
				<th>Name</th>
				
			</tr>
		</thead>

		<c:forEach var="publisher" items="${publisherList}">
			<tr>
				<td>${publisher.name} &nbsp; </td>
				<td>${publisher.email} &nbsp; </td>
				<td>${publisher.phone} &nbsp; </td>
				<td>
				<form action="publisher/update/${publisher.id}" method="get">
						<button>Update</button>
					</form></td>
				<td><form action="publisher/delete/${publisher.id}" method="post">
						<button type="submit">Delete</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
