<%-- 
    Document   : Login
    Created on : Aug 9, 2016, 9:25:17 PM
    Author     : AVIJIT
--%>
<%@page import="com.tc.dto.Employee"%>
<%@page import="com.tc.dto.Role"%>
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

        <title>User Login</title>

        <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./css/style.css" rel="stylesheet">
        <style>
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
        </style>
    </head>
    <body class="text-center">
        <div  style="width:150px">

            <jsp:include page="./menu/menu.jsp"></jsp:include>
            </div>
            <form class="form-signin" action="Login" method="post">

                <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input name="username" type="text" id="username" class="form-control" placeholder="Username" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input name="password" type="password" id="password" class="form-control" placeholder="Password" required>

                <!--      <div class="checkbox mb-3">
                        <label>
                          <input type="checkbox" value="remember-me"> Remember me
                        </label>
                      </div>-->
               
               
                
                
                
<!--                <select>
                 <s:iterator  value="roleNameList">
                        <option name="roleName" value="<s:property value="roleName"/>"><s:property value="roleName"/></option>
                    </s:iterator>
                  </select>       -->

                    <s:select  
		headerKey="-1" headerValue="Select Role"
		list="roleNameList" 
		name="checkRoleName" 
		 />


            <br><br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="">Sign in</button>
            <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>

    </form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="./js/jquery-slim.min.js"><\/script>')</script>
    <script src="./js/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            
            
            
            
        </script>
</body>
</html>
