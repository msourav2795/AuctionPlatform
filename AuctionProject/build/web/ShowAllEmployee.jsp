<%-- 
    Document   : ShowAllEmployee.jsp
    Created on : 12 Jun, 2015, 12:09:20 PM
    Author     : techcluster001
--%>

<%@page import="com.tc.dto.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html>

        
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>List Employee</title>

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

        <div class="container-fluid" style="margin-top:250px">
            <form class="form-signin" action="SearchEmployee" method="post">
                <h1 class="h3 mb-3 font-weight-normal">Search Employee</h1>
                <br>
                <h2></h2>

                <label for="inputEmail" class="sr-only">First Name</label>
                <input name="firstName" type="text" id="firstName" class="form-control" placeholder="Enter First Name"  autofocus>
                <label for="inputEmail" class="sr-only">Designation</label>
                <input name="designation" type="text" id="designation" class="form-control" placeholder="Enter First Name"  autofocus>
                <label for="inputEmail" class="sr-only">Salary</label>
                <input name="salary" type="text" id="salary" class="form-control" placeholder="Enter First Name" autofocus>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
                <button class="btn btn-lg btn-primary btn-block"  id="btnExport" onclick="fnExcelReport();">Export</button>
                <!--     <button type="button" class="btn btn-lg btn-success" style="margin:auto">Success</button>-->

            </form>


            
        <table id="exportTable" class="table table-striped">
            <br><br><br><br><br>S
            <thead>
                <tr>
                    <th>EmployeeId</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Designation</th>
                    <th>Team</th>
                    <th>Contact</th>
                    <th>Salary</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator  value="list">
                    <tr>
                        <td >

                            <a onclick="calls(2)" type="submit" href="#my_modal" data-toggle="modal" data-book-id="my_id_value" id="callData"><s:property value="employeeId"/> </a></td>
                        </td>
                        <td>
                            <s:property value="firstName"/>
                        </td>
                        <td>
                            <s:property value="middleName"/>
                        </td>
                        <td>
                            <s:property value="lastName"/>
                        </td>
                        <td>
                            <s:property value="designation"/>
                        </td>
                        <td>
                            <s:property value="team"/>
                        </td>
                        <td>
                            <s:property value="contact"/>
                        </td>
                        <td>
                            <s:property value="salary"/>
                        </td>
                        <td>
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            <a type="submit" href="#my_modal" data-toggle="modal" data-book-id="my_id_value" id="callData">Open Modal</a></td>
                          
            <div class="modal" id="my_modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                            <h4 class="modal-title">Modal header</h4>
                        </div>
                        <div class="modal-body">
                            <p id="show"></p>
                            
                            <form class="form-signin" action="updateEmployee" method="post" id="formId">
                                <img class="mb-4" src="./images/bootstrap-solid.svg" alt="" width="72" height="72">
                                <h1 class="h3 mb-3 font-weight-normal">Edit Employee Form</h1>
                                <br>
                                <h2></h2>

                                <label for="inputEmail" class="sr-only">First Name</label>
                                <input  name="firstName" type="text" value="<s:property value="firstName"/>" class="form-control" placeholder="Enter First Name" required autofocus>

                            <label for="inputEmail" class="sr-only">Middle Name</label>
                            <input value="<s:property value="middleName"/>" name="middleName" type="text" id="middleName" class="form-control" placeholder="Enter Middle Name" required autofocus>

                            <label for="inputEmail" class="sr-only">Last Name</label>
                            <input value="<s:property value="lastName"/>" name="lastName" type="text" id="lastName" class="form-control" placeholder="Enter Last Name" required autofocus>

                            <label for="inputEmail" class="sr-only">Designation</label>
                            <input value="<s:property value="designation"/>" name="designation" type="text" id="designation" class="form-control" placeholder="Enter Designation" required autofocus>

                            <label for="inputEmail" class="sr-only">Team</label>
                            <input value="<s:property value="team"/>" name="team" type="text" id="team" class="form-control" placeholder="Enter Team" required autofocus>

                            <label for="inputEmail" class="sr-only">Contact</label>
                            <input value="<s:property value="contact"/>" name="contact" type="text" id="contact" class="form-control" placeholder="Enter Contact" required autofocus>

                            <label for="inputEmail" class="sr-only">Salary</label>
                            <input value="<s:property value="salary"/>" name="salary" type="text" id="salary" class="form-control" placeholder="Enter Salary" required autofocus>

                            <input type="hidden" name="employeeId" id="employeeId" value="<s:property value="employeeId"/>">

                            <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>
                            <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
                        </form>
                            
                            
                            
                            
                            
                        </div>
                       
                    </div>
                </div>
            </div>
      
        </tr>
                </s:iterator>
            </tbody>
        </table>



    </div>
<!--    <script type="text/javascript">
	 $(document).on("click", "#callData", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.post("GetEmployee?employeeId=1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                    $("#show").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            });
</script>-->
<script type="text/javascript">
 $(document).ready(function() {
     function calls(elem) {
      alert(elem);
     var xhttp;    
     var str=5;
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      document.getElementById("show").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "GetEmployee?employeeId="+str, true);
  xhttp.send();
     }
 });
</script>
           <script>

        
          function fnExcelReport()
                   {
                         var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
                         var textRange; var j=0;
                         tab = document.getElementById('exportTable'); // id of table
  
                         for(j = 0 ; j < tab.rows.length ; j++) 
                         {     
                               tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
                               //tab_text=tab_text+"</tr>";
                         }
  
                         tab_text=tab_text+"</table>";
   
  
                         var ua = window.navigator.userAgent;
                         var msie = ua.indexOf("MSIE "); 
  
                         if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
                         {
                            txtArea1.document.open("txt/html","replace");
                            txtArea1.document.write(tab_text);
                            txtArea1.document.close();
                            txtArea1.focus(); 
                            sa=txtArea1.document.execCommand("SaveAs",true,"Global View Task.xls");
                         }  
                         else //other browser not tested on IE 11
                            sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  
                           return (sa);
                   }
  
              </script>
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script src="./js/popper.min.js"></script>

 </body>
