<%-- 
    Document   : footer
    Created on : Nov 4, 2016, 4:24:48 PM
    Author     : mpjustice
--%>

<%@page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    
%>

<br><br>

<p>&copy; Copyright <%= currentYear %> Titan Online Banking</p>
</body>
</html>
