package com.employee.controller;

import com.employee.service.EmployeeServiceImpl;
import com.employee.service.EmployeeServices;

public class EmployeeController {
     private final EmployeeServices EMPLOYEESERVICES = new EmployeeServiceImpl();

	  public void addDetails() {
		  EMPLOYEESERVICES.addDetails();
	  }

	  public void viewDetails() {
		  EMPLOYEESERVICES.viewDetails();
	  }
	  public void updateDetails() {
		  EMPLOYEESERVICES.updateDetails();
		  }

	  public void deleteDetails() {
		  EMPLOYEESERVICES.deleteDetails();
	  }

}
