<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/css" var="css"></c:url>
<c:url value="/resources/js" var="js"></c:url>
<c:url value="/resources/images" var="images"></c:url>
<!DOCTYPE html>
<html lang="en">
<style>

#search {
    float: right;
    margin-top: 9px;
    width: 500px;
}

.search {
    padding: 5px 0;
    width: 230px;
    height: 30px;
    position: relative;
    left: 10px;
    float: left;
    line-height: 22px;
}

    .search input {
        position: absolute;
        width: 0px;
        float: Left;
        margin-left: 210px;
        -webkit-transition: all 0.7s ease-in-out;
        -moz-transition: all 0.7s ease-in-out;
        -o-transition: all 0.7s ease-in-out;
        transition: all 0.7s ease-in-out;
        height: 30px;
        line-height: 18px;
        padding: 0 2px 0 2px;
        border-radius:1px;
    }

        .search:hover input, .search input:focus {
            width: 200px;
            margin-left: 0px;
        }

.btn {
    height: 30px;
    position: absolute;
    right: 0;
    top: 5px;
    border-radius:1px;
}

</style>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
<!-- jQuery -->
<script src="${js}/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${js}/bootstrap.min.js"></script>

</head>
<body>
	<!-- Navigation -->
	<%@include file="./include/nav.jsp"%>

	
	<div class="container">
		<div class="row">
			<h2>${categoryname}</h2>
			<form action="search/${cid}">
			<div class="search">
				<input type="text" class="form-control input-sm" "maxlength="64"
					placeholder="Search" />
				<button type="submit" class="btn btn-primary btn-sm">Search</a></button>
			</div>
			</form>
		</div>
	</div>

	<br>
	<br>

	<c:forEach var="product" items="${productlist}">

		<div class="col-sm-4 col-lg-4 col-md-4">
			<div class="thumbnail">
				<img src="${images}/${product.image}" style="height: 200px;" alt="">
				<div class="caption">
					<h4 class="pull-right">RS:${product.price}</h4>
					<h4>
						<a href="#">${product.name}</a>
					</h4>
					<p>${product.details}</p>
				</div>

			</div>
		</div>




	</c:forEach>



















</body>
</html>