package com.employee.service;

import java.sql.Date;

import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;

/**
 * Implements the methods from the  EmployeeServiceImpl class.
 */
public interface EmployeeServices {
    void addEmployee(Employee employee);

	void viewEmployeeDetails();

	void updateEmployeeDetails(Employee employee) throws DataNotFoundException;
	
	void deleteEmployee(int employeeId) throws DataNotFoundException;
	
	String checkEmployeeName(String employeeName);
	
	String checkContactNumber(String contactNumber);
	
	String checkEmailId(String emailId);
	
	String checkSalary(String salary);
	
	Date dateValidation(String dateOfBirth);
}
