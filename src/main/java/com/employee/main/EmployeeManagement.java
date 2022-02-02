package com.employee.main;

import java.sql.Date;
import java.sql.SQLException;

import com.employee.controller.EmployeeController;
import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;

/**
* Employee Management System using Collection by implementing 
* CRUD OPERATIONS like, add employee details,view details,update
* if needed and delete the details by providing switch case to follow the flow
* as per user's choice. 
* @author Devidurga Arunachalam
*/
public class EmployeeManagement extends EmployeeDetails {
    private static final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();
       
    public static void main(String[] args) throws DataNotFoundException {
       int choice;
	  
       do {
           System.out.println(
		"\nEmployee Management System\n1.Add Employee\n2.View EmployeeList\n3.Update Employee Details\n4.Delete Employee details\n5.Exit\nEnter your choice :");
           choice = SCANNER.nextInt();

	    switch (choice) {
	    case 1:
		addEmployee();
		break;
	    case 2:
		viewEmployeeDetails();
		break;
	    case 3:
		updateEmployeeDetails();
		break;
	    case 4:
		deleteEmployee();
		break;
	    default:
		SCANNER.close();
		System.exit(5);
	    }
        } while (choice != 0);
    }
	
   /**
    * Used to add employee details as including employeeId,
    * name of the employee, salary details,contact number, emailId and
    * date of birth of the employee and pass it to the controller.  
    */
    private static void addEmployee() {
	int employeeId = EmployeeDetails.getEmployeeId();
	String employeeName = EmployeeDetails.getEmployeeName();
	String salary = EmployeeDetails.getEmployeeSalary();
	String contactNumber = EmployeeDetails.getContactNumber();
	String emailId = EmployeeDetails.getEmailId();
	Date dateOfBirth = EmployeeDetails.getDateOfBirth();
	Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, emailId, dateOfBirth);
		
	EMPLOYEECONTROLLER.addEmployee(employee);
    }
	
   /**
    * Used to view the employee details.
    */
    private static void viewEmployeeDetails() {
	EMPLOYEECONTROLLER.viewEmployeeDetails();
    }
	
   /**
    * Used to delete the employee details by checking the employeeId.
    * @throws DataNotFoundException 
    */
    private static void deleteEmployee() throws DataNotFoundException {
	EMPLOYEECONTROLLER.deleteEmployee(EmployeeDetails.getEmployeeId());
    }
	
   /**
    * Used to update the employee details by using iterator and 
    * employeeId for checking the availability of the details of the employee
    * and then update employee details using switch case 
    * implemetation by user choice.
    * @throws DataNotFoundException 
    */   
    private static void updateEmployeeDetails() throws DataNotFoundException {
	int employeeId = EmployeeDetails.getEmployeeId();
        String employeeName = null;
	String salary = null;
	String contactNumber = null;
	String emailId = null;
	Date dateOfBirth = null;
	    
	System.out.println("Update Changes To Employee Name ?\n yes or no");
	    
        if (EmployeeDetails.SCANNER.next().equalsIgnoreCase("yes")) {
	    employeeName  = EmployeeDetails.getEmployeeName();
	}
	    
	System.out.println("Update Changes To Employee Salary ?\n yes or no");
	    
	if (EmployeeDetails.SCANNER.next().equalsIgnoreCase("yes")) {
	    salary = EmployeeDetails.getEmployeeSalary();
	}
	    
	System.out.println("Update Changes To Employee Contact Number ?\n yes or no");
	    
	if(EmployeeDetails.SCANNER.next().equalsIgnoreCase("yes")) {
	    contactNumber = EmployeeDetails.getContactNumber();
	}
	    
	System.out.println("Update Changes To Employee EmailId ?\n yes or no");
	    
	if(EmployeeDetails.SCANNER.next().equalsIgnoreCase("yes")) {
	    emailId = EmployeeDetails.getEmailId();
	}
	    
	System.out.println("Update Changes To Employee DateOfBirth ?\n yes or no");
        
	if(EmployeeDetails.SCANNER.next().equalsIgnoreCase("yes")) {
            dateOfBirth = EmployeeDetails.getDateOfBirth();
        }
        Employee employee = new Employee();
        
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setSalary(salary);
        employee.setContactNumber(contactNumber);
        employee.setEmailId(emailId);
        employee.setDateOfBirth(dateOfBirth);
        
        EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }    
}

