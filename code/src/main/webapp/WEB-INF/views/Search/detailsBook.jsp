<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${book.title }|AJM-OnlineBookStore</title>
<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<c:url var="home" value="/" scope="request" />
	<input type="hidden" value="${book.id }" id="bookId"></input>
	<input type="hidden" value="${book.price}" id="bookPrice"></input>

	<div class="container">
		<div class="page-header">
			<h3>${book.title }
				<small>${book.publisher }</small>
			</h3>
		</div>
		<br /> <br />
		<div class="row">
			<div class="col-md-3">
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
				<br /> <br /> <small>
					<p>Language: ${book.language }</p>
					<p>ISBN: ${book.isbn }</p>
					<p>Release Date: ${book.releaseDate }</p>
					<p>Publisher: ${book.publisher }</p>
					<p>Length: ${book.length } pages</p>
					<p>Dimensions: ${book.dimension }</p>

				</small>
			</div>
			<div class="col-md-6">
				<h3>Overview</h3>
				<br />
				<p>${book.description }</p>
			</div>

			<div class="col-md-3">
				<p class="text-muted">
				<h4>${book.bookType}&nbsp;<span class="label label-default">New</span>
				</h4>
				</p>
				<c:if test="${book.quantity gt 0 }">



					<p>
					<h3 class="text-primary">$ ${book.price }</h3>
					</p>
					<p>
						<button class="btn btn-primary" id="addToCart">Add
							to Cart</button>
					</p>
				</c:if>

				<c:if test="${book.quantity le 0 }">
					<h3>
						<p class="text-danger">
							<b>Out of Stock</b>
						</p>
					</h3>
				</c:if>

			</div>

		</div>
		<div class="modal fade" tabindex="-1" role="dialog"
			id="addCategoryModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"><b>${book.title } </b>added to cart</h4>
					</div>
					<div class="modal-body">
						<b><p class= "text-success">1 copy of ${book.title } added to your cart!</p></b>
						<p>
						<h3>Price: $ ${book.price }</h3>
						</p>
						<i><p class = "text-primary">Hooray! You've got free shipping within the USA!</p></i>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->

	</div>
	<br />
	<br />
	
	<script type="text/javascript">
	$(document).ready(function() {
        
	    $("#addToCart").click(function(event) {
	    	var id = $("#bookId").val();
			//var json = {"id" : id};
			var url = "${home}addToCart/" + id;
			
			console.log(url);
			
	        $.ajax({
	            url: url,
	            type: "POST",
	            //data : JSON.stringify(json),
	            dataType : 'json',
	            //contentType : 'application/json',   
	             
	            success: function(val) {
	            	console.log("success");
	            	  $("#addCategoryModal").modal('show');        
	              },
	            error: function(err){
	            	console.log("error");
	            	console.log(err);
	            	$("#addCategoryModal").modal('show');
	            }
	        });
	   
	        event.preventDefault();
	    });
	        
	});   
	</script>
</body>
</html>