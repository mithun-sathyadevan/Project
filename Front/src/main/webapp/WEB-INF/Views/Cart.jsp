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
</head>
<body>
<%@include file="./include/nav.jsp"%>
<br><br>
<div class="container">

    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <c:set var="total"/>
                <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
		<c:forEach var="cart" items="${cartlist}">                
                
                <tbody>
                
                    <tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${images}/${cart.image}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading">${cart.name}</h4>
                                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        
                        <input type="email" class="form-control" id="exampleInputEmail1" value="${cart.quantity}" />
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>Rs${cart.price}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>Rs${cart.price*cart.quantity}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        ${total=total+cart.price*cart.quantity}
                        <a href="${contextroot}/Front/removeCart/${cart.cartid}/${pageContext.request.userPrincipal.name}/" ><button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></a></td>
                    </tr>
               
                </tbody>
	</c:forEach>>



                <tfoot>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal<h3>Rs:${total}</h3></h5></td>
                       
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="${contextroot}/Front/home">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></a>
                        
                        </td>
                        <td>
                      <a href="${contextroot}/Front/checkout">  <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></a></td>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
  <!-- /.container -->

      <%@include file="./include/Footer.jsp" %>
    <!-- /.container -->
</body>
</html>