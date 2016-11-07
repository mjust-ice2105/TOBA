<%-- 
    Document   : Login
    Created on : Nov 5, 2016, 3:53:13 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />


        <h1>Titan Online Banking</h1>
        
        <a href="New_customer.jsp">New Customer</a>
        
            <form action="loginservlet" method="POST">
            
             <h3>Please login</h3>
        
             Username: <input type="text" name="username" /><br><br>
             Password: <input type="password" name="password" /><br><br>
            
            <input type="submit" name="login" value="Login" />
        
            </form><br><br>
            
            <a href="Password_reset.jsp">Reset Password</a>

        
<c:import url="include/footer.jsp" />
