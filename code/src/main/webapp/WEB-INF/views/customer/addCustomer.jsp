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
				<li><a href="${pageContext.request.contextPath}/customer"><h3>Customer </h3></a></li>
				<li class="active"><h3>/ Add Customer</h3></li>
			</ol>
		</div>

		<br />

		<form:form modelAttribute="customer"
			action="${pageContext.request.contextPath}/customer/add" method="post">

		<ui class="active"><h3>Credentials</h3></ui>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Username</span>
						<form:input path="username" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="username" class="alert alert-danger" role="alert" />
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Password</span>
						<form:input type="password" path="password" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="password" class="alert alert-danger" role="alert" />
				</div>
			</div>


		<ui class="active"><h3>Personal Info</h3></ui>
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
			<ui class="active"><h3>Shipping Info</h3></ui>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Country</span>
						<form:input path="shipingAddress.country" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="shipingAddress.country" class="alert alert-danger" role="alert" />
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">State</span>
						<form:input path="shipingAddress.state" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="shipingAddress.state" class="alert alert-danger"
						role="alert" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">City</span>
						<form:input path="shipingAddress.city" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="shipingAddress.city" class="alert alert-danger" role="alert" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Zip</span>
						<form:input path="shipingAddress.zip" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="shipingAddress.zip" class="alert alert-danger"
						role="alert" />
				</div>
				
			</div>
			<br />
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Street</span>
						<form:input path="shipingAddress.street" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="shipingAddress.street" class="alert alert-danger" role="alert" />
				</div>
			</div>
			
			<ui class="active"><h3>Biling Info</h3></ui>
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Country</span>
						<form:input path="bilingAddress.country" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="bilingAddress.country" class="alert alert-danger" role="alert" />
				</div>
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">State</span>
						<form:input path="bilingAddress.state" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="bilingAddress.state" class="alert alert-danger"
						role="alert" />
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">City</span>
						<form:input path="bilingAddress.city" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="bilingAddress.city" class="alert alert-danger" role="alert" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Zip</span>
						<form:input path="bilingAddress.zip" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="bilingAddress.zip" class="alert alert-danger"
						role="alert" />
				</div>
				
			</div>
			<br />
			
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Street</span>
						<form:input path="bilingAddress.street" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="bilingAddress.street" class="alert alert-danger" role="alert" />
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