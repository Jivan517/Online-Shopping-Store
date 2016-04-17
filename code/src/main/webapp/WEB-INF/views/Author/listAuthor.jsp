<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
</head>
<body>
<h1>AJM</h1>
	<h2>AJM | List of Authors</h2>
	<br>
	<a href= "<spring:url value="/author/add" />"  > Add Author</a>

<section class="container">
	<div class=row>
		<c:forEach items="${authorList}" var="author">

				<h3>First Name : ${author.firstName}</h3>
				<p>Last Name : ${author.lastName}</p>
				 
				<p>Email : ${author.email}</p>
				<p>Phone : ${author.phone}</p>
				
				<form action="author/update/${publisher.id}" method="get">
						<button>Update</button>
					</form></td>
				<td><form action="author/delete/${publisher.id}" method="post">
						<button type="submit">Delete</button>
					</form></td>
				
			<!--  
				<p>
				<a href=" <spring:url value="/movies/movie?id=${movie.id}" /> " class="btn btn-primary">
					<span class="glyphicon-info-sign glyphicon"/></span> Details
				</a>
				</p>
			-->
		</c:forEach>
	</div>
</section>


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
