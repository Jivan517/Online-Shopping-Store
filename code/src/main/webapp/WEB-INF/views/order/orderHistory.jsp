<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer History | AJM-Online Book Store</title>
<style type="text/css">
.navbar {
	margin-bottom: 0px;
}
</style>

</head>
<body>

	<div class="container">
		<div class="page-header ">
			<h3>Order History</h3>
		</div>
		
		<br />

		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Books</th>
						<th>Total Cost</th>
						<th>Order Date</th>
						<th>Delivery Date</th>
						<th>Status</th>
					</tr>
				</thead>
				
				<c:forEach var="order" items="${orders}">
					<tr>
						<td>${order.orderLinesDetail}</td>
						<td>${order.total}</td>
						<td>${order.orderDate}</td>
						<td><fmt:formatDate value="${order.delivaryDate}" var="formattedDate" 
                type="date" pattern="MMM-dd-yyyy" /> ${formattedDate}</td>
                
                <td>${order.orderStatus }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>