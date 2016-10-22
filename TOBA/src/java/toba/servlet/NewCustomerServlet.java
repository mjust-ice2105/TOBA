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

@WebServlet(urlPatterns = {"/NewCustomerServlet"})
public class NewCustomerServlet extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        // Default URL string.
        String url = "/New_customer.html";
        
            
        //Get user input data and save to variables.
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zipCode = request.getParameter("zipCode");
        String email = request.getParameter("email");
            
        
        // Check to see if variables have a value, if not then print message for
        // user to fill out complete form. Include link to go back to page.
        if(firstName.equals("") || lastName.equals("") || phone.equals("") 
                || address.equals("") || city.equals("") || state.equals("") 
                || zipCode.equals("") || email.equals("")) {
            
            // Print out message to HTML if one or more variables are blank.
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            try {
                out.println("<h1>Titan Online Banking</h1>");
                out.println("<h3>Please fill out all of the form fields</h3>");
                out.println("<a href=\"New_customer.html\">Go Back</a>");
                
            }
            finally {
                out.close();
            }
        }
        else {
            // Set URL to success page if all variables are filled out.
            url = "/Success.html";
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