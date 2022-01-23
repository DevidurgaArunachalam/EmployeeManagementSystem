package com.employee.service;

import com.employee.model.Employee;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * This class is used to implement the EmployeeServices interface.
 * Created a linked hashmap collection for storing details for storing 
 * in insertion order maintenance and for better perrformance.
 */
public class EmployeeServiceImpl implements EmployeeServices {
	public final static LinkedHashMap<Integer, Employee> EMPLOYEEDETAILS = new LinkedHashMap<>();
	
	/**
	 * This method is for adding a new employee. Here employee id is set as key and
	 * other details like employee name, salary, contact number,emailId and date of 
	 * birth are stored in employe eobject.
	 * 
	 * @param employeeId 
	 * @param employee Object
	 */
	public void addEmployeeDetails (int employeeId, Employee employee) {
		EMPLOYEEDETAILS.put(employeeId ,employee);
    }

	/**
	 * This method is used for viewing employee details that are stored
	 *  in the map using iterator and it gives both key and values; 
	 *  
	 *   @param employeeId 
	 */
	public void viewEmployeeDetails() {
		Iterator<Entry<Integer , Employee>> iterator = EMPLOYEEDETAILS.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Entry<Integer,Employee> entry = iterator.next();
			System.out.println(entry.getKey() + " "+entry.getValue());
		}
	}

	/**
	 * This method is used to delete the employee details by getting employeeId to 
	 * check and delete.
	 * 
	 * @param employeeId 
	 */
	public void deleteEmployeeDetails (int employeeId) {
		EMPLOYEEDETAILS.remove(employeeId);
	}
	
	/**
	 * This method is used to update the employee details by getting the user choice
	 * to update as per their choice to update.
	 * This method calls the methods in EmployeeManagement class to update
	 * as per user choice. 
	 * 
	 *  @param employeeId 
	 */
	public void updateEmployeeDetails (int employeeId , Employee employee) {
		Iterator<Integer> iterator = EMPLOYEEDETAILS.keySet().iterator();
			 
		int  employeeKey = iterator.next();
		Employee employeeData = EMPLOYEEDETAILS.get(employeeKey);

		if (employeeKey == employeeId) {

			if (employee.getSalary() == null && employee.getContactNumber() == null
					&& employee.getDate() == null) {
				employeeData.setEmployeeName(employee.getEmployeeName());

				EMPLOYEEDETAILS.replace(employeeId, employeeData);
			} else if (employee.getSalary() == null && employee.getEmployeeName() == null
					&& employee.getDate() == null) {
				employeeData.setContactNumber(employee.getContactNumber());

				EMPLOYEEDETAILS.replace(employeeId, employeeData);
			} else if (employee.getEmployeeName() == null && employee.getContactNumber() == null
					&& employee.getDate() == null) {
				employeeData.setSalary(employee.getSalary());

				EMPLOYEEDETAILS.replace(employeeId, employeeData);
			} else if (employee.getEmployeeName() == null && employee.getContactNumber() == null
					&& employee.getSalary() == null) {
				employeeData.setDate(employee.getDate());

				EMPLOYEEDETAILS.replace(employeeId, employeeData);
			}
		}
	}
}
	

