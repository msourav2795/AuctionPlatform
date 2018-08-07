<!doctype html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Supplier Registration page</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/floating-labels.css" rel="stylesheet">
  </head>

  <body >
      <
       <jsp:include page="./menu/menu.jsp"></jsp:include>

    <form class="form-signin" action="Login" method="post" style="margin-top:100px">
      <div class="text-center mb-4">
          <h1 class="h3 mb-3 font-weight-normal"><b>Supplier Registration</b></h1>
      </div>
        
        <div class="form-label-group">
          <input name="suppName" type="text" id="suppName" class="form-control" placeholder="Enter Supplier Name" required autofocus>
        <label for="suppName">Supplier Name</label>
      </div>
        
       <div class="form-label-group">
           <input name="orgName" type="text" id="orgName" class="form-control" placeholder="Enter Organization Name" required >
        <label for="orgName">Organization Name</label>
      </div>
      
      <div class="form-label-group">
          <input name="username" type="text" id="username" class="form-control" placeholder="Enter UserName" required>
        <label for="username">Username</label>
      </div>
   
            <div class="form-label-group">
          <input name="password" type="password" id="password" class="form-control" placeholder="Enter Password" required>
        <label for="password">Password</label>
      </div>


    
     
      <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
  </body>
</html>
