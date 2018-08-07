<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form class="form-signin" action="updateBidder" method="post"><!--edited here action and method post will hide and get will show ur credentials-->
    <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Edit Bidder Form</h1>              
    </div>            
    <div class="form-label-group">
        <input value="<s:property value="name"/> "name="name" type="text" id="name" class="form-control" placeholder="Enter Name" required autofocus>
        <label for="name">Name</label>
    </div>

    <div class="form-label-group">
        <input value="<s:property value="username"/> "name="username" type="text" id="username" class="form-control" placeholder="Enter Username" required>
        <label for="username">Username</label>
    </div>        

    <div class="form-label-group">
        <input value="<s:property value="contact"/> "name="contact" type="text" id="contact" class="form-control" placeholder="Enter Contact" required>
        <label for="contact">Contact</label>
    </div>

    <div class="form-label-group">
        <input value="<s:property value="address"/>"name="address" type="text" id="address" class="form-control" placeholder="Enter Address" required>
        <label for="address">Address</label>
    </div>
        
    <input type="hidden" name="id" value="<s:property value="id"/>" id="bidderId">
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    <p class="mt-5 mb-3 text-muted text-center">&copy; 2018-2019</p>
</form>