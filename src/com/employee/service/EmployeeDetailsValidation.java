package com.employee.service;

import com.employee.view.EmployeeDetails;

public class EmployeeDetailsValidation extends EmployeeDetails {

	public static String validateEmployeeName(String employeeName) {
		if ((!employeeName.matches("[A-Za-z\\s]*$"))) {
			System.out.println("Please Enter a Valid Employee Name:");
			return EmployeeDetails.getEmployeeName();
		} else {
			return employeeName;
		}
	}

	public static String validateContactNumber(String contactNumber) {
		if ((!contactNumber.matches("[6-9]{1}[0-9]{9}"))) {
			System.out.println("Please Enter Valid Phone Number");
			return EmployeeDetails.getContactNumber();
		} else {
			return contactNumber;
		}
	}

	public static String validateEmailId(String emailId) {
		if ((!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
			System.out.println("Please Enter Valid Email Id:");
			return EmployeeDetails.getEmailId();
		} else {
			return emailId;
		}
	}
	
}
