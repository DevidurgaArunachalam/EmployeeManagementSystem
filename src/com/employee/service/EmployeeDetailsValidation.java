package com.employee.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.employee.view.EmployeeDetails;

/**
 * This class is used to validate the employee details obtained from
 * the view is validated using this class.
 */
public class EmployeeDetailsValidation  {
	/**
	 * Thi method is used to check the employee name as accepting
	 * only alphabets and return the validated input to the 
	 * Employee details class.
	 * 
	 * @return employeeName
	 */
	public static String checkEmployeeName (String employeeName) {
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
	public static String checkContactNumber (String contactNumber) {
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
	public static String checkEmailId (String emailId) {
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
	public static String checkSalary (String salary) {
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
	public static Date dateValidation (String dateOfBirth) {
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
