<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
</head>
<body>
<div class="container">
		<div class="page-header ">

			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/publisher/"><h3>Publishers </h3></a></li>
				<li class="active"><h3>/ Add Publisher</h3></li>
			</ol>
		</div>

		<br />

		<form:form modelAttribute="publisher"
			action="${pageContext.request.contextPath}/publisher/add" method="post">

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1"> Name</span>
						<form:input path="name" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="name" class="alert alert-danger" role="alert" />
				</div>

				
			</div>
			<br />

			
			<div class="row">
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
						<span class="input-group-addon" id="basic-addon1">Phone</span>
						<form:input path="phone" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="phone" class="alert alert-danger"
						role="alert" />
				</div>

				
			</div>
			<br />
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
