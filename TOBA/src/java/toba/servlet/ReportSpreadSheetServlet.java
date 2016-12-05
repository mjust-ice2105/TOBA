package toba.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import toba.javaClass.User;
import toba.util.ConnectionPool;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */


public class ReportSpreadSheetServlet extends HttpServlet { 
    
    //
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        // Get Current Month to be used in SQL query
        DateFormat df = new SimpleDateFormat("MM/yyyy");
        Date Date = new Date();
        String currDate = df.format(Date);
        
        
        // Create work book
        // Add Title to the work book
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = (Sheet) wb.createSheet("User table");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("User Report Table");
        
        // Add headers for the coloumns in the spreadsheet
        row = sheet.createRow(1);
        row.createCell(0).setCellValue("User ID");
        row.createCell(1).setCellValue("Username");
        row.createCell(2).setCellValue("First Name");
        row.createCell(3).setCellValue("Last Name");
        row.createCell(4).setCellValue("Email");
        row.createCell(5).setCellValue("Phone");
        row.createCell(6).setCellValue("Address");
        row.createCell(7).setCellValue("City");
        row.createCell(8).setCellValue("State");
        row.createCell(9).setCellValue("Zip Code");
        
        
        // Perform Try/Catch statement to query DB for User info with currDate
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection conn = pool.getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TOBA.USER WHERE REGDATE = '" + currDate + "'";
            ResultSet results = stmt.executeQuery(query);
            
            
            // Iterate through the results of the query and place data in correct coloumn
            // Jump to next row after.
            int i = 2;
            while(results.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(results.getInt("USERID"));
                row.createCell(1).setCellValue(results.getString("USERNAME"));
                row.createCell(2).setCellValue(results.getString("FIRSTNAME"));
                row.createCell(3).setCellValue(results.getString("LASTNAME"));
                row.createCell(4).setCellValue(results.getString("EMAIL"));
                row.createCell(5).setCellValue(results.getString("PHONE"));
                row.createCell(6).setCellValue(results.getString("ADDRESS"));
                row.createCell(7).setCellValue(results.getString("CITY"));
                row.createCell(8).setCellValue(results.getString("STATE"));
                row.createCell(9).setCellValue(results.getString("ZIPCODE"));
                
                i++;
            }
            
            
            results.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            this.log(e.toString());
        }
        
        //
        response.setHeader("Content-disposition", "attachment; filename=user_report.xls");
        response.setHeader("cache-control", "no-cache");
        
        //
        OutputStream out = response.getOutputStream();
        wb.write(out);
        out.close();
        
        
        

    }



}
