<%-- 
    Document   : SuppliersInfo
    Created on : 2 Aug, 2018, 10:14:31 AM
    Author     : sourav.mondal
--%>
<%@page import="com.tc.dto.Suppliers"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>
<html>
    <head>
       <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Supplier Info</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Custom styles for this template -->
    <link href="./css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="./menu/menu.jsp"></jsp:include>
        <div class="container-fluid" style="margin-top:50px">
            <form class="form-signin" action="SearchEmployee" method="post">
                <h1 class="h3 mb-3 font-weight-normal">Supplier Details</h1>
                <br>
                <label for="inputEmail" class="sr-only">Name</label>
                <input name="suppName" type="text" id="suppName" class="form-control" value="<s:property value="tempSupplier.suppName"/>" readonly>
                <label for="inputEmail" class="sr-only">Organisation</label>
                <input name="orgName" type="text" id="orgName" class="form-control" value="<s:property value="tempSupplier.orgName"/>" readonly>
                <label for="inputEmail" class="sr-only">Supplier ID</label>
                <input name="suppId" type="text" id="suppId" class="form-control" value="<s:property value="tempSupplier.suppId"/>" readonly>              
            </form>
        </div>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script src="./js/popper.min.js"></script>

</body>

</html>
