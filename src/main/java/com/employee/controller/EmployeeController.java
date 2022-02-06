package com.employee.controller;

import com.employee.exception.CustomException.DataNotFoundException;
import com.employee.exception.CustomException.IdAlreadyExistsException;
import com.employee.exception.CustomException.IdNotFoundException;
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
    private final EmployeeServices EMPLOYEE_SERVICES = new EmployeeServiceImpl();
    private final EmployeeServiceImplVersion2 EMPLOYEE_IMPL = new EmployeeServiceImplVersion2();
    
	public void addEmployee(final Employee employee) throws IdAlreadyExistsException {
	    EMPLOYEE_SERVICES.addEmployee(employee);
	    EMPLOYEE_IMPL.addEmployee(employee);
	}

	public void viewEmployeeDetails() throws DataNotFoundException{
        EMPLOYEE_SERVICES.viewEmployeeDetails(); 
        EMPLOYEE_IMPL.viewEmployeeData();  
	}
	 
	public void updateEmployeeDetails(Employee employee) throws IdNotFoundException {
	    EMPLOYEE_SERVICES.updateEmployeeDetails(employee);
	    EMPLOYEE_IMPL.updateEmployeeDetails(employee);
	}

	public void deleteEmployee(int employeeId) throws IdNotFoundException  {
        EMPLOYEE_SERVICES.deleteEmployee(employeeId);
	    EMPLOYEE_IMPL.deleteEmployee(employeeId);
    }
}
