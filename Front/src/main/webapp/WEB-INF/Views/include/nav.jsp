<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
                    <h1>Eat Bangalore
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="${contextRoot}/home">Home</a>
                        </li>
                        <li class="dropdown"> <a  type="button" data-toggle="dropdown">CATEGORY
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                              <c:forEach var="catVal" items="${catList}">
                          <li><a href="${contextRoot}/ProductList/${catVal.cid}">${catVal.cname}</a></li>
                     </c:forEach>

                            </ul></li>
                        <li>
                            <a href="${contextRoot}/Contact">Contact</a>
                        </li>
    <c:if test="${pageContext.request.userPrincipal.name== null}">                        
                        <li>    <a href="${contextRoot}/Login">Login</a></c:if></li>
                             <c:if test="${pageContext.request.userPrincipal.name!= null}">
    
    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                           <li> <a href="${contextRoot}/Logout">Logout</a>
                        </li>
                        <li>
                        <c:if test="${pageContext.request.userPrincipal.name  == 'ms111mithun@gmail.com'}">
                                <li><a href="<c:url value="/Admin" />">Admin</a></li>
                            </c:if>
                        </li>
                        </c:if>
                      <li> <a href="${contextRoot}/ShoppingCart/${pageContext.request.userPrincipal.name}/">
          <span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart
        </a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->

               
            </div>
            <!-- /.container -->
        </nav>