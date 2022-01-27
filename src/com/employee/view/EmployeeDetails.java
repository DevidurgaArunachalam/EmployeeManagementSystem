package com.employee.view;

import java.util.Date;
import java.util.Scanner;

import com.employee.controller.EmployeeController;
import com.employee.main.EmployeeManagement;

/**
 * Used to obtain the input from the user.
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {
	public static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Used to get the user Id in the numerical values.
	 * 
	 * @return employeeId
	 */
	public static int getEmployeeId() {
	   System.out.println("Enter the EmployeeId:");
	   int  employeeId =SCANNER.nextInt();
		
	   return employeeId;
	}

	/**
	 * Used to get the user name.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return employeeName
	 */
	public static String getEmployeeName() {
	   System.out.println("Enter the EmployeeName:");
	   String employeeName = EmployeeController.checkEmployeeName(EmployeeManagement.SCANNER.next());
		
	   return employeeName;
	}

	/**
	 * Used to get the contact number.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return contactNumber
	 */
	public static String getContactNumber() {
	   System.out.println("Enter the Contact Number:");
	   String contactNumber = EmployeeController.checkContactNumber(EmployeeManagement.SCANNER.next());
		
	   return contactNumber;
	}

	/**
	 * Used to get employee salary details.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return salary
	 */
	public static String getEmployeeSalary() {
	   System.out.println("Enter the Salary:");
	   String salary = EmployeeController.checkSalary(SCANNER.next());
	   
	   return salary;
	}

	/**
	 * Used to get the email Id.
	 * By calling the EmployeeDetailsValidation class to validate the input.
	 * 
	 * @return emailId
	 */
	public static String getEmailId() {
	   System.out.println("Enter the EmailId:");
	   String emailId = EmployeeController.checkEmailId(EmployeeManagement.SCANNER.next());
	
	   return emailId;
	}

	/**
	 * Used to get the date of birth of the employee.
	 * 
	 * @return date
	 */
	public static Date getDateOfBirth() {
	   System.out.println("Enter employee date of birth (dd/MM/yyyy):"); 
	   return EmployeeController.dateValidation(EmployeeManagement.SCANNER.next());
	}	

}
	   
	

