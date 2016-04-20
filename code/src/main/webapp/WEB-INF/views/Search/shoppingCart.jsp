<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart | AJM-Online Book Store</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<script type="text/javascript">
	function confirmDelete(delForm, delUrl) {
		if (confirm("Are you sure you want to remove the book from cart?")) {
			delForm.action = delUrl;
			return true;
		}
		return false;
	}
	$(document).ready(function() {
		
		$('.bookQuantity').on('change', function(index, old) {

			var id =  $(this).attr('id');
			var idVal = id.replace("quantityId", "");
			var priceVal = $("#bookId" + idVal).val();			
			var orderTotal = $("#subTotal").text();			
			var oldVal = $(this).prop("defaultValue");
			var newVal = $(this).val();
			
			var newTotal = parseFloat(orderTotal) + (parseInt(newVal) - parseInt(oldVal)) * parseFloat(priceVal);
			
			$("#subTotal").text(newTotal);
			$("#totalPrice").text(newTotal);
			

		});
		
		$("#checkoutBtn").click(function(event) {
			
			var bookIds = [];
			var quantities = [];
			
			
			$('.bookQuantity').each(function(i, obj) {
				var quantity = $(this).val();
				var id =  $(this).attr('id');
				var idVal = id.replace("quantityId", "");
				bookIds.push(idVal);
				quantities.push(quantity);
				
				
				
			});
			
			console.log(bookIds);
			console.log(quantities);
			
	    	var json = {bookIds:bookIds, quantities:quantities};
			
	        $.ajax({
	            url: "${home}checkout?bookIds="+bookIds+"&quantities="+quantities,
	            type: "POST",
	            //data : JSON.stringify(json),
	            dataType : 'json',
	            //contentType : 'application/json',   
	             
	            success: function(val) {
	            	console.log("success");
	              },
	            error: function(err){
	            	console.log("error");
	            	console.log(err);
	            }
	        });
	   
	        event.preventDefault();
	    });
	});
</script>

</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>Shopping Cart</h3>
		</div>

		<br /> <br />

		<c:forEach var="book" items="${books}" varStatus="rowCounter">
			<div class="row">
				<div class="col-md-3">
					<p>
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
					</p>
				</div>
				<div class="col-md-4">
					<p class="text-primary">
						<b>${book.title }</b> <input type="hidden" id="bookId${book.id }"
							value="${book.price }"></input>
					</p>
					<p>
						By <b>${book.authorName }</b>
					</p>
					<p>Format: ${book.bookType }</p>
				</div>
				<div class="col-md-1">
					<p>
						<b>$${book.price }</b>
					</p>
					<p class="text-muted">each</p>
				</div>
				<div class="col-md-2">
					<input type="number" id="quantityId${book.id }" value="1"
						class="bookQuantity">
				</div>
				<div class="col-md-2">
					<form
						action="${pageContext.request.contextPath}/shoppingcart/remove/${book.id}"
						method="POST"
						onsubmit="return confirmDelete(this, '${pageContext.request.contextPath}/shoppingcart/remove/${book.id}')">
						<button class="btn btn-danger" type="submit">Remove from
							Cart</button>
					</form>
				</div>
			</div>
			<hr
				style="background: #454545; color: #ddd; clear: both; float: none; width: 100%; height: .1em; margin: 0 0 1.45em; border: none;" />
		</c:forEach>

		<c:if test="${fn:length(books) le 0}">
			<p class="text-warning">
			<h3>Your shopping cart is empty!</h3>
			</p>
			<p>Your Shopping Cart lives to serve. Give it purpose - fill it
				with books!</p>
		</c:if>

		<c:if test="${fn:length(books) gt 0}">
		
		
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-sm-6 col-md-4 jumbotron">
					<div class="thumbnail">
						<div class="caption">

							
							<p>
								<b>Order Subtotal: </b>$<label id="subTotal"> ${totalCost }</label>
							</p>
							<p>
								<b>Shipping Charge: </b> FREE
							</p>
							<hr
								style="background: #454545; color: #ddd; clear: both; float: none; width: 100%; height: .1em; margin: 0 0 1.45em; border: none;" />
							<p>
								<b>Order Total: </b>$<label id="totalPrice"> ${totalCost }</label>
							</p>
							<p>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a  class="btn btn-primary" role="button" id = "checkoutBtn">Checkout</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4 jumbotron">
					<div class="thumbnail">
						<div class="caption">

							
							<p>
								<b>Shipping Type : </b> ${shippingType }</label>
							</p>
							<p>
								<b>Shipping Address: </b> <small>${shippingAddress }</small>
							</p>
							
							<p>
								<b>Delivery Date: </b> ${deliveryDate }
							</p>
							<p>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</p>

						</div>
					</div>
				</div>
				<div class="col-md-4"></div>

			</div>
		</c:if>


	</div>
</body>
</html>