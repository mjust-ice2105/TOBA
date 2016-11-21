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
        
        //Get User input from Login Screen.
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        // Start Session.
        HttpSession session = request.getSession();
        
        // Get User Object from Session.
        User thisUser = (User) session.getAttribute("user");
        
        // Call userDbSelect statement to get user info (when user is not new)
        User dbUser = UserDB.selectUser(userName);
        
        // If session is null create new session.
        if(thisUser == null) {
            thisUser = new User();
        }
        if(dbUser == null) {
            dbUser = thisUser;
        }
        
        
        if(thisUser.getUserName().equals("")) {
            // If statment to check userName from DB select statement
            if(dbUser.getUserName().equals("")) {
                
                // Send user to New Customer sign up page. 
                response.setContentType("text/html");
                PrintWriter out = response.getWriter(); 
                try {
                    out.println("<h1>Titan Online Banking</h1>");
                    out.println("<h3>There is no record of your username</h3>");
                    out.println("<h3>Please sign up as New User</h3>");
                    out.println("<a href=\"New_customer.jsp\">New Customer</a>");
                
                    }
                finally {
                   out.close();
                }
                
            }
            else {
                
                // Add User Object data from DB to the session
                // if session is null but DB is NOT
                session.setAttribute("user", dbUser);
            }
        }
        else {
            
            // If session is NOT null check against DB select statement
            if(thisUser.getUserName().equals(userName) || userName.equals(dbUser.getUserName())) {
                if(thisUser.getPassword().equals(passWord) || passWord.equals(dbUser.getPassword())) {
                    
                    // Get Savings Account data from DB
                    Account sav = AccountDB.selectSavAccount(thisUser.getUserId());
                    
                    //System.out.println(sav);
                    
                    // Get Checking Account data from DB
                    Account chk = AccountDB.selectChkAccount(thisUser.getUserId());
                    
                    //System.out.println(chk);
                    
                    // Save Both CHECKING and SAVINGS account info to session
                    session.setAttribute("savings", sav);
                    session.setAttribute("checking", chk);
                    
                    // Send to account_activity if correct UN/PW.
                    url = "/Account_activity.jsp";
                    
                }
                else {
                    // Send user to login failure page
                    url = "/Login_failure.jsp";
                }
            }
            else {
                //Send user to login failure page
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
