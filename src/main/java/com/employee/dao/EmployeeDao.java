package com.employee.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;

/**
* Database connectivity to store the values
*/
public class EmployeeDao {

    /**
     * Stores the data of employees in database
     * @param employee
     * @throws SQLException
     */
    public void addEmployee(Employee employee) {

        try (final Connection connection = DBConnection.getConnection();){
            final String query = "insert into employeedata (employeeId, employeeName, employeeSalary, employeeContactNumber, employeeEmailId, employeeDateOfBirth) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
            preparedStatement.setString(3, employee.getSalary());
            preparedStatement.setString(4, employee.getContactNumber());
            preparedStatement.setString(5, employee.getEmailId());
            preparedStatement.setDate(6, employee.getDateOfBirth());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Data entered successfully!!..");
        } catch (Exception exception) {
            System.out.println("Data not yet entered!!!...");
        } 
    }

    /**
     * Shows the list of data in the database
     * @return EMPLOYEEDETAILS
     * @throws SQLException
     */
    public Map<Integer, Employee> viewEmployeeData() {
        final Map<Integer, Employee> EMPLOYEEDETAILS = new HashMap<>();
        final String query = "SELECT* FROM employeedata";

        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();) {
            
            while (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("employeeId"), resultSet.getString("employeeName"),
                        resultSet.getString("employeeSalary"), resultSet.getString("employeeContactNumber"),
                        resultSet.getString("employeeEmailId"), resultSet.getDate("employeeDateOfBirth"));

                EMPLOYEEDETAILS.put(EmployeeDetails.getEmployeeId(), employee);
            }
        } catch (Exception exception) {
           System.out.println("Invalid input!!!...");
       }
        return EMPLOYEEDETAILS;
    }

    /**
     * Deletes the employee details by checking the employeeId
     * @param employeeId
     * @throws SQLException
     */
    public void deleteEmployee(int employeeId) {

        try (final Connection connection = DBConnection.getConnection();){
            String query = "DELETE FROM employeedata Where employeeId = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Deleted data successfully!!!..");
        } catch (Exception exception) {
            System.out.println("Cannot delete the employeeId!!!...");
        }
    }

    /**
     * Updates the employee details as per the user's choice
     * @param employee
     */
    public void updateEmployeeDetails(Employee employee) {
        try (final Connection connection = DBConnection.getConnection();) {
            final String query = "UPDATE employeedata set";
            PreparedStatement preparedStatement = null ;
            
            if(employee.getEmployeeId() != 0) {
            

            if (employee.getEmployeeName() != null) {
                preparedStatement = connection.prepareStatement(query + " employeeName = ? WHERE employeeId = ?");

            preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getSalary() != null) {
                preparedStatement = connection.prepareStatement(query + " employeeSalary = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getSalary());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getContactNumber() != null) {
                preparedStatement = connection.prepareStatement(query + " employeeContactNumber = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getContactNumber());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }

            if (employee.getEmailId() != null) {
                preparedStatement = connection.prepareStatement(query + " employeeEmailId = ? WHERE employeeId = ?");

                preparedStatement.setString(1, employee.getEmailId());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }
            
            if (employee.getDateOfBirth() != null) {
                preparedStatement = connection.prepareStatement(query + " employeeDateOfBirth = ? WHERE employeeId = ?");

                preparedStatement.setDate(1, employee.getDateOfBirth());
                preparedStatement.setInt(2, employee.getEmployeeId());
            }
                preparedStatement.executeUpdate();
            } 
            System.out.println("Data updated in database successfully");
            } catch (Exception exception) {
                System.out.println("Data not entered!!!...");
            } 
    }

}
