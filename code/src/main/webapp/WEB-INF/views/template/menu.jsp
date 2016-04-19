<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <ul style="list-style:none;line-height:28px;"> -->

<%-- 	<li><spring:url value="/home" var="homeUrl" htmlEscape="true" /> --%>
<%-- 		<a href="${homeUrl}">Home</a> --%>
<!-- 	</li> -->

<%-- 	<li><spring:url value="/home" var="personListUrl" htmlEscape="true" /> --%>
<%-- 		<a href="${personListUrl}">Product</a> --%>
<!-- 	</li> -->

<!-- </ul> -->

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">AJM - Online Book Store</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/onlineshoppingstore">Home</a></li>
			<li><a href="#">All Categories</a></li>
			<li><a href="#">Children's</a></li>
			<li><a href="#">Teens</a></li>
			<li><a href="#">Literature & Fiction</a></li>
			<li><a href="#">Mystery & Thriller</a></li>
			<li><a href="#">Sci-Fi & Fantasy</a></li>
			<li><a href="#">Romance</a></li>


		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<form action="shoppingcart" method = "GET">
					<button class="btn btn-primary btn-lg"
					style="margin: 2px;" type="submit">
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
					Cart
				</button>
				</form>
				
			</li>
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>
					Sign Up</a></li>
			<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
		</ul>
	</div>
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">AJM - Online Book Store</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/onlineshoppingstore">Home</a></li>
      <li><a href="#">All Categories</a></li>
      <li><a href="#">Children's</a></li> 
      <li><a href="#">Teens</a></li> 
      <li><a href="#">Literature & Fiction</a></li> 
      <li><a href="#">Mystery & Thriller</a></li>
      <li><a href="#">Sci-Fi & Fantasy</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      
      
      <sec:authorize access="isAuthenticated()">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        	<li class="dropdown"><a href="#"><font color="yellow" class="dropbtn"><sec:authentication property="principal.username" /> | To Admin Panel </font></a></li>
      	</sec:authorize>
      </sec:authorize>  
      
      <sec:authorize access="isAuthenticated()">
	        <sec:authorize access="hasRole('ROLE_USER')">
<%-- 	           <li><a href="#"><font color="yellow"> <sec:authentication property="principal.username" /></font></a></li> --%>
	           <li><a href="#"><font color="yellow"> <sec:authentication property="principal.username" /> | Write Review</font></a></li>
	      	</sec:authorize>
       </sec:authorize>          
     
      <sec:authorize access="isAnonymous()">
      	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     	 <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </sec:authorize>      
     
      <sec:authorize access="isAuthenticated()">
      <li><a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </sec:authorize>
      
    </ul>
  </div>
</nav>
