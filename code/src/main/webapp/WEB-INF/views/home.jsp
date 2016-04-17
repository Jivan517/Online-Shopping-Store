<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Welcome | Online Book Store</title>
</head>
<body>

	<div class="row">

		<div class="col-md-3"></div>
		<div class="col-lg-6">
			<div class="input-group">
				<input type="text" class="form-control"
					placeholder="Search 7+ Million Books by Title, Author, Publisher or ISBN">
				<span class="input-group-btn">

					<button class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						Search
					</button>
				</span>
			</div>

		</div>

		<div class="col-md-3"></div>
	</div>
	<br />
	<br />
	<br />
	<div class="page-header">
		<h3>Popular Books</h3>
		<small><i>popularity based on selling rate</i></small>
	</div>

</body>
</html>
