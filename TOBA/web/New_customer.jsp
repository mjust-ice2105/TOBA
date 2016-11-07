<%-- 
    Document   : New_customer
    Created on : Nov 5, 2016, 3:54:20 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />


        <h1>Titan Online Banking</h1>
        
        <form action="newcustomerservlet" method="POST">
            
            <h3>Please fill out the form</h3>
            
            
            <label>First Name:</label>
            <input type="text" name="firstName" ><br>
            
            <label>Last Name:</label>
            <input type="text" name="lastName" ><br>
            
            <label>Phone:</label>
            <input type="text" name="phone" ><br>
            
            <label>Address:</label>
            <input type="text" name="address" ><br>
            
            <label>City:</label>
            <input type="text" name="city" ><br>
            
            <label>State:</label>
            <input type="text" name="state" ><br>
            
            <label>Zip Code:</label>
            <input type="text" name="zipCode" ><br>
            
            <label>Email:</label>
            <input type="text" name="email" ><br>
            
            
            <input type="submit" name="newLogin" value="register" />
        
            </form>

        
        
<c:import url="include/footer.jsp" />
