package com.employee.service;

import java.util.Date;

import com.employee.model.Employee;
/**
 * Implements the methods from the  EmployeeServiceImpl class.
 */
public interface EmployeeServices {
	public void addEmployeeDetails (int employeeId, Employee employee);

	public void viewEmployeeDetails();

	public void updateEmployeeDetails (int employeeId, Employee employee);
	
	public void deleteEmployeeDetails (int employeeId);
	
	public String checkEmployeeName (String employeeName);
	
	public String checkContactNumber (String contactNumber);
	
	public String checkEmailId (String emailId);
	
	public String checkSalary (String salary);
	
	public Date dateValidation (String dateOfBirth);
}
