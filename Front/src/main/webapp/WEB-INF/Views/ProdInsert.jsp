
<%@page import="com.niit.backend.domain.Supplier"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/resources/css" var="css"></c:url>
<c:url value="/resources/js" var="js"></c:url>
<c:url value="/resources/images" var="images"></c:url>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">
<!-- jQuery -->
<script src="${js}/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${js}/bootstrap.min.js"></script>

<style>

/* Full-width input fields */

/* Set a style for all buttons */
.custab {
	border: 1px solid #ccc;
	padding: 5px;
	margin: 5% 0;
	box-shadow: 3px 3px 2px #ccc;
	transition: 0.5s;
}

.custab:hover {
	box-shadow: 3px 3px 0px transparent;
	transition: 0.5s;
}

.tex {
	width: 100%;
	padding: 12px 20px;
	margin: 1px 0;
	display: inline-block;
	border: 1px solid #ccc;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}

/* Add padding to container elements */

/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 50%;
	}
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
			localStorage.setItem('activeTab', $(e.target).attr('href'));
		});
		var activeTab = localStorage.getItem('activeTab');
		if (activeTab) {
			$('#myTab a[href="' + activeTab + '"]').tab('show');
		}
	});
</script>
</head>
<body>
 <%@include file="./include/nav.jsp" %>
 <br>
	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a data-toggle="tab" href="#sectionA">Product</a></li>
		<li><a data-toggle="tab" href="#sectionB">Category</a></li>
		<li><a data-toggle="tab" href="#sectionC">Supplier</a></li>
		<li><a data-toggle="tab" href="#sectionD">ProductList</a></li>
	</ul>
	<div class="tab-content">
		<div id="sectionA" class="tab-pane fade in active">
			<h3>Product Insert</h3>



			<form action="addProduct" style="border: 1px solid #ccc"
				method="post" enctype="multipart/form-data">
				<div class="container">
					<label><b>Name</b></label> <input type="text" name="name"
						class="tex" required /> <label><b>Price</b></label> <input
						type="number" name="price" class="tex"   required  />
						 <label><b>Image</b></label>
					<input name="image" type="file" class="tex" required ></input> <label><b>Category</b></label>
					<select class="form-control" name="category">

						<option value="">----Category---</option>
						<c:forEach items="${categorylist}" var="cate">
							<option value="${cate.cid}">${cate.cname}</option>
						</c:forEach>
					</select> <label><b>Supplier</b></label> <select class="form-control"
						name="supplier">

						<option value="">----Supplier---</option>
						<c:forEach items="${supplierlist}" var="sup">
							<option value="${sup.sid}">${sup.sname}</option>
						</c:forEach>
					</select> <label><b>Details</b></label> <input name="details" class='tex'  required ></input>


					<label><b>Colour</b></label> <input name="color" class="tex"  required></input>


					<label><b>Quantity</b></label> <input type="number" name="quantity" class="tex"  required ></input>


					<div class="clearfix">
						<button type="submit" class="signupbtn">Add Product</button>
					</div>
				</div>
			</form>


		</div>



		<div id="sectionB" class="tab-pane fade">
			<table class="table table-striped custab">
				<thead>

					<tr>
						<th>Category Name</th>
					</tr>
				</thead>
				<c:forEach var="category" items="${categorylist}">



					<div class="row col-md-6 col-md-offset-2 custyle">


						<tr>
							<td><c:out value="${category.cname}"></c:out></td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a>
								<a href="deleteCategory/${category.cid}"
								class="btn btn-danger btn-xs"><span
									class="glyphicon glyphicon-remove"></span> Del</a></td>
						</tr>


					</div>
				</c:forEach>
			</table>

			<f:form action="addCategory" method="post" modelAttribute="cmd">


				<f:input style="width: 550px;" placeholder="Enter Name" path="cname"
					required="required"></f:input>
				<f:button type="submit">Add Category</f:button>



			</f:form>












		</div>






		<div id="sectionC" class="tab-pane fade">
			<table class="table table-striped custab">
				<thead>

					<tr>
						<th>Suppier Name</th>
					</tr>
				</thead>
				<c:forEach var="supplier" items="${supplierlist}">



					<div class="row col-md-6 col-md-offset-2 custyle">


						<tr>
							<td><c:out value="${supplier.sname}"></c:out></td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a>
								<a href="deleteSupplier/${supplier.sid}"
								class="btn btn-danger btn-xs"><span
									class="glyphicon glyphicon-remove"></span> Del</a></td>
						</tr>


					</div>
				</c:forEach>
			</table>
			<f:form action="addSupplier" method="post" modelAttribute="cmd1">


				<f:input style="width: 550px;" placeholder="Enter Supplier Name "
					path="sname" required="required"></f:input>
				<f:button type="submit">Add Supplier</f:button>






			</f:form>


		</div>
		<div id="sectionD" class="tab-pane fade">


			<table class="table table-striped custab">
				<thead>

					<tr>
						<th>Image</th>
						<th>Name</th>
						<th>Price</th>
						<th>Category</th>
						<th>Supplier</th>
						<th>Quantity</th>
						<th>Details</th>
						<th>colour</th>

					</tr>
				</thead>
				<c:forEach var="product" items="${productlist}">



					<div class="row col-md-6 col-md-offset-2 custyle">


						<tr>
							<td><img src ="${images}/${product.image}" height="50px" width="50px"/></td>
							<td><c:out value="${product.name}"></c:out></td>
							<td><c:out value="${product.price}"></c:out></td>
							<td><c:out value="${product.category.cname}"></c:out></td>
							<td><c:out value="${product.supplier.sname}"></c:out></td>
							<td><c:out value="${product.quantity}"></c:out></td>
							<td><c:out value="${product.details}"></c:out></td>
							<td><c:out value="${product.color}"></c:out></td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="#"><span class="glyphicon glyphicon-edit"></span> Edit</a>
								<a href="deleteProduct/${product.id}"
								class="btn btn-danger btn-xs"><span
									class="glyphicon glyphicon-remove"></span> Del</a></td>
						</tr>


					</div>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>