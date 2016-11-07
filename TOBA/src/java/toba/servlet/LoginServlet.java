package toba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Default URL string.
        String url = "/Login.jsp";
        
        
        //Get and check user input.
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
            
        // If statements to check username and password
        if(userName.equals("jsmith@toba.com")) {
            if (passWord.equals("letmein")) {
                

                    
                // Send to account_activity if correct UN/PW.
                url = "/Account_activity.jsp";
            } else {
                    
                // Send back to login page.
                url = "/Login_failure.jsp";
            }
        } else {
                
            // Send back to login page.
            url = "/Login_failure.jsp";
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
