package toba.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.db.UserDB;
import toba.javaClass.User;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */


@WebServlet(urlPatterns = {"/ReportsServlet"})
public class ReportsServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/admin/reports.jsp";
        
        // Parameter to compare to
        String whatToDo = request.getParameter("whatToDo");
        
        // IF statement to ensure report must be ran
        if(whatToDo != null) {
            
            // Start Session.
            HttpSession session = request.getSession();
        
        
            //Get Current Month/Year for running report.
            DateFormat df = new SimpleDateFormat("MM/yyyy");
            Date Date = new Date();
            String currDate = df.format(Date);
        
        
            // Call the DB for the report with the Current MM/yyyy
            List<User> userMonthReport = UserDB.selectUserMonthReport(currDate);
            
            // Save report data to Session so it can be displayed on reports.jsp
            session.setAttribute("userMonthReport", userMonthReport);
            
            
            // Return to reports.jsp page with results in session
            url = "/admin/reports.jsp";
        
        }
        else {
            
            // Return to reports.jsp without any results and display will be nothing.
            url = "/admin/reports.jsp";
            
            
        }
        
        // Forward to correct request.
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
