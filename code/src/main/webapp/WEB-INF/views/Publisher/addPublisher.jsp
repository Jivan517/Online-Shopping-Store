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
	<form:form modelAttribute="publisher" class= "form-horizontal">
	<fieldset>
		<legend>Add new publisher</legend>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "id">Publisher Id</label>
					<div class="col-lg-10">
						<form:input id="id" path="id" type= "text" class="form:input-large"/>
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "name">Publisher Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type= "text" class="form:input-large"/>
					</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "email">Email</label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type= "text" class="form:input-large"/>
					</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for= "phone">Phone</label>
					<div class="col-lg-10">
						<form:input id="phone" path="phone" type= "text" class="form:input-large"/>
					</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class= "btn btn-primary" value ="Add"/>
				</div>
			</div>


	</fieldset>
	</form:form>
</section>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
