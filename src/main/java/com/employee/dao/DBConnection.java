package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <h> Database connectivity </h>
 * 
 * @author DeviDurgaA
 */
public class DBConnection {
    protected static final String DATABASEURL = "jdbc:mysql://localhost:3306/employeedao";
    protected static final String USERNAME = "root";
    protected static final String DATABASEPASSWORD = "Deepi@123";
    
   /**
    * <h> Determines the connection for database </h>
    *    
    * @return connection
    * @throws Exception 
    */
    protected static Connection getConnection() throws Exception { 
        
        try {
            Connection connection = DriverManager.getConnection(DATABASEURL, USERNAME, DATABASEPASSWORD);
            
            return connection;
        } catch (Exception exception) {
            throw new Exception("ConnectionIsNull");
        }
    }
    
}
