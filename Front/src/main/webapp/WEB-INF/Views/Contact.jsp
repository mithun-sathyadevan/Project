
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/css" var="css"></c:url>
<c:url value="/resources/js" var="js"></c:url>
<c:url value="/resources/images" var="images"></c:url>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here
</title>
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
    <%@include file="./include/nav.jsp" %>
    <br><br>
    <br><br>
      <div class="panel panel-info">
      <div class="panel-heading">Contact Us</div>
      <div class="panel-body">
       <div class="row">
        <h1 class="main-heading">OFFICE LOCATIONS</h1>
        <div class="col-md-12 text-center">
          <div class="list">
            <ul>
              <h3>Corporate Headquarters</h3>
              <div class="cust-thumbnail aligncenter"> <img src="${images}/office.jpg"> </div>
              Eat Bangalore, LLC <br>
              2400 Louisiana Blvd Building 3 <br>
              Albuquerque,Jaya Nagar 87110 <br>
              Telephone:  <a href="Tel:+1 505 217 3725"> +1 505 217 3725</a> <br>
              <div class="spacer"></div>
            </ul>
          </div>
        </div>
      
      
      </div>
    </div>
</body>
</html>