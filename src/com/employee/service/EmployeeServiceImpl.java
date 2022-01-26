package com.employee.service;

import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * This class is used to implement the EmployeeServices interface.
 * Created a linked hashmap collection for storing details for storing 
 * in insertion order maintenance and for better perrformance.
 */
public class EmployeeServiceImpl implements EmployeeServices {
	public final static LinkedHashMap<Integer,Employee> EMPLOYEEDETAILS = new LinkedHashMap<>();
	
	/**
	 * This method is for adding a new employee. Here employee id is set as key and
	 * other details like employee name, salary, contact number,emailId and date of 
	 * birth are stored in employe eobject.
	 * 
	 * @param employeeId 
	 * @param employee Object
	 */
	public void addEmployeeDetails (int employeeId, Employee employee) {
		EMPLOYEEDETAILS.put(employeeId, employee);
    }

	/**
	 * This method is used for viewing employee details that are stored
	 *  in the map using iterator and it gives both key and values; 
	 *  
	 *   @param employeeId 
	 */
	public void viewEmployeeDetails() {
		Iterator<Entry<Integer,Employee>> iterator = EMPLOYEEDETAILS.entrySet().iterator();
		
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
	public void updateEmployeeDetails(int employeeId, Employee employee) {
		EMPLOYEEDETAILS.put(employeeId, employee);
	}
	
	/**
	 * This method is used to check the employee name as accepting
	 * only alphabets and return the validated input to the 
	 * Employee details class.
	 * 
	 * @return employeeName
	 */
	public String checkEmployeeName(String employeeName) {
		if ((!employeeName.matches("[A-Za-z]{1,}"))) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmployeeName();
		} 
		return employeeName;
	}

	/**
	 * Thi method is used to check the contactNumber as accepting
	 * only numeric values as in the pattern and return the
	 * validated input to the Employee details class.
	 * 
	 * @return contactNumber
	 */
	public String checkContactNumber(String contactNumber) {
		if ((!contactNumber.matches("[6-9]{1}[0-9]{9}"))) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getContactNumber();
		} 
		return contactNumber;
	}

	/**
	 * Thi method is used to check the emailId as accepting
	 * the below given pattern and return the validated input to the 
	 * Employee details class.
	 *
	 * @return emailId
	 */
	public String checkEmailId(String emailId) {
		if ((!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmailId();
		} 
		return emailId;
	}

	/**
	 * Thi method is used to check the employee salary as accepting
	 * only numerical values and return the validated input to the 
	 * Employee details class.
	 * 
	 * @return salary
	 */
	public String checkSalary(String salary) {
		if ((!salary.matches("[0-9]{3,}"))) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmployeeSalary();
		} 
		return salary;
	}

	/**
	 * Validating employee joining date by checking day, month, year of default
	 * calendar method. If any input other than predefined values are given, then
	 * the method is called again to get desired input.
	 * 
	 * @return date
	 */

	public Date dateValidation(String dateOfBirth) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date date;

		try {
			date = dateFormat.parse(dateOfBirth);
			dateFormat.setLenient(true);
		} catch (Exception exception) {
			System.out.println("Please enter valid date");
			return EmployeeDetails.getDateOfBirth();
		}
		return date;
	}
	
 }
	

