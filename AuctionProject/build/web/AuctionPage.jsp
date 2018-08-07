<%-- 
    Document   : AllAuctionDetails
    Created on : Jul 26, 2018, 8:38:45 PM
    Author     : msour
--%>


<%@page import="com.tc.dto.AuctionProduct"%>
<%@page import="com.tc.dto.Bid"%>
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

    <title>Auction Info</title>

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
        <div class="container">
            <h1 class="h1 mb-3 font-weight-normal" style="text-align: center">Auction Details</h1>
            <br>
            <div class="text-center mb-3">
                <form class="form-signin" action="setBid" method="post">
                    <div class="form-control">
                        <label for="inputEmail" class="sr-only">Auction Type</label>
                        <input name="auctionType" type="text" id="auctionType" class="form-control" value="<s:property value="auctionType"/>"  readonly>
                    <label for="inputEmail" class="sr-only">Product Name</label>
                    <input name="productName" type="text" id="productName" class="form-control" value="<s:property value="productName"/>"  readonly>
                    <label for="inputEmail" class="sr-only">Base Price</label>
                    <input name="basePrice" type="text" id="basePrice" class="form-control" value="Base Price: <s:property value="bid.basePrice"/>"  readonly>
                    <label for="inputEmail" class="sr-only">Max Price</label>
                    <input name="maxPrice" type="text" id="maxPrice" class="form-control" value="Max Price: <s:property value="bid.maxPrice"/>"  readonly>
                    <label for="inputEmail" class="sr-only">Auction Date</label>
                    <input name="auctionDate" type="text" id="auctionDate" class="form-control" value="<s:property value="auctionDate"/>"  readonly>
                    <label for="inputEmail" class="sr-only">Bid Price</label>
                    <input name="biddersPriceTemp" type="text" id="biddersPriceTemp" class="form-control" placeholder="Bid Price" required autofocus>
                    <input name="biddersIdTemp" type="hidden" id="biddersIdTemp" class="form-control" value="<s:property value="bid.biddersId"/>" readonly>
                    <input name="auctionId" type="hidden" id="auctionId" class="form-control" value="<s:property value="auctionId"/>"  readonly>    
                    <input name="productId" type="hidden" id="productId" class="form-control" value="<s:property value="productId"/>"  readonly>
                    <button class="btn btn-lg btn-primary btn-block" onclick="myFunction()" type="submit">Set Bid</button>
                    <br>
                </div>
            </form>
        </div>
    </div>
    <!--    <script type="text/javascript">
             $(document).on("click", "#callData", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                    $.post("GetEmployee?employeeId=1", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $("#show").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                    });
                });
    </script>-->
    <script>
        function myFunction() {
            var price=document.getElementById("biddersPriceTemp");
            var maxPrice=document.getElementById("maxPrice");
            System.out.println("maxPrice" + maxPrice);
            System.out.println("price" + price);
            if((maxPrice-price) < 500)
                alert("Enter Price greater than "+(maxPrice+500));
        }
    </script>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><script src="./js/popper.min.js"></script>

</body>
