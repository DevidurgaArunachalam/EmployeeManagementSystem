package com.employee.view;

import java.sql.Date;
import java.util.Scanner;

import com.employee.controller.EmployeeController;
import com.employee.exception.DataNotFoundException;
import com.employee.model.Employee;
import com.employee.service.EmployeeDetailsValidation;

/**
 * <h> Used to obtain the input from the user </h>
 * 
 * @author DeviDurga Arunachalam
 */
public class EmployeeDetails {
	public static final Scanner SCANNER = new Scanner(System.in);
	public static final EmployeeController EMPLOYEECONTROLLER = new EmployeeController();

   /**
	* <h> Used to get the user Id in the numerical values. </h>
	* 
	* @return employeeId
    */
	public static int getEmployeeId() {
		System.out.println("Enter the EmployeeId:");
		int employeeId = SCANNER.nextInt();
		
		return employeeId;
	}

   /**
	* <p>
	*    Used to get the user name.
	*    By calling the EmployeeDetailsValidation class to validate the input. 
	* </p> 
	*   
	* @return employeeName
	*/
	public static String getEmployeeName() {
		System.out.println("Enter the EmployeeName:");
		String employeeName = EmployeeDetailsValidation.checkEmployeeName(SCANNER.next());
		
		return employeeName;
	}

   /**
	* <p>
	*    Used to get the contact number.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p>   
	* 
	* @return contactNumber
	*/
	public static String getContactNumber() {
		System.out.println("Enter the Contact Number:");
		String contactNumber = EmployeeDetailsValidation.checkContactNumber(SCANNER.next());
		
		return contactNumber;
	}

   /**
	* <p>
	*    Used to get employee salary details.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p>  
	*  
	* @return salary
	*/
	public static String getEmployeeSalary() {
		System.out.println("Enter the Salary:");
		String salary = EmployeeDetailsValidation.checkSalary(SCANNER.next());
		
		return salary;
	}

   /**
	* <p>
	*    Used to get the email Id.
	*    By calling the EmployeeDetailsValidation class to validate the input.
	* </p> 
	*   
	* @return emailId
    */
	public static String getEmailId() {
		System.out.println("Enter the EmailId:");
		String emailId = EmployeeDetailsValidation.checkEmailId(SCANNER.next());
		
		return emailId;
	}

   /**
	* <h> Used to get the date of birth of the employee. </h>
	*/
	public static Date getDateOfBirth() {
		System.out.println("Enter employee date of birth (YYYY-MM-dd):"); 
		return EmployeeDetailsValidation.dateValidation(SCANNER.next());  
	}	
	/**
     * <p>
     *     Used to add employee details as including employeeId,
     *     name of the employee, salary details,contact number, emailId and
     *     date of birth of the employee and pass it to the controller.
     * </p>     
     */
    public static void addEmployee() {
        final int employeeId = EmployeeDetails.getEmployeeId();
        final String employeeName = EmployeeDetails.getEmployeeName();
        final String salary = EmployeeDetails.getEmployeeSalary();
        final String contactNumber = EmployeeDetails.getContactNumber();
        final String emailId = EmployeeDetails.getEmailId();
        final Date dateOfBirth = EmployeeDetails.getDateOfBirth();
        Employee employee = new Employee(employeeId, employeeName, salary, contactNumber, emailId, dateOfBirth);
        
        EMPLOYEECONTROLLER.addEmployee(employee);
    }
    
   /**
    * <h> Used to view the employee details.</h>
    */
    public static void viewEmployeeDetails() {
        EMPLOYEECONTROLLER.viewEmployeeDetails();
    }
    
   /**
    * <h> Used to delete the employee details by checking the employeeId. </h>
    * 
    * @throws DataNotFoundException 
    */
    public static void deleteEmployee() {
        
        try {
            EMPLOYEECONTROLLER.deleteEmployee(EmployeeDetails.getEmployeeId());
        } catch (DataNotFoundException exception) {
           System.out.println(exception);
        }
    }
    
   /**
    * <p>
    *     Used to update the employee details by using iterator and 
    *     employeeId for checking the availability of the details of the employee
    *     and then update employee details using switch case 
    *     implemetation by user choice.
    * </p>  
    *
    * @throws DataNotFoundException 
    */   
    public static void updateEmployeeDetails() {
        int employeeId = EmployeeDetails.getEmployeeId();
        String employeeName = null;
        String salary = null;
        String contactNumber = null;
        String emailId = null;
        Date dateOfBirth = null;
        
        System.out.println("Update Changes To Employee Name ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.next())) {
            employeeName  = EmployeeDetails.getEmployeeName();
        }
        
        System.out.println("Update Changes To Employee Salary ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.next())) {
            salary = EmployeeDetails.getEmployeeSalary();
        }
        
        System.out.println("Update Changes To Employee Contact Number ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.next())) {
            contactNumber = EmployeeDetails.getContactNumber();
        }
        
        System.out.println("Update Changes To Employee EmailId ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.next())) {
            emailId = EmployeeDetails.getEmailId();
        }
        
        System.out.println("Update Changes To Employee DateOfBirth ?\n yes or no");
        
        if (("yes").equalsIgnoreCase(EmployeeDetails.SCANNER.next())) {
            dateOfBirth = EmployeeDetails.getDateOfBirth();
        }
        Employee employee = new Employee();
        
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName(employeeName);
        employee.setSalary(salary);
        employee.setContactNumber(contactNumber);
        employee.setEmailId(emailId);
        employee.setDateOfBirth(dateOfBirth);
        
        try {
            EMPLOYEECONTROLLER.updateEmployeeDetails(employee);
        } catch (DataNotFoundException exception) {
           System.out.println(exception);
        }
    }    

}
	   
	

