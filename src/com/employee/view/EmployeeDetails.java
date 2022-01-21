package com.employee.view;

import java.util.Scanner;

import com.employee.main.EmployeeManagement;
import com.employee.service.EmployeeDetailsValidation;

public class EmployeeDetails {

	public static final Scanner SCANNER = new Scanner(System.in);

	public static int getEmployeeId() {
		System.out.println("Enter the EmployeeId:");
		int employeeId = SCANNER.nextInt();
		return employeeId;
	}

	public static String getEmployeeName() {
		System.out.println("Enter the EmployeeName:");
		String employeeName = EmployeeDetailsValidation.validateEmployeeName(EmployeeManagement.SCANNER.next());
		return employeeName;
	}

	public static String getContactNumber() {
		System.out.println("Enter the Contact Number:");
		String contactNumber = EmployeeDetailsValidation.validateContactNumber(EmployeeManagement.SCANNER.next());
		return contactNumber;
	}

	public static float getEmployeeSalary() {
		System.out.println("Enter the Salary:");
		float salary = SCANNER.nextFloat();
		return salary;
	}

	public static String getEmailId() {
		System.out.println("Enter the EmailId:");
		String emailId = EmployeeDetailsValidation.validateEmailId(EmployeeManagement.SCANNER.next());
		return emailId;
	}

}
