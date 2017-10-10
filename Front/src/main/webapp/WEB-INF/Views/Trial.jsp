
<%@page import="com.niit.backend.domain.Supplier"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

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
<link rel="stylesheet" href="/path/to/bootstrap.min.css">
<script src="/path/to/jquery.min.js"></script>
<script src="/path/to/bootstrap.min.js"></script>
<script src="js/jquery.mycart.js"></script>
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
.custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
.tex{
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
.cancelbtn,.signupbtn {
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
$(document).ready(function(){
    $('a[data-toggle="tab"]').on('show.bs.tab', function(e) {
        localStorage.setItem('activeTab', $(e.target).attr('href'));
    });
    var activeTab = localStorage.getItem('activeTab');
    if(activeTab){
        $('#myTab a[href="' + activeTab + '"]').tab('show');
    }
});
</script>
</head>
<body>
<%@include file="./include/nav.jsp" %>
<br><br>
<div class="row">
  <div class="col-md-3 text-center">
    <img src="images/img_1.png" width="150px" height="150px">
    <br>
    product 1 - <strong>$10</strong>
    <br>
    <button class="btn btn-danger my-cart-btn" data-id="1" data-name="product 1" data-summary="summary 1" data-price="10" data-quantity="1" data-image="images/img_1.png">Add to Cart</button>
    <a href="#" class="btn btn-info">Details</a>
  </div>

  <div class="col-md-3 text-center">
    <img src="images/img_2.png" width="150px" height="150px">
    <br>
    product 2 - <strong>$20</strong>
    <br>
    <button class="btn btn-danger my-cart-btn" data-id="2" data-name="product 2" data-summary="summary 2" data-price="20" data-quantity="1" data-image="images/img_2.png">Add to Cart</button>
    <a href="#" class="btn btn-info">Details</a>
  </div>

  <div class="col-md-3 text-center">
    <img src="images/img_3.png" width="150px" height="150px">
    <br>
    product 3 - <strong>$30</strong>
    <br>
    <button class="btn btn-danger my-cart-btn" data-id="3" data-name="product 3" data-summary="summary 3" data-price="30" data-quantity="1" data-image="images/img_3.png">Add to Cart</button>
    <a href="#" class="btn btn-info">Details</a>
  </div>

  <div class="col-md-3 text-center">
    <img src="images/img_4.png" width="150px" height="150px">
    <br>
    product 4 - <strong>$40</strong>
    <br>
    <button class="btn btn-danger my-cart-btn" data-id="4" data-name="product 4" data-summary="summary 4" data-price="40" data-quantity="1" data-image="images/img_4.png">Add to Cart</button>
    <a href="#" class="btn btn-info">Details</a>
  </div>

  <div class="col-md-3 text-center">
    <img src="images/img_5.png" width="150px" height="150px">
    <br>
    product 5 - <strong>$50</strong>
    <br>
    <button class="btn btn-danger my-cart-btn" data-id="5" data-name="product 5" data-summary="summary 5" data-price="50" data-quantity="1" data-image="images/img_5.png">Add to Cart</button>
    <a href="#" class="btn btn-info">Details</a>
  </div>

</div>
</body>
</html>