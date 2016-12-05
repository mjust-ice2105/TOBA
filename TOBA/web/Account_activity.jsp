<%-- 
    Document   : Account_activity
    Created on : Nov 5, 2016, 3:21:15 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />

        <h1>Titan Online Banking</h1>
        
        <h2>Account Activity</h2>
        
        <c:if test="${!empty sessionScope.user}">
            
            <p>
                <a href="Transfer_funds.jsp">Transfer Funds</a>
                &nbsp;
                <a href="admin/reports.jsp">Administration</a>
            </p>
            
            <p>Welcome to your account Activity page ${user.firstName} ${user.lastName}</p><br>
            
            <h3>Account Information</h3>
            
            
            <h4>-- Checking --</h4>
            <p>Balance: ${checking.balance}</p>
            
            <table>
                <tr>
                    <th>Transfer Type</th>
                    <th>Transfer Amount</th>
                </tr>
                
                <c:forEach var="chkTrans" items="${sessionScope.chkTransList}" >
                    <tr>
                        <td><c:out value="${chkTrans.transType}" /></td>
                        <td><c:out value="${chkTrans.transAmount}" /></td>
                    </tr>
                </c:forEach>
            </table>
            
            
            
            
            <br>
            <h4>-- Savings --</h4>
            <p>Balance: ${savings.balance}</p>
            
            <table>
                <tr>
                    <th>Transfer Type</th>
                    <th>Transfer Amount</th>
                </tr>
                
                <c:forEach var="savTrans" items="${sessionScope.savTransList}" >
                    <tr>
                        <td><c:out value="${savTrans.transType}" /></td>
                        <td><c:out value="${savTrans.transAmount}" /></td>
                    </tr>
                </c:forEach>
            </table>
            
            
            
            
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <p>You are not logged in</p>
            <p>Go to <a href="Login.jsp">Login</a> page.</p>
        </c:if>
            
            
           
        
<c:import url="include/footer.jsp" />
