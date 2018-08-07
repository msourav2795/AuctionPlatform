<%-- 
    Document   : CreateEmployee
    Created on : 11 Jun, 2015, 11:35:06 AM
    Author     : techcluster001
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Insert Employee</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/style.css" rel="stylesheet">
  </head>

  <body class="text-center">
      <jsp:include page="./menu/menu.jsp"></jsp:include>
    <form class="form-signin" action="SearchEmployee" method="post">
      <img class="mb-4" src="./images/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Search Employee</h1>
      <br>


      <label for="inputEmail" class="sr-only">First Name</label>
      <input name="firstName" type="text" id="firstName" class="form-control" placeholder="Enter First Name" required autofocus>
      
     <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>


