<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">All Categories</a></li>
      <li><a href="#">Children's</a></li> 
      <li><a href="#">Teens</a></li> 
      <li><a href="#">Literature & Fiction</a></li> 
      <li><a href="#">Mystery & Thriller</a></li>
      <li><a href="#">Sci-Fi & Fantasy</a></li>
      <li><a href="#">Romance</a></li> 
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>