<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page session="false" %>
<html>
<head>
	<title>Welcome | Online Book Store</title>
</head>
<body>

<section class="container">
	<form:form modelAttribute="author" class= "form-horizontal">
	<fieldset>
		<legend>Update Author</legend>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "id">Author Id</label>
					<div class="col-lg-10">
						<form:input id="id" path="id" type= "text" class="form:input-large" value = "${author.id}"/>
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "name">First Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type= "text" class="form:input-large" value = "${author.firstName}"/>
					</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "name">Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type= "text" class="form:input-large" value = "${author.lastName}"/>
					</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "email">Email</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type= "text" class="form:input-large"  value = "${author.email}"/>
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "phone">Phone</label>
					<div class="col-lg-10">
						<form:input id="phone" path="phone" type= "text" class="form:input-large" value = "${author.phone}"/>
					</div>
			</div>
			<div class="form-group" action="${pageContext.request.contextPath}/author/update/${author.id}" method="post">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class= "btn btn-primary" value ="Update"/>
				</div>
			</div>


	</fieldset>
	</form:form>
</section>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
