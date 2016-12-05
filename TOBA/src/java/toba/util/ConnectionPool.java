package toba.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.*;

/**
 *
 * @author mpjustice
 * Matthew Justice
 * COP2806
 * 
 */


public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    //
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/TOBA");
        }
        catch (NamingException e) {
            
        }
    }
    
    
    public static synchronized ConnectionPool getInstance() {
        if(pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        }
        catch (SQLException e) {
            return null;
        }
    }
    
    
    public void freeConnection(Connection c) {
        try {
            c.close();
        }
        catch (SQLException e) {
            
        }
    }
    
    
    
    
}
