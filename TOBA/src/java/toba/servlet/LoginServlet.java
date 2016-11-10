package toba.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        HttpSession session = request.getSession();
        
        User thisUser = (User) session.getAttribute("user");
        
        //Get and check user input.
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
            
        
        if(thisUser.getUserName() == null) {
            
            // Send user to New Customer sign up page. 
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            try {
                out.println("<h1>Titan Online Banking</h1>");
                out.println("<h3>Please sign up as New User</h3>");
                out.println("<a href=\"New_customer.jsp\">New Customer</a>");
                
                }
            finally {
                out.close();
            }
        }
        else {
            
            if(userName.equals(thisUser.getUserName())) {
                if(passWord.equals(thisUser.getPassword())) {
                    
                    // Send to account_activity if correct UN/PW.
                url = "/Account_activity.jsp";
                
                }
                else {
                    // Send back to login page.
                    url = "/Login_failure.jsp";
                }
            }
            else {
                
                // Send back to login page.
                url = "/Login_failure.jsp";
            }
            
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
