package com.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.employee.model.Employee;
import com.employee.exception.CustomException.ConenctionNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
import com.employee.exception.CustomException.DataNotFoundException;

/**
 * <h> Database connectivity to store the values </h>
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private static final DBConnection DB_CONNECTION = new DBConnection();
   
    /**
    * <h> Stores the data of employees in database </h>
    * 
    * @param employee
    * @throws IdAlreadyExistsException 
    */
    public void addEmployee(final Employee employee) throws IdAlreadyExistsException {
        final String query = "insert into employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeEmailId, employeeDateOfBirth) values (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);){
           
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setString(5, employee.getEmailId());
            preparedStatement.setDate(6, employee.getDateOfBirth());

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new IdAlreadyExistsException("ID Already Exists!!!...");
        }
    }

   /**
    * <h> Shows the list of data in the database </h>
    * 
    * @return EMPLOYEE DETAILS
    * @throws DataNotFoundException 
    */
    public Map<Integer, Employee> viewEmployeeData() throws DataNotFoundException {
        final Map<Integer, Employee> EMPLOYEEDETAILS = new LinkedHashMap<>();
        final String query = "SELECT * FROM employeedata";

        try (Connection connection = DB_CONNECTION.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery();) {
            
            while (resultSet.next()) {
                final int employeeId = resultSet.getInt(1);
                final String employeeName = resultSet.getString(2);
                final String employeeSalary = resultSet.getString(3);
                final String employeeContactNumber = resultSet.getString(4);
                final String employeeEmailId = resultSet.getString(5);
                final Date employeeDateOfBirth = resultSet.getDate(6);
                Employee employee = new Employee(employeeId, employeeName, employeeSalary, employeeContactNumber,
                        employeeEmailId,  employeeDateOfBirth);
                
                EMPLOYEEDETAILS.put(employeeId, employee);              
             }
        } catch (SQLException exception) {
            throw new DataNotFoundException("Data Doesnot Exists!!!...");
        }
        
        return EMPLOYEEDETAILS;
    }

   /**
    * <h> Deletes the employee details by checking the employeeId </h>
    * 
    * @param employeeId
    * @throws ConenctionNotFoundException 
    */
    public void deleteEmployee(final int employeeId) throws IdNotFoundException {
        final String query = "DELETE FROM employeedata Where employeeId = ?";
        
        try (final Connection connection = DB_CONNECTION.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement(query);){
        
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
           throw new IdNotFoundException("Id Not Found!!!...");
        }
    }

   /**
    * <h> Updates the employee details as per the user's choice </h>
    * 
    * @param employee 
    * @throws IdNotFoundException 
    */
    public void updateEmployeeDetails(final Employee employee) throws IdNotFoundException {
    
        try (Connection connection = DB_CONNECTION.getConnection();) { 
            PreparedStatement preparedStatement = null ;
           
            if (employee.getEmployeeId() != 0) {

            if (employee.getEmployeeName() != null) {
                preparedStatement = connection.prepareStatement("UPDATE employeedata set employeeName = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getSalary() != null) {
                preparedStatement = connection.prepareStatement("UPDATE employeedata set employeeSalary = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getSalary());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getContactNumber() != null) {
                preparedStatement = connection.prepareStatement("UPDATE employeedata set employeeContactNumber = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getContactNumber());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getEmailId() != null) {
                preparedStatement = connection.prepareStatement("UPDATE employeedata set employeeEmailId = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getEmailId());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }
            
            if (employee.getDateOfBirth() != null) {
                preparedStatement = connection.prepareStatement("UPDATE employeedata set employeeDateOfBirth = ? WHERE employeeId = ?");

                preparedStatement.setDate(1, employee.getDateOfBirth());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } 
            } catch (SQLException exception) {
                throw new IdNotFoundException("Id Not Found!!!...");
            }
    }
}
