package com.employee.model;

import java.util.Date;

/**
 * Gives information about employee details.
 */
public class Employee {
	/**
	 * Represents employee name, salary, contact number,emailId and dateOfBirth.
	 */
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
	 * @param employeeName    employee’s name.
	 * @param salary          employee’s salary.
	 * @param conatatNumber   employee’s phone number.
	 * @param emailId         employee's emailId.
	 * @param date            employee’s dateOfBirth.
	 */
	public Employee (String employeeName , String salary , String contactNumber , String emailId , Date date) {
		this.employeeName = employeeName;
		this.salary = salary;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.date = date;
	}

	/**
	 * Gets the employee name.
	 * 
	 * @return A string representing the employee’s name.
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Gets the employee salary.
	 * 
	 * @return A string representing the employee’s salary.
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * Gets the employee contactNumber.
	 * 
	 * @return A string representing the employee’s conatactNumber.
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * Gets the employee emailId.
	 * 
	 * @return A string representing the employee’s emailId.
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Gets the employee dateOfBirth.
	 * 
	 * @return A Date representing the employee’s dateOfBirth.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the employee name.
	 * 
	 * @return A string representing the employee’s name.
	 */
	public void setEmployeeName (String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Sets the employee salary.
	 * 
	 * @return A string representing the employee’s salary.
	 */
	public void setSalary (String salary) {
		this.salary = salary;
	}

	/**
	 * Sets the employee contactNumber.
	 * 
	 * @return A string representing the employee’s conatactNumber.
	 */
	public void setContactNumber (String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * Sets the employee emailId.
	 * 
	 * @return A string representing the employee’s emailId.
	 */
	public void setEmailId (String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Sets the employee dateOfBirth.
	 * 
	 * @return A Date representing the employee’s dateOfBirth.
	 */
	public void setDate (Date date) {
		this.date = date;
	}
	
	/**
	 * This method is displaying the values that are entered.
	 */
	public String toString() {
		return new StringBuffer().append("\n").append("Name:").append(employeeName).append("\n").append("Salary:").append(salary).
				append("\n").append("Contact Number:").append(contactNumber).append("\n").append("EmailID:").
				append(emailId).append("\n").append("DateOfBirth:").append(date).append("\n").toString();
	}

}
