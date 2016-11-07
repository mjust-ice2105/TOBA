<%-- 
    Document   : Account_activity
    Created on : Nov 5, 2016, 3:21:15 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />

        <h1>Titan Online Banking</h1>
        
        <h2>this is the Account_activity page</h2>
        
        <c:if test="${!empty sessionScope.user}">
            <p>Welcome to your account Activity page ${user.firstName} ${user.lastName}</p>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <p>You are not logged in</p>
            <p>Go to <a href="Login.jsp">Login</a> page.</p>
        </c:if>
           
        
<c:import url="include/footer.jsp" />
