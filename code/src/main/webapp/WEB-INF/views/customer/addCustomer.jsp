<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer | AJM-Online Book Store</title>
</head>
<body>
	<div class="container">
		<div class="page-header ">

			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/customer"><h3>Books </h3></a></li>
				<li class="active"><h3>/ Add Book</h3></li>
			</ol>
		</div>

		<br />

		<form:form modelAttribute="customer"
			action="${pageContext.request.contextPath}/customer/add" method="post">

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Name</span>
						<form:input path="name" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="name" class="alert alert-danger" role="alert" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Email</span>
						<form:input path="email" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="email" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br />

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Country</span>
						<form:input path="country" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="country" class="alert alert-danger" role="alert" />
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">State</span>
						<form:input path="state" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="state" class="alert alert-danger"
						role="alert" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">City</span>
						<form:input path="city" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="city" class="alert alert-danger" role="alert" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Zip</span>
						<form:input path="zip" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="zip" class="alert alert-danger"
						role="alert" />
				</div>
			</div>
			<br />
	
			<div>
				<input type="submit" value="Add" class="btn btn-primary" />
			</div>
			
			<br/>
			<br/>
		</form:form>
	</div>
</body>
</html>