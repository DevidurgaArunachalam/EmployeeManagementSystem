package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    protected static final String DATABASEURL = "jdbc:mysql://localhost:3306/employeedao";
    protected static final String USERNAME = "root";
    protected static final String DATABASEPASSWORD = "Deepi@123";
    
    /**
     * Determines the connection for database    
     * @return connection
     */
    protected static Connection getConnection() {
        Connection connection = null;
        
        try {
           connection = DriverManager.getConnection(DATABASEURL, USERNAME, DATABASEPASSWORD);
        } catch (Exception exception) {
            System.out.println("Error Occured In Connecting!!!...");
        }
        return connection;
    }
    
}
