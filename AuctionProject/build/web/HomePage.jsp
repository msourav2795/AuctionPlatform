<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Homepage</title>

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/jumbotron.css" rel="stylesheet">
  </head>

  <body>
      <div  style="width:50px">

    <jsp:include page="./menu/menu.jsp"></jsp:include>
      </div>
    <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">Welcome to Online Auction Platform</h1>
          <p>The scope and reach of these auctions have been propelled by the Internet to a level beyond what the initial purveyors had anticipated. It break down and removes the physical limitations of traditional auctions such as geography, presence, time, space, and a small target audience.This influx in reachability has also made it easier to commit unlawful actions within an auction.</p>
          <p><a class="btn btn-primary btn-lg" href="Role" role="button">Take a tour &raquo;</a></p>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2>BIDDER</h2>
            <p>Participate in different kind of biddings. You can make bid for variety of products ranging from metal, coal, value-based thimgs and much more.</p>
            <p><a class="btn btn-secondary" href="Role.jsp" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>SUPPLIER</h2>
            <p>Supply variety of products for auction and increase your profit by a great margin. You get the privileges to set the quantity, base price, and many more things for the auction </p>
            <p><a class="btn btn-secondary" href="Role.jsp" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>ADMINISTRATOR</h2>
            <p>As an Administrator you can initiate an auction for your organization. You get to avail a lot of privileges.</p>
            <p><a class="btn btn-secondary" href="Role.jsp" role="button">View details &raquo;</a></p>
          </div>
        </div>

        <hr>

      </div> <!-- /container -->

    </main>

    <footer class="container">
      <p>&copy; Company 2017-2018</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./js/jquey-3.3.1.slim.min" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="./js/popper.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>
