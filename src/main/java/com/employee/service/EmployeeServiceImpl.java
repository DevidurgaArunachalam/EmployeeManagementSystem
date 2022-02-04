package com.employee.service;

import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>  
 *     Implements the EmployeeServices interface.
 *     Created a linked hashmap collection for storing details for storing 
 *     in insertion order maintenance and for better perrformance.
 * </p>     
 */
public class EmployeeServiceImpl implements EmployeeServices {
	private final static Map<Integer, Employee> EMPLOYEEDETAILS = new LinkedHashMap<Integer, Employee>();
	
   /**
	* <p>
	*    Adds a new employee details. Here employee id is set as key andother details like 
	*    employee name, salary, contact number, emailId and dateofbirth are stored in employe object.
	* </p>  
	*  
	* @param employee  
	*/
	public void addEmployee(Employee employee) {
	    final int employeeId = employee.getEmployeeId();
        
        if (EMPLOYEEDETAILS.containsKey(employeeId)) {
            System.out.println("The employeeId already exists!!...");
        } else {
            EMPLOYEEDETAILS.put(employeeId, employee);
        }
    }

   /**
	* <h> Views employee details that are stored in the map and it gives both key and values </h>
	*/
	public void viewEmployeeDetails() {
        for (Integer data : EMPLOYEEDETAILS.keySet()) {
            System.out.println(EMPLOYEEDETAILS.get(data));
        }
    }

   /**
	* <h> Deletes the employee details by getting employeeId to check and delete </h>
	* 
	* @param employeeId 
    * @throws DataNotFoundException
	*/
	public void deleteEmployee(int employeeId) throws DataNotFoundException{
	    
        if (EMPLOYEEDETAILS.containsKey(employeeId)) {
            EMPLOYEEDETAILS.remove(employeeId); 
        } else {
            throw new DataNotFoundException("IdNotFound");
        }
    }
	
   /**
	* <p>
	*    Updates the employee details by getting the user choice to update as per
	*    their choice to update. Calls the methods in EmployeeManagement
	*    class to update as per user choice.
	* </p>
	*    
	* @param employee
    * @throws DataNotFoundException 
	*/
	public void updateEmployeeDetails(Employee employee) throws DataNotFoundException {
	    
        if (EMPLOYEEDETAILS.containsKey(employee.getEmployeeId())) { 
            Employee employeeData = EMPLOYEEDETAILS.get(employee.getEmployeeId());

            if (employee.getEmployeeName() != null) {
                employeeData.setEmployeeName(employee.getEmployeeName());
            } else if (employee.getSalary() != null) {
                employeeData.setSalary(employee.getSalary());
            } else if (employee.getContactNumber() != null) {
                employeeData.setContactNumber(employee.getContactNumber());
            } else if (employee.getEmailId() != null) {
                employeeData.setEmailId(employee.getEmailId());
            } else if (employee.getDateOfBirth() != null) {
                employeeData.setDateOfBirth(employee.getDateOfBirth());
            } 
         } else {
             throw new DataNotFoundException("IdNotFound");
         }
    }
 }
	

