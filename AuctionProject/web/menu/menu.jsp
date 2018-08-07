<%@page import="com.tc.dto.Bidders" %>
<%@page import="com.tc.dto.Suppliers" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">
        <img src="https://getbootstrap.com/docs/4.1/assets/brand/bootstrap-solid.svg" alt="" width="32" height="32">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="HomePage.jsp">Home <span class="sr-only">(current)</span></a>
            </li> 
            <c:if test="${user.isLoggedIn}">
                <li class="nav-item active">
                    <a class="nav-link" href="BiddersInfo.jsp">Profile <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="auctionDetail">Auctions <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Logoff">Logoff <span class="sr-only">(current)</span></a>
                </li>
            </c:if>
            <c:if test="${!user.isLoggedIn}">
                <li class="nav-item active">
                    <a class="nav-link" href="Role">Login</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Registration</a>
                </li>
            </c:if>

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <button class="btn-primary"> Welcome ${user.username}</button>
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


</div>

<!-- END OF PULL DOWN MENU -->
</body>
</html>
