package com.employee.service;

import com.employee.model.Employee;
/**
 * This interaface is used to implement the methods from the  EmployeeServiceImpl class.
 */
public interface EmployeeServices {
	public void addEmployeeDetails (int employeeId, Employee employee);

	public void viewEmployeeDetails();

	public void updateEmployeeDetails (int employeeId, Employee employee);
	
	public void deleteEmployeeDetails (int employeeId);
}
