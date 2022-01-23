package com.employee.view;

import java.util.Date;
import java.util.Scanner;

import com.employee.main.EmployeeManagement;
import com.employee.service.EmployeeDetailsValidation;

/**
 * This class is used to obtain the input from the user.
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * This methos is used to get the user Id in the numerical values.
	 * 
	 * @return employeeId
	 */
	public static int getEmployeeId() {
		System.out.println("Enter the EmployeeId:");
		int  employeeId =SCANNER.nextInt();
		return employeeId;
	}

	/**
	 * This method is used to get the user name.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return employeeName
	 */
	public static String getEmployeeName() {
		System.out.println("Enter the EmployeeName:");
		String employeeName = EmployeeDetailsValidation.checkEmployeeName(EmployeeManagement.SCANNER.next());
		return employeeName;
	}

	/**
	 * This method is used to get the contact number.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return contactNumber
	 */
	public static String getContactNumber() {
		System.out.println("Enter the Contact Number:");
		String contactNumber = EmployeeDetailsValidation.checkContactNumber(EmployeeManagement.SCANNER.next());
		return contactNumber;
	}

	/**
	 * This method is used to get employee salary details.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return salary
	 */
	public static String getEmployeeSalary() {
		System.out.println("Enter the Salary:");
		String salary = EmployeeDetailsValidation.checkSalary(SCANNER.next());
		return salary;
	}

	/**
	 * This method is used to get the email Id.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return emailId
	 */
	public static String getEmailId() {
		System.out.println("Enter the EmailId:");
		String emailId = EmployeeDetailsValidation.checkEmailId(EmployeeManagement.SCANNER.next());
		return emailId;
	}

	/**
	 * This method is used to get the date of birth of the employee.
	 * @return date
	 */
	public static Date getDateOfBirth() {
		System.out.println("Enter employee date of birth (dd/MM/yyyy):"); 
		return EmployeeDetailsValidation.dateValidation(EmployeeManagement.SCANNER.next());
	}	

}
	   
	

