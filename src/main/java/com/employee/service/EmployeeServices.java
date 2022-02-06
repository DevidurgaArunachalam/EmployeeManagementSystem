package com.employee.service;

import com.employee.model.Employee;

/**
 * <h> Provides interface for EmployeeServiceImpl class </h>
 */
public interface EmployeeServices {
    void addEmployee(final Employee employee);

	void viewEmployeeDetails();

	void updateEmployeeDetails(final Employee employee);
	
	void deleteEmployee(final int employeeId);
	
}
