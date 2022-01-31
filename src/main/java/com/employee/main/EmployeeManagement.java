package com.employee.main;

import java.sql.Date;
import java.sql.SQLException;

import com.employee.controller.EmployeeController;
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
       
	public static void main(String[] args) throws SQLException {
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
    private static void addEmployee() throws SQLException {
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
    private static void viewEmployeeDetails() throws SQLException {
        EMPLOYEECONTROLLER.viewEmployeeDetails();
    }
	
   /**
    * Used to delete the employee details by checking the employeeId. 
    */
    private static void deleteEmployee() throws SQLException {
        EMPLOYEECONTROLLER.deleteEmployee(EmployeeDetails.getEmployeeId());
    }
	
   /**
    * Used to update the employee details by using iterator and 
    * employeeId for checking the availability of the details of the employee
    * and then update employee details using switch case 
    * implemetation by user choice.
    */   
    private static void updateEmployeeDetails() throws SQLException {
        System.out.println(
	    "Enter Your Choice To Update:\n1.Update Employee Details\n2.Update Name\n3.Update Salary\n4.Update Contact Number\n5.Update EmailId\n6.Update Date\n7.Go Back");
	int choice = EmployeeManagement.SCANNER.nextInt();
				   
	switch(choice) {
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
	    updateDateOfBirth();
            break;
	}
    }

   /**
    * Used to update DateOfBirth of the Employee
    * @param date
    */
    private static void updateDateOfBirth() throws SQLException {
        int employeeId = EmployeeDetails.getEmployeeId();
	Date dateOfBirth = EmployeeDetails.getDateOfBirth();
	Employee employee = new Employee();
		
	employee.setEmployeeId(employeeId);
	employee.setDateOfBirth(dateOfBirth);
	EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }
	
   /**
    * Used to update emailId of the Employee 
    * @param emailId
    */
    private static void updateEmployeeEmailId() throws SQLException {
        int employeeId = EmployeeDetails.getEmployeeId();
	String emailId = EmployeeDetails.getEmailId();
	Employee employee = new Employee();
		
	employee.setEmployeeId(employeeId);
	employee.setEmployeeName(emailId);
	EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }

   /**
    * Used to update contactNumber of the Employee
    * @param contactNumber
    */
    private static void updateEmployeeContactNumber() throws SQLException {
        int employeeId = EmployeeDetails.getEmployeeId();
	String contactNumber = EmployeeDetails.getContactNumber();
	Employee employee = new Employee();
		
	employee.setEmployeeId(employeeId);
	employee.setContactNumber(contactNumber);
	EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }

   /**
    * Used to update salary of the Employee
    * @param salary
    */
    private static void updateEmployeeSalary() throws SQLException {
	int employeeId = EmployeeDetails.getEmployeeId();
	String salary = EmployeeDetails.getEmployeeSalary();
	Employee employee = new Employee();
		
	employee.setEmployeeId(employeeId);
	employee.setSalary(salary);
	EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }

   /**
    * Used to update Name of the Employee
    * @param employeeName
    */
    private static void updateEmployeeName() throws SQLException {
	int employeeKey = EmployeeDetails.getEmployeeId();
    	String employeeName = EmployeeDetails.getEmployeeName();
	Employee employee = new Employee();
			
	employee.setEmployeeId(employeeKey);
	employee.setEmployeeName(employeeName);
	EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
    }

   /**
    * Used to update all details of the Employee
    * @param updateEmployee
    */
    private static void updateEmployee() throws SQLException {
	int employeeId = EmployeeDetails.getEmployeeId();
	String employeeName = EmployeeDetails.getEmployeeName();
	String salary = EmployeeDetails.getEmployeeSalary();
	String contactNumber = EmployeeDetails.getContactNumber();
	String emailId = EmployeeDetails.getEmailId();
	Date date = EmployeeDetails.getDateOfBirth();
	Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, emailId, date);
		
	EMPLOYEECONTROLLER.updateDetails(employee);
    }
}

