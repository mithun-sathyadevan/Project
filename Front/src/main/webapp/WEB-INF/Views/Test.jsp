<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

/* Full-width input fields */


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




</style>
</head>
<body>
   <f:form action="addCategory" style="border:1px solid #ccc" method="post" modelAttribute="cmd">
  <div class="container">
  	 
     <f:label path="cname"><b>Name</b></f:label>
    <f:input  placeholder="Enter Name" path="cname" required="required"></f:input>
   
  
     <div class="clearfix">
      <f:button type="submit" class="signupbtn">Add Category</f:button>
    </div>
  </div>
</f:form>


</body>
</html>