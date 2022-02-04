package com.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.LinkedHashMap;
import java.util.Map;

import com.employee.model.Employee;

/**
 * <h> Database connectivity to store the values </h>
 */
public class EmployeeDao implements EmployeeDB {

   /**
    * <h> Stores the data of employees in database </h>
    * 
    * @param employee
    */
    public void addEmployee(final Employee employee) {
        final String query = "insert into employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeEmailId, employeeDateOfBirth) values (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);){
           
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setString(5, employee.getEmailId());
            preparedStatement.setDate(6, employee.getDateOfBirth());

            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

   /**
    * <h> Shows the list of data in the database </h>
    * 
    * @return EMPLOYEE DETAILS
    */
    public Map<Integer, Employee> viewEmployeeData() {
        final Map<Integer, Employee> EMPLOYEEDETAILS = new LinkedHashMap<>();
        final String query = "SELECT * FROM employeedata";

        try (Connection connection = DBConnection.getConnection();
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
        } catch (Exception exception) {
            System.out.println(exception);
        }
        
        return EMPLOYEEDETAILS;
    }

   /**
    * <h> Deletes the employee details by checking the employeeId </h>
    * 
    * @param employeeId
    */
    public void deleteEmployee(final int employeeId) {
        final String query = "DELETE FROM employeedata Where employeeId = ?";
        
        try (final Connection connection = DBConnection.getConnection();
               PreparedStatement preparedStatement = connection.prepareStatement(query);){
        
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

   /**
    * <h> Updates the employee details as per the user's choice </h>
    * 
    * @param employee 
    */
    public void updateEmployeeDetails(final Employee employee) {
    
        try (Connection connection = DBConnection.getConnection();) { 
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
            } catch (Exception exception) {
                System.out.println(exception);
            }
    }
}
