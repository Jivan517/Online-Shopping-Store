<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/onlineshoppingstore">AJM - Online
				Book Store</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="${pageContext.request.contextPath}/books/category/children">Children's</a></li>
			<li><a href="${pageContext.request.contextPath}/books/category/literature">Literature & Fiction</a></li>
			<li><a href="${pageContext.request.contextPath}/books/category/mystery">Mystery & Thriller</a></li>
			<li><a href="${pageContext.request.contextPath}/books/category/sciFi">Sci-Fi & Fantasy</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><form action="shoppingcart" method="get"
					style="margin-top: 5px;; margin-right: 5px;">
					<button class="btn btn-info">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
						Cart
					</button>
				</form></li>

			<sec:authorize access="isAuthenticated()">

				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><div class="dropdown" style="margin-top: 5px">
							<button class="btn btn-primary dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								<sec:authentication property="principal.username" />
								|Admin Panel <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="${pageContext.request.contextPath}/admin">Admin
										User</a></li>
								<li><a href="${pageContext.request.contextPath}/author">Author</a></li>
								<li><a href="${pageContext.request.contextPath}/publisher">Publisher</a></li>
								<li><a href="${pageContext.request.contextPath}/books">Book</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="${pageContext.request.contextPath}/customer">Customer</a></li>

							</ul>
						</div></li>
				</sec:authorize>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_USER')">
					<%-- 	           <li><a href="#"><font color="yellow"> <sec:authentication property="principal.username" /></font></a></li> --%>
					<li><a href="${pageContext.request.contextPath}/order/orderhistory"><font color="yellow"> <sec:authentication
									property="principal.username" /> | Order History
						</font></a></li>
				</sec:authorize>
			</sec:authorize>

			
			<sec:authorize access="isAnonymous()">
				<li><a href="${pageContext.request.contextPath}/customer/add"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</sec:authorize>

		</ul>
	</div>
</nav>
