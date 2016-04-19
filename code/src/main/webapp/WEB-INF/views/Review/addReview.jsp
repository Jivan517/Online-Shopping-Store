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
				<li><a href="${pageContext.request.contextPath}/reviews/"><h3>Review </h3></a></li>
				<li class="active"><h3>/ Add Review</h3></li>
			</ol>
		</div>
		
		<br />

		<form:form modelAttribute="author"
			action="${pageContext.request.contextPath}/author/add" method="post">

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Book Title</span>
						<form:input path="firstName" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="firstName" cssStyle="color:red"/>
				</div>

				
			</div>
			<br />

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">Last Name</span>
						<form:input path="lastName" class="form-control" />
					</div>
				</div>
				<div class="col-md-2">
					<form:errors path="lastName" cssStyle="color:red"/>
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
					<form:errors path="email" cssStyle="color:red"/>
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
					<form:errors path="phone" cssStyle="color:red"
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
