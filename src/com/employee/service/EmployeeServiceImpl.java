package com.employee.service;

import com.employee.main.EmployeeManagement;
import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class EmployeeServiceImpl implements EmployeeServices {

	private final ArrayList<Employee> EMPLOYEEDETAILS = new ArrayList<Employee>();

	public void addDetails() {
		int employeeId = EmployeeDetails.getEmployeeId();
		String employeeName = EmployeeDetails.getEmployeeName();
		String contactNumber = EmployeeDetails.getContactNumber();
		float salary = EmployeeDetails.getEmployeeSalary();
		String emailId = EmployeeDetails.getEmailId();
				
		Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, emailId);
		EMPLOYEEDETAILS.add(employee);

	}

	public void viewDetails() {
		for (Employee display : EMPLOYEEDETAILS) {
			System.out.println(display);
		}
	}

	public void deleteDetails() {
		int employeeId = EmployeeDetails.getEmployeeId();

		Iterator<Employee> iterator = EMPLOYEEDETAILS.iterator();

		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getEmployeeId() == employeeId) {
				iterator.remove();
				break;
			}
		}
	}

	public void updateDetails() {
	    ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		while (listIterator.hasNext()) {
			Employee employee = listIterator.next();
			int employeeId = EmployeeDetails.getEmployeeId();
			
			if (employee.getEmployeeId() == employeeId) {
				System.out.println(
				    "Enter Your Choice To Update:\n1.Update Employee Details\n2.Update Name\n3.Update Salary\n4.Update Contact Number\n5.Update EmailId\n6.Go Back");
				int choice1 = EmployeeManagement.SCANNER.nextInt();
			    switch(choice1) {
			    case 1:							
			        updateEmployee();
				    break;
				
			    case 2:
				    updateEmployeeName();
				    break;
				
			    case 3:
				    updateEmployeeSalary();
				    break;
				
			    case 4:
				    updateEmployeeContactNumber();
				    break;
				   
			    case 5:
				    updateEmployeeEmailId();
				    break;
				
			    case 6 :
				    System.out.println("Back To Main");
				    break;
			    }
			
			} else {
				System.out.println("EmployeeId Not Found!!.. Please Enter Vaild Id: ");
			}
		}
	}
	
	public void updateEmployee() {
		ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		Employee employee = listIterator.next();
		int index = EMPLOYEEDETAILS.indexOf(employee);
		String employeeName = EmployeeDetails.getEmployeeName();
		float salary = EmployeeDetails.getEmployeeSalary();
		String contactNumber = EmployeeDetails.getContactNumber();
		String emailId = EmployeeDetails.getEmailId();	
		
		employee.setEmployeeName(employeeName);
		employee.setSalary(salary);
		employee.setContactNumber(contactNumber);
		employee.setEmailId(emailId);
		EMPLOYEEDETAILS.set(index, employee);
	}
	
	public void updateEmployeeName() {
		ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		Employee employee = listIterator.next();
		int index = EMPLOYEEDETAILS.indexOf(employee);
		String employeeName = EmployeeDetails.getEmployeeName();
		
		employee.setEmployeeName(employeeName);
		EMPLOYEEDETAILS.set(index, employee);
	}
	
	public void updateEmployeeSalary() {
		ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		Employee employee = listIterator.next();
		int index = EMPLOYEEDETAILS.indexOf(employee);
		float salary = EmployeeDetails.getEmployeeSalary();
		
		employee.setSalary(salary);
		EMPLOYEEDETAILS.set(index, employee);
	}
	
	public void updateEmployeeContactNumber() {
		ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		Employee employee = listIterator.next();
		int index = EMPLOYEEDETAILS.indexOf(employee);
		String contactNumber = EmployeeDetails.getContactNumber();
		
		employee.setContactNumber(contactNumber);
		EMPLOYEEDETAILS.set(index, employee);
	}
	
	public void updateEmployeeEmailId() {
		ListIterator<Employee> listIterator = EMPLOYEEDETAILS.listIterator();
		Employee employee = listIterator.next();
		int index = EMPLOYEEDETAILS.indexOf(employee);
		String emailId = EmployeeDetails.getEmailId();
		
		employee.setEmailId(emailId);
		EMPLOYEEDETAILS.set(index, employee);
	}
}
