<%-- 
    Document   : ShowAllEmployee.jsp
    Created on : 12 Jun, 2015, 12:09:20 PM
    Author     : techcluster001
--%>

<%@page import="com.tc.dto.Bidders"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/favicon.ico">

    <title>Bidder Info</title>

    <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Custom styles for this template -->
        <link href="./css/floating-labels.css" rel="stylesheet">
        <script src="./js/jquery-3.3.1.slim.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
</head>
<body>


    <jsp:include page="./menu/menu.jsp"></jsp:include>
        <div class="container">
            <h1 class="h1 mb-3 font-weight-normal" style="text-align: center">Bidder Details</h1>
            <br>
            <table class="table table-striped" id="show">
                <th>
                    Bidder ID
                </th>
                <th>
                    Name
                </th>                
                <th>
                    Username
                </th>
                <th>
                    Status
                </th>
                <th>
                    Contact
                </th>
                <th>
                    Address
                </th>               


                <tr>
                    <td>
                        <input name="name" type="text" id="id" class="form-control" value="${bidder.id}" readonly/>
                </td> 
                <td>
                    <input name="name" type="text" id="name" class="form-control" value="${bidder.name}" readonly/>
                </td> 
                <td>
                    <input name="name" type="text" id="username" class="form-control" value="${bidder.username}" readonly/>
                </td>
                <td>
                    <input name="name" type="text" id="status" class="form-control" value="${bidder.status}" readonly/>
                </td>
                <td>
                    <input name="address" type="text" id="contact" class="form-control" value="${bidder.contact}" readonly/>
                </td>
                <td>
                    <input name="contact" type="text" id="address" class="form-control" value="${bidder.address}" readonly/>
                </td>                        
            </tr>           
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body" id="show">

                        </div>                                
                    </div>
                </div>
            </div>
        </table>
        <div style="width:400px;margin: auto">
            <button class="btn btn-lg btn-primary" data-toggle="modal" data-target="#myModal" onclick="editUser(${bidder.id})">Edit Details</button> 
            <a class="btn btn-primary btn-lg" href="auctionDetail" role="button">Go to Auction Page &raquo;</a>
        </div>
            
            
    </div>   
    <script>
        function editUser(bidderId) {
            jQuery.ajax({
                url: "GetBidder?id=" + bidderId,
                success: function (result) {
                    $("#show").html(result);
                    $("#myModal").show();
                }});
        }
    </script>
    <!--    <script type="text/javascript">
             $(document).on("click", "#callData", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                    $.post("GetEmployee?employeeId=1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $("#show").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                    });
                });
    </script>-->
    <script type="text/javascript">
        $(document).ready(function () {
            function calls(elem) {
                alert(elem);
                var xhttp;
                var str = 5;
                xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        document.getElementById("show").innerHTML = this.responseText;
                    }
                };
                xhttp.open("POST", "GetEmployee?employeeId=" + str, true);
                xhttp.send();
            }
        });
    </script>
    <script>
        function fnExcelReport()
        {
            var tab_text = "<table border='2px'><tr bgcolor='#87AFC6'>";
            var textRange;
            var j = 0;
            tab = document.getElementById('exportTable'); // id of table

            for (j = 0; j < tab.rows.length; j++)
            {
                tab_text = tab_text + tab.rows[j].innerHTML + "</tr>";
                //tab_text=tab_text+"</tr>";
            }

            tab_text = tab_text + "</table>";


            var ua = window.navigator.userAgent;
            var msie = ua.indexOf("MSIE ");

            if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
            {
                txtArea1.document.open("txt/html", "replace");
                txtArea1.document.write(tab_text);
                txtArea1.document.close();
                txtArea1.focus();
                sa = txtArea1.document.execCommand("SaveAs", true, "Global View Task.xls");
            }
            else //other browser not tested on IE 11
                sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));
            return (sa);
        }

    </script>
    <!-- jQuery library -->
    
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script src="./js/popper.min.js"></script>

</body>
