<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 5px;
	margin-bottom: 10px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #FF0000;
	background-color: #f2dede;
	border-color: #ebccd1;
}
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<div id="login-box">

		<h2>Login </h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<c:url value="${request.contextPath}/j_spring_security_check" var="loginUrl" />
		<form name='loginForm' action="${loginUrl}" method='POST'>

			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span> User</span>
						<input type='text' name='username'  />
					</div>
				</div>

				
			</div>
			<br />
			<div class="row">
				<div class="col-md-4">
					<div class="input-group">
						<span> Password</span>
						<input type='password' name='password'  />
					</div>
				</div>
				
			</div>
			<br />
			

			<div>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>
