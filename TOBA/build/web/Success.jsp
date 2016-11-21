<%-- 
    Document   : Success
    Created on : Nov 2, 2016, 5:59:08 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />

    
        <h1>Titan Online Banking</h1>
    
        <p>Account successful Created!</p>
        <p>Here is your user information</p>
        
        <label>Username:</label>
        <span>${user.userName}</span><br>
        
        <label>Password:</label>
        <span>${user.password}</span><br>
        
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        
        <label>Address:</label>
        <span>${user.address}</span><br>
        
        <label>City:</label>
        <span>${user.city}</span><br>
        
        <label>State:</label>
        <span>${user.state}</span><br>
        
        <label>Zip Code:</label>
        <span>${user.zipCode}</span><br>
        
        <label>Email:</label>
        <span>${user.email}</span><br>
        
        
        <a href="Login.jsp" >Login HERE</a>

        <c:import url="include/footer.jsp" />