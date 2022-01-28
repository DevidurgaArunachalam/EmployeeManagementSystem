package com.employee.model;

import java.util.Date;

/**
 * Gives information about employee details.
 */
public class Employee {
	/**
	 * Represents employee name, salary, contact number,emailId and dateOfBirth.
	 */
	private int  employeeId ;
	private String employeeName;
	private String salary;
	private String contactNumber;
	private String emailId;
	private Date date;
	
	public Employee() {
		super();
	}

	/**
	 * This Constructor creates an employee data
	 * 
	 * @param employeeId      
	 * @param employeeName    
	 * @param salary          
	 * @param conatactNumber  
	 * @param emailId         
	 * @param date            
	 */
	public Employee (int  employeeId, String employeeName, String salary, String contactNumber, String emailId, Date date) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.date = date;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getSalary() {
		return salary;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public Date getDate() {
		return date;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return new StringBuffer().append("EmployeeId:").append(employeeId).append("\n").append("Name:").append(employeeName).append("\n").append("Salary:").append(salary).
				append("\n").append("Contact Number:").append(contactNumber).append("\n").append("EmailID:").
				append(emailId).append("\n").append("DateOfBirth:").append(date).append("\n").toString();
	}

}
