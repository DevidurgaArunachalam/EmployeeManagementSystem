package com.employee.model;

public class Employee {

	int employeeId;
	String employeeName;
	float salary;
	String contactNumber;
	String emailId;
	
	public Employee(int employeeId, String employeeName, float salary, String contactNumber, String emailId) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public float getSalary() {
		return salary;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String toString() {
		return new StringBuffer().append("Employee Details :").append("\n").append("EmployeeID:").append(employeeId).append("\n").append("Name:").
				append(employeeName).append("\n").append("Salary:").append(salary).append("\n").append("Contact Number:").
				append(contactNumber).append("\n").append("EmailID:").append(emailId).toString();
	}

}
