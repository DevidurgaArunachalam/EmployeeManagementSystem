package com.employee.controller;

import com.employee.dao.EmployeeDB;
import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.service.EmployeeServiceImplVersion2;
import com.employee.service.EmployeeServices;

/**
 * <p>
 *    This controller class is used for getting the request from main and 
 *    gives it to the service.
 *    The input data fetched in view are processed and then called in employee main class.
 * </p>   
 */
public class EmployeeController {
    private final static EmployeeServices EMPLOYEE_SERVICES = new EmployeeServiceImpl();
    private final static EmployeeDB EMPLOYEE_DB = new EmployeeServiceImplVersion2();
    
	public void addEmployee(Employee employee) {
	    EMPLOYEE_SERVICES.addEmployee(employee);
	    EMPLOYEE_DB.addEmployee(employee);
	}

	public void viewEmployeeDetails() {
        EMPLOYEE_SERVICES.viewEmployeeDetails();
        EMPLOYEE_DB.viewEmployeeData();  
	}
	 
	public void updateEmployeeDetails(Employee employee) throws DataNotFoundException {
	    EMPLOYEE_SERVICES.updateEmployeeDetails(employee);
	    EMPLOYEE_DB.updateEmployeeDetails(employee);
	}

	public void deleteEmployee(int employeeId) throws DataNotFoundException {
        EMPLOYEE_SERVICES.deleteEmployee(employeeId);
    }
}
