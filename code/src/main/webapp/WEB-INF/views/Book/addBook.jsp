<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book | AJM-Online Book Store</title>
</head>
<body>
	<div class="container">
		<div class="page-header ">
			<h3>Add Book</h3>
		</div>

		<br />

		<form:form modelAttribute="book"
			action="${pageContext.request.contextPath}/books/add" method="post">

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Title</span>
						<form:input path="title" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="title" class="alert alert-danger" role="alert" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">ISBN</span>
						<form:input path="isbn" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="isbn" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br/>
			
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Price</span>
						<form:input path="price" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="price" class="alert alert-danger" role="alert" />
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Quantity</span>
						<form:input path="quantity" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="quantity" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Length</span>
						<form:input path="length" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="length" class="alert alert-danger" role="alert" />
				</div>
			
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Language</span>
						<form:input path="language" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="language" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Dimensions</span>
						<form:input path="dimension" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="dimension" class="alert alert-danger" role="alert" />
				</div>
			
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Release Date</span>
						<form:input path="releaseDate" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="releaseDate" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-10">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Description</span>
						<form:textarea path="description" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="description" class="alert alert-danger" role="alert" />
				</div>
			</div>
			
			
			

			<br />
			<br />

			<div class="row">
				<input type="submit" value="Add" class="btn btn-primary" />
			</div>

		</form:form>
		<div class="row">
			<form action="${pageContext.request.contextPath}/directors"
				method="GET">
				<button class="btn btn-danger">Cancel</button>
			</form>
		</div>
	</div>
</body>
</html>