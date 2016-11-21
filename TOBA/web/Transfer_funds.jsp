<%-- 
    Document   : Transfer_funds
    Created on : Nov 17, 2016, 8:42:47 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.html" />


        <h1>Titan Online Banking</h1>
        
        <h2>Transfer Funds</h2>
        
        <form action="transactionservlet" method="POST"> 
            <h5>Account Balances</h5>
            <label>Checking: </label>
            <span>$ ${checking.balance}</span><br>
            
            <label>Savings: </label>
            <span>$ ${savings.balance}</span><br><br>
            
            <h5>Transfer From: </h5>
            
            
            <input type="radio" name="from" value="Checking" > Checking<br>
            <input type="radio" name="from" value="Savings" > Savings<br>
            
            
            <h5>Transfer To: </h5>
            
            
            <input type="radio" name="to" value="Checking" > Checking<br>
            <input type="radio" name="to" value="Savings" > Savings<br>
            
            
            <h5>Amount to transfer: </h5>
            
            <input type="text" name="transAmount" ><br><br>
            
            <input type="submit" name="transfer" value="Submit Transfer" />
            
        </form>
            
            
        

        
<c:import url="include/footer.jsp" />