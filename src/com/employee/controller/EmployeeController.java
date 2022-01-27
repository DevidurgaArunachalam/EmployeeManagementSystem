package com.employee.controller;

import java.util.Date;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.service.EmployeeServices;

/**
 * This controller class is used for getting the request from main and 
 * gives it to the service.
 * The input data fetched in view are processed and then called in employee main class.
 */
public class EmployeeController {
	private final static EmployeeServices EMPLOYEE_SERVICES = new EmployeeServiceImpl();

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

	  public static String checkEmployeeName (String employeeName) {
		  return EMPLOYEE_SERVICES.checkEmployeeName(employeeName);
	  }
		
	  public static String checkContactNumber (String contactNumber) {
		return EMPLOYEE_SERVICES.checkContactNumber(contactNumber);	
	  }
		
	  public static String checkEmailId (String emailId) {
		return EMPLOYEE_SERVICES.checkEmailId(emailId);
	  }
		
	  public static String checkSalary (String salary) {
		return EMPLOYEE_SERVICES.checkSalary(salary);	
	  }
		
	  public static Date dateValidation (String dateOfBirth) {
		return EMPLOYEE_SERVICES.dateValidation(dateOfBirth);		
	  }
	  
}
