package toba.servlet;

import toba.db.AccountDB;
import toba.javaClass.User;
import toba.javaClass.Transaction;
import toba.javaClass.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet(urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Default URL string
        String url = "/Transfer_funds.jsp";
        
        
        //Get User input from Login Screen.
        String transferAmount = request.getParameter("transAmount");
        String fromAccount = request.getParameter("from");
        String toAccount = request.getParameter("to");
        
        
        // Convert String Transfer amount to double
        double doubTransferAmount = Double.parseDouble(transferAmount);
        
        // Start session
        HttpSession session = request.getSession();
        
        // Get User Object from session
        User thisUser = (User) session.getAttribute("user");
        
        // Get Savings Account data from DB
        Account sav = AccountDB.selectSavAccount(thisUser.getUserId());
        
        // Get Checking Account data from DB
        Account chk = AccountDB.selectChkAccount(thisUser.getUserId());
        
        // Check the "from" and "to" accounts user wants to transfer
        // First check if they match
        if(fromAccount.equals(toAccount)) {
            
            // Send user to New Customer sign up page. 
            response.setContentType("text/html");
            PrintWriter out = response.getWriter(); 
            try {
                out.println("<h1>Titan Online Banking</h1>");
                out.println("<h3>Check to ensure you are not transferring \"to\" and \"from\" the same account</h3>");
                out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
            
                }
            finally {
               out.close();
            }
        
        }
        else {
            
            // Begin Switch/Case 
            switch (fromAccount) {
                
                // "From" Checking "To" Savings case statement
                case "Checking":
                    if(chk.getBalance() <= 0.00) {
                        
                        // If not enough money is account to transfer from, tell User
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter(); 
                        try {
                            out.println("<h1>Titan Online Banking</h1>");
                            out.println("<h3>Insufficient funds in Checking account, Check balance</h3>");
                            out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
                        }
                        finally {
                            out.close();
                        }
                    }
                    else {
                        
                        // Perform Subtraction of amount from "case" account
                        // Save to variable
                        // Then check to see if balance is below 0.00
                        chk.debit(doubTransferAmount);
                        
                        if(chk.getBalance() <= 0.00) {
                            chk.credit(doubTransferAmount);
                            
                            // If not enough money is account to transfer from, tell User
                            response.setContentType("text/html");
                            PrintWriter out = response.getWriter(); 
                            try {
                                out.println("<h1>Titan Online Banking</h1>");
                                out.println("<h3>Insufficient funds in Checking account</h3>");
                                out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
                            }
                            finally {
                                out.close();
                            }
                            
                        }
                        else {
                            
                            // Set Checking balance once checked for amount to new balance
                            // Perform addition of amount to account opposite of "case" account
                            
                            sav.credit(doubTransferAmount);
                            
                            // List of Transactions initalized
                            List<Transaction> savTransactions = new ArrayList<Transaction>();
                            List<Transaction> chkTransactions = new ArrayList<Transaction>();
                            
                            // Transaction constructor getting all its data
                            Transaction savTrans = new Transaction(sav.getAccountId(), "Credit", sav.getAccountType(), doubTransferAmount);
                            Transaction chkTrans = new Transaction(chk.getAccountId(), "Debit", chk.getAccountType(), doubTransferAmount);
                            
                            // Add the transaction to the List
                            savTransactions.add(savTrans);
                            chkTransactions.add(chkTrans);
                            
                            // Add the List to the Account for loading into the DB
                            sav.setTransactions(savTransactions);
                            chk.setTransactions(chkTransactions);
                            
                            // Save data back to database
                            AccountDB.update(chk);
                            AccountDB.update(sav);
                            
                            url = "/Account_activity.jsp";
                        }
                    }
                    break;
                    
                // "From" Savings "To" Checking case statement    
                case "Savings":
                    if(sav.getBalance() <= 0.00) {
                        
                        // If not enough money is account to transfer from, tell User
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter(); 
                        try {
                            out.println("<h1>Titan Online Banking</h1>");
                            out.println("<h3>Insufficient funds in Savings account, Check balance</h3>");
                            out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
                        }
                        finally {
                            out.close();
                        }
                    }
                    else {
                        
                        // Perform Subtraction of amount from "case" account
                        // Save to variable
                        // Then check to see if balance is below 0.00
                        sav.debit(doubTransferAmount);
                        
                        if(sav.getBalance() <= 0.00) {
                            
                            sav.credit(doubTransferAmount);
                            
                            // If not enough money is account to transfer from, tell User
                            response.setContentType("text/html");
                            PrintWriter out = response.getWriter(); 
                            try {
                                out.println("<h1>Titan Online Banking</h1>");
                                out.println("<h3>Insufficient funds in Savings account, Check balance</h3>");
                                out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
                            }
                            finally {
                                out.close();
                            }
                        }
                        else {
                            
                            // Set Savings balance once checked for amount
                            // Perform addition of amount to account opposite of "case" account
                            //sav.setBalance(newSavTotal);
                            chk.credit(doubTransferAmount);
                            
                            // List of Transactions initalized
                            List<Transaction> savTransactions = new ArrayList<Transaction>();
                            List<Transaction> chkTransactions = new ArrayList<Transaction>();
                            
                            // Transaction constructor getting all its data
                            Transaction savTrans = new Transaction(sav.getAccountId(), "Debit", sav.getAccountType(), doubTransferAmount);
                            Transaction chkTrans = new Transaction(chk.getAccountId(), "Credit", chk.getAccountType(), doubTransferAmount);
                            
                            
                            // Add the transaction to the List
                            savTransactions.add(savTrans);
                            chkTransactions.add(chkTrans);
                            
                            // Add the List to the Account for loading into the DB
                            sav.setTransactions(savTransactions);
                            chk.setTransactions(chkTransactions);
                            
                            // Save data back to database
                            AccountDB.update(chk);
                            AccountDB.update(sav);
                            
                            //
                            url = "/Account_activity.jsp";
                            
                        }
                    }
                    break;
                
                // Default output     
                default:
                    // If I don't know what the user did display default
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter(); 
                    try {
                        out.println("<h1>Titan Online Banking</h1>");
                        out.println("<h3>I'm not sure what you just did.</h3>");
                        out.println("<a href=\"Transfer_funds.jsp\">Transfer Funds</a>");
            
                    }
                    finally {
                        out.close();
                    }
            }
        }
        
        // Get List of transactions from the DB
        List<Transaction> savTransList = AccountDB.selectSavingAccountTransactions(sav.getAccountId());
        List<Transaction> chkTransList = AccountDB.selectCheckingAccountTransactions(chk.getAccountId());
        
        // Set account infomation in session.
        session.setAttribute("savings", sav);
        session.setAttribute("checking", chk);
        
        // Save the Transaction data to the session so it can be displayed.
        session.setAttribute("savTransList", savTransList);
        session.setAttribute("chkTransList", chkTransList);
        
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
