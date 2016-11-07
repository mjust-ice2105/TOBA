<%-- 
    Document   : Error_java
    Created on : Oct 16, 2016, 7:43:52 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />


        <h1>Titan Online Banking</h1>
        
        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception</p>
        <p>To continue, click the back button.</p>
        
        <h3>Error details:</h3>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Message: {pageContext.exception.message}</p>
        
        

        <c:import url="include/footer.jsp" />
