package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;
/**
 * Class implements the database connectivity to store the values
 */
public class EmployeeDao {

    protected static String databaseUrl = "jdbc:mysql://localhost:3306/employeedao";
    protected static String databaseName = "root";
    protected static String databasePassword = "Deepi@123";
    /**
     * Implememts the connection     
     * @return connection
     * @throws SQLException
     */
    protected static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
           connection = DriverManager.getConnection(databaseUrl, databaseName, databasePassword);
        } catch (Exception exception) {
            System.out.println("Error Occured!!!...");
        }
        return connection;
    }
    /**
     * Stores the data of employee in database
     * @param employee
     * @throws SQLException
     */
    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        
        try {
            String query = "insert into employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeEmailId, employeeDateOfBirth) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setString(5, employee.getEmailId());
            preparedStatement.setDate(6, employee.getDateOfBirth());
            preparedStatement.executeUpdate();
            System.out.println("Data entered successfully!!..");
        } catch (SQLException exception) {
           System.out.println("Data not yet entered!!!...");
        } finally {
            connection.close();
        }
    }
    /**
     * Shows the list of data in the database
     * @return EMPLOYEEDETAILS
     * @throws SQLException
     */
    public Map<Integer, Employee> viewEmployeeData() throws SQLException {
     final Map<Integer, Employee> EMPLOYEEDETAILS = new HashMap<>(); 
     Connection connection = getConnection();
     
        try {
            String query = "SELECT* FROM employeedata";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
              Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("employeeName"), resultSet.getString("employeeSalary"),
                      resultSet.getString("employeeContactNumber"), resultSet.getString("employeeEmailId"), resultSet.getDate("employeeDateOfBirth")); 
              EMPLOYEEDETAILS.put(EmployeeDetails.getEmployeeId(), employee);
            }
        } catch (SQLException exception) {
            System.out.println("No such data is available!!!..");
        } finally {
            connection.close(); 
        }
        return EMPLOYEEDETAILS;
    }
 /**
  * Deletes the employee details by checking the employeeId
  * @param employeeId
  * @throws SQLException
  */
    public void deleteEmployee(int employeeId) throws SQLException {
        Connection connection = getConnection();
        String query = "delete from employeedao where employeeId = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Cannot delete the employeeId!!!...");
        } finally {
            connection.close(); 
        }
    }
    /**
     * Updates the entire employee details by getting employeeId as input
     * @param employee
     * @throws SQLException
     */
    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        
        try {
            String query = "update employeedao set employeeId = ? and employeeName = ? and employeeSalary = ? and "
                    + "employeeContactNumber = ? and employeeEmail = ? and employeeDateOfBirth = ? ";
            PreparedStatement preparedStatement ;
            if(employee.getEmployeeId() != 0) {
                if(employee.getEmployeeName() != null && employee.getSalary() != null && employee.getContactNumber() != null &&
                        employee.getEmailId() != null && employee.getDateOfBirth() != null) {
                    preparedStatement = connection.prepareStatement(query);
                    
                    preparedStatement.setInt(1, employee.getEmployeeId());
                    preparedStatement.setString(2, employee.getEmployeeName());
                    preparedStatement.setString(3, employee.getSalary());
                    preparedStatement.setString(4, employee.getContactNumber());
                    preparedStatement.setString(5, employee.getEmailId());
                    preparedStatement.setDate(6, employee.getDateOfBirth());
                    preparedStatement.executeUpdate();
                    System.out.println("Data updated successfully!!..");
                }
            }
        } catch (SQLException exception) {
            System.out.println("Invalid Input Id!!!...");
        } finally {
            connection.close(); 
        }
    }
    /**
     * Updates the employee details as per the user's choice
     * @param employee
     * @throws SQLException
     */
    public void updateEmployeeDetails(Employee employee) throws SQLException {
        Connection connection = getConnection();
        
        try {
            if (employee.getEmployeeName() != null) {
                String query = "update employeedao set employeeName = ? where employeeId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getEmployeeName());
                preparedStatement.executeUpdate();
                System.out.println("EmployeeName updated successfully!!..");
            } else if (employee.getSalary() != null) {
                String query = "update employeedao set employeeSalary = ? where employeeId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getSalary());
                preparedStatement.executeUpdate();
                System.out.println("EmployeeSalary updated successfully!!..");
            } else if (employee.getContactNumber() != null) {
                String query = "update employeedao set employeeContactNumber = ? where employeeId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getContactNumber());
                preparedStatement.executeUpdate();
                System.out.println("EmployeeContactNumber updated successfully!!..");
            } else if (employee.getEmailId() != null) {
                String query = "update employeedao set employeeEmailId = ? where employeeId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getEmailId());
                preparedStatement.executeUpdate();
                System.out.println("EmployeeEmailId updated successfully!!..");
            } else if (employee.getDateOfBirth() != null) {
                String query = "update employeedao set employeeDateOfBirth = ? where employeeId = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setDate(6, employee.getDateOfBirth());
                preparedStatement.executeUpdate();
                System.out.println("EmployeeDateOfBirth updated successfully!!..");
            }
                
        } catch (SQLException exception) {
            System.out.println("Invalid Input Id!!!...");
        } finally {
            connection.close(); 
        }
   }
}
