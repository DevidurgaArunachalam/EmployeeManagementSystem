package com.employee.service;

import java.sql.Date;
import java.sql.SQLException;

import com.employee.model.Employee;

/**
* Implements the methods from the  EmployeeServiceImpl class.
*/
public interface EmployeeServices {
    public void addEmployee(Employee employee) throws SQLException;

    public void viewEmployeeDetails() throws SQLException;

    public void updateEmployeeDetails(Employee employee) throws SQLException;
	
    public void deleteEmployee(int employeeId) throws SQLException;
	
    public String checkEmployeeName(String employeeName);
	
    public String checkContactNumber(String contactNumber);
	
    public String checkEmailId(String emailId);
	
    public String checkSalary(String salary);
	
    public Date dateValidation(String dateOfBirth);

    public void updateDetails(Employee employee) throws SQLException;
}
