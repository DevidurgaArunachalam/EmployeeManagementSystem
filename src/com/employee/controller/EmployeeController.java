package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.service.EmployeeServices;

/**
 * This controller class is used for getting the request from main and 
 * gives it to the service.
 * The input data fetched in view are processed and then called in employee main class.
 */
public class EmployeeController {
	private final EmployeeServices EMPLOYEE_SERVICES = new EmployeeServiceImpl();

	  public void addEmployeeDetails (int employeeId, Employee employee) {
		  EMPLOYEE_SERVICES.addEmployeeDetails(employeeId, employee);
	  }

	  public void viewEmployeeDetails() {
		  EMPLOYEE_SERVICES.viewEmployeeDetails();
	  }
	 
	  public void updateEmployeeDetails (int employeeId, Employee employee) {
		  EMPLOYEE_SERVICES.updateEmployeeDetails(employeeId, employee);
	  }

	  public void deleteEmployeeDetails (int employeeId) {
		  EMPLOYEE_SERVICES.deleteEmployeeDetails(employeeId);
	  }

}
