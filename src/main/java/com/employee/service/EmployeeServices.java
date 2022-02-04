package com.employee.service;

import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;

/**
 * <h> Provides interface for EmployeeServiceImpl class </h>
 */
public interface EmployeeServices {
    void addEmployee(Employee employee);

	void viewEmployeeDetails();

	void updateEmployeeDetails(Employee employee) throws DataNotFoundException;
	
	void deleteEmployee(int employeeId) throws DataNotFoundException;
	
}
