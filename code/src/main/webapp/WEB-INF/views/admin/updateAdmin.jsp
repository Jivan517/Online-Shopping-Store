<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Admin | AJM-Online Book Store</title>
</head>
<body>
	<div class="container">
		<div class="page-header ">

			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/admin"><h3>Admin
						</h3></a></li>
				<li class="active"><h3>/ Update Admin</h3></li>
			</ol>
		</div>

		<br />

		<form:form modelAttribute="admin"
			action="${pageContext.request.contextPath}/admin/update/${admin.id}" method="post"
			enctype="multipart/form-data">

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Name</span>
						<form:input path="title" class="form-control" value = "${admin.name }" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="name" cssStyle="color:red" />
				</div>

				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Email</span>
						<form:input path="isbn" class="form-control" value = "${admin.email }"/>
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="email" cssStyle="color:red" />
				</div>
			</div>
			<br />

			<div>
				<input type="submit" value="Update" class="btn btn-primary" />
			</div>
			<br />
			<br />
		</form:form>
	</div>
</body>
</html>