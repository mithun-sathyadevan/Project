
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources/css" var="css"></c:url>
<c:url value="/resources/js" var="js"></c:url>
<c:url value="/resources/images" var="images"></c:url>
<!DOCTYPE html>
<html>
<head>
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
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
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
.error {
	color: red;
}

</style>
</head>
<body>
 
 <!-- Navigation -->
    <%@include file="./include/nav.jsp" %>

    <!-- Page Content -->
<br>
<br>
<h2>Signup Form</h2>

<f:form action="newRegister" style="border:1px solid #ccc" method="post" modelAttribute="cmd">
  <div class="container">
  <f:errors path="email"></f:errors>
  	 <f:label path="name"><b>Name</b></f:label>
    <f:input  placeholder="Enter Name" path="name" required="required"></f:input>
   
    
    
     <f:label path="number"><b>Number</b></f:label>
    <f:input placeholder="Enter Number" path="number" required="required"></f:input>
    
    
    
    <f:label path="email"><b>Email</b></f:label>
    <f:input  placeholder="Enter Email" path="email" required="required"></f:input>
    <f:errors   path="email" cssClass="error"></f:errors>
    
     <f:label path="city"><b>City</b></f:label>
    <f:input  placeholder="City" path="city" required="required"></f:input>
    
   
    <f:label path="psw"><b>Password</b></f:label>
    <f:input  placeholder="Enter Password" path="psw" required="required"></f:input>
	
  
    <div class="clearfix">
      <f:button type="submit" class="signupbtn">Sign Up</f:button>
    </div>
  </div>
</f:form>

</body>
</html>
