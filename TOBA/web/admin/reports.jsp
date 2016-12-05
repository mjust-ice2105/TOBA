<%-- 
    Document   : reports
    Created on : Nov 21, 2016, 4:55:19 PM
    Author     : mpjustice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/include/header.html" />

        <h1>Titan Online Banking</h1>
        
        <h2>Administrator Reports Page</h2>
        
        
        <form action="../reportsservlet" method="POST">
            <input hidden="runUserReport" name ="whatToDo" value="runReport" />
            <input type="submit" name ="userReport" value="Run Report" />
        </form>
        
        <br><br>
        
        
        
        <c:if test="${!empty sessionScope.user}">
            
            <table>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Zip Code</th>
                </tr>
                
                <c:forEach var="userReport" items="${sessionScope.userMonthReport}" >
                    <tr>
                        <td><c:out value="${userReport.userId}" /></td>
                        <td><c:out value="${userReport.userName}" /></td>
                        <td><c:out value="${userReport.firstName}" /></td>
                        <td><c:out value="${userReport.lastName}" /></td>
                        <td><c:out value="${userReport.email}" /></td>
                        <td><c:out value="${userReport.phone}" /></td>
                        <td><c:out value="${userReport.address}" /></td>
                        <td><c:out value="${userReport.city}" /></td>
                        <td><c:out value="${userReport.state}" /></td>
                        <td><c:out value="${userReport.zipCode}" /></td>
                    </tr>
                </c:forEach>
            </table>
            
            <br><br>
            <br><br>
            
            <form action="reportspreadsheetservlet" method="GET">
                <input hidden="DownloadRSS" name ="DownloadRSS" value="DownloadRSS" />
                <input type="submit" name ="DownloadRSS" value="Download Report" />
            </form>
            
        </c:if>
        
        
        
        
        
        
<c:import url="/include/footer.jsp" />
