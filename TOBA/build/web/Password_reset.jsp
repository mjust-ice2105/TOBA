<%-- 
    Document   : password_reset
    Created on : Nov 1, 2016, 9:43:20 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />


        <h1>Titan Online Banking</h1>
        
        
            <form action="passwordresetservlet" method="POST">
            
             <h3>Password Reset</h3>
             
             <p>Please enter the following information</p>
             
             
             <label>Password :</label>
             <input type="password" name="password" value=${user.password} /><br><br>
             <label>Confirm Password :</label>
             <input type="password" name="password2" value=${user.password}  /><br><br>
             
             
            
            <input type="submit" name="login" value="Reset Password" />
        
            </form>        
        
        
        <c:import url="include/footer.jsp" />
