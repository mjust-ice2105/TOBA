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


@WebServlet(urlPatterns = {"/PasswordResetServlet"})
public class PasswordResetServlet extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Default URL string.
        String url = "/Password_reset.jsp";
        
        //
        
        
            
        //Get user input data and save to variables.
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        
        
        
        if(password.equals("") || password2.equals("")) {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            try {
                out.println("<h1>Titan Online Banking</h1>");
                out.println("<h3>Please fill out all of the form fields</h3>");
                out.println("<a href=\"Password_reset.jsp\">Go Back</a>");
                
            }
            finally {
                out.close();
            }
            
            
        }
        else if(!password.equals(password2)) {
            
            // Print out message to HTML if password does not match
            // the password and confirm password field.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            try {
                out.println("<h1>Titan Online Banking</h1>");
                out.println("<h3>Please ensure password is confirmed</h3>");
                out.println("<a href=\"Password_reset.jsp\">Go Back</a>");
                
            }
            finally {
                out.close();
            }
        } 
        else {
            
            // Get User object from session if one is there.
            HttpSession session = request.getSession();
            
            // Create User Object that will be stored back in Session.
            User thisUser = (User) session.getAttribute("user");
            
            //Object test = request.getSession();
            
            // Set the properties to the User object
            
            thisUser.setPassword(password);
            
            
            
            /*
            thisUser.setFirstName(request.getParameter("firstName"));
            thisUser.setLastName(request.getParameter("lastName"));
            thisUser.setPhone(request.getParameter("phone"));
            thisUser.setAddress(request.getParameter("address"));
            thisUser.setCity(request.getParameter("city"));
            thisUser.setState(request.getParameter("state"));
            thisUser.setZipCode(request.getParameter("zipCode"));
            thisUser.setEmail(request.getParameter("email"));
            thisUser.setUserName(request.getParameter("userName"));
            thisUser.setPassword(password);*/
            
            
            
            
            // set the new User object to the sessionScope.
            session.setAttribute("user", thisUser);

            
            
            
            // Redirect user to Account Activity.
            url = "/Account_activity.jsp";
            
            
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
