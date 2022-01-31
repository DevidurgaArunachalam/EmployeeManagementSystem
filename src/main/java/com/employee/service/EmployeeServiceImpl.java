package com.employee.service;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;
import com.employee.view.EmployeeDetails;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implements the EmployeeServices interface.
 * Created a linked hashmap collection for storing details for storing 
 * in insertion order maintenance and for better perrformance.
 */
public class EmployeeServiceImpl implements EmployeeServices {
	private final static Map<Integer, Employee> EMPLOYEEDETAILS = new LinkedHashMap<Integer, Employee>();
	private static final EmployeeDao EMPLOYEEDAO = new EmployeeDao();
	/**
	* Adds a new employee details. Here employee id is set as key andother details like 
	* employee name, salary, contact number, emailId and dateofbirth are stored in employe object.
	* @param employee Object
	* @throws SQLException 
	*/
	public void addEmployee(Employee employee) throws SQLException {
	    if (EMPLOYEEDETAILS.isEmpty()) {
	        EMPLOYEEDETAILS.putAll(EMPLOYEEDAO.viewEmployeeData());
	    }
	    if(EMPLOYEEDETAILS.containsKey(employee.getEmployeeId())) {
		    System.out.println("The employeeId already exists!!...");
		} else {
		    EMPLOYEEDAO.addEmployee(employee);   
		    EMPLOYEEDETAILS.put(employee.getEmployeeId(), employee); 
		} 
    }

   /**
	* Views employee details that are stored in the map and it gives both key and values.
	*/
	public void viewEmployeeDetails() throws SQLException{
	    System.out.println(EMPLOYEEDAO.viewEmployeeData());
	}

   /**
	* Deletes the employee details by getting employeeId to check and delete.
	* @param employeeId 
 * @throws SQLException 
	*/
	public void deleteEmployee(int employeeId) throws SQLException {
		if (EMPLOYEEDETAILS.isEmpty()) {
		    EMPLOYEEDETAILS.putAll(EMPLOYEEDAO.viewEmployeeData());
		}
	    if (EMPLOYEEDETAILS.containsKey(employeeId)) {
		    EMPLOYEEDETAILS.remove(employeeId);
		    EMPLOYEEDAO.deleteEmployee(employeeId);
		    System.out.println("Deleted Data Successfully!!!...");
		} else {
		    System.out.println("employeeId doesnot exists");
		}
	}
	
   /**
	* Updates the employee details by getting the user choice to update as per
	* their choice to update. Calls the methods in EmployeeManagement
	* class to update as per user choice.
	* @param employee
	*/
	public void updateEmployeeDetails(Employee employee) throws SQLException{
	    if(EMPLOYEEDETAILS.isEmpty()) {
	        EMPLOYEEDETAILS.putAll(EMPLOYEEDAO.viewEmployeeData()); 
	    }
	    if (EMPLOYEEDETAILS.containsKey(employee.getEmployeeId())) {	
	 		Employee employeeData = EMPLOYEEDETAILS.get(employee.getEmployeeId());

			if (employee.getEmployeeName() != null) {
				employeeData.setEmployeeName(employee.getEmployeeName());
			} else if (employee.getSalary() != null) {
				employeeData.setSalary(employee.getSalary());
			} else if (employee.getContactNumber() != null) {
				employeeData.setContactNumber(employee.getContactNumber());
			} else if (employee.getEmailId() != null) {
				employeeData.setEmailId(employee.getEmailId());
			} else if (employee.getDateOfBirth() != null) {
				employeeData.setDateOfBirth(employee.getDateOfBirth());
			} 
			EMPLOYEEDAO.updateEmployeeDetails(employeeData);
	     } else {
	    	 System.out.println("EmployeeId not found");
	     }
	}
	
   /**
	* Checks the employee name as accepting only alphabets and returns the 
	* validated input to the Employee Details class.
	* @return employeeName
	*/
	public String checkEmployeeName(String employeeName) {
		if (!employeeName.matches("[A-Za-z]{1,}")) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmployeeName();
		} 
		return employeeName;
	}

   /**
	* Checks the contactNumber as accepting only numeric values as in the pattern and returns
	* the validated input to the Employee details class.
	* @return contactNumber
	*/
	public String checkContactNumber(String contactNumber) {
		if (!contactNumber.matches("[6-9]{1}[0-9]{9}")) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getContactNumber();
		} 
		return contactNumber;
	}

   /**
	* Checks the emailId as accepting the below given pattern and return the 
	* validated input to the Employee details class.
	* @return emailId
	*/
	public String checkEmailId(String emailId) {
		if (!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmailId();
		} 
		return emailId;
	}

   /**
	* Checks the employee salary as accepting
	* only numerical values and return the validated input to the 
    * Employee details class.
    * @return salary
	*/
	public String checkSalary(String salary) {
		if(!salary.matches("[0-9]{3,}")) {
			System.out.println("Invalid Input!!!...");
			return EmployeeDetails.getEmployeeSalary();
		} 
		return salary;
	}

   /**
	* Validating employee joining date by checking day, month, year of default
	* calendar method. If any input other than predefined values are given, then
	* the method is called again to get desired input.
	* @return date
	*/
	public Date dateValidation(String dateOfBirth) {
        try {
	        LocalDate inputDate = LocalDate.parse(dateOfBirth);
	        LocalDate currentDate = LocalDate.now();
		   
	        if (currentDate.isAfter(inputDate)) {
	            return Date.valueOf(inputDate);
	        }
		} catch (Exception exception) {
		   System.out.println("Invalid Input!!!..");
		   return EmployeeDetails.getDateOfBirth();
		}
         return EmployeeDetails.getDateOfBirth();
	}
   /**
	* Updates the entire details of the employee by checking the employeeId   
	*/
	public void updateDetails(Employee employee) throws SQLException {
	    if(EMPLOYEEDETAILS.isEmpty()) {
            EMPLOYEEDETAILS.putAll(EMPLOYEEDAO.viewEmployeeData()); 
        }
	    if(EMPLOYEEDETAILS.containsKey(employee.getEmployeeId())) {    
            Employee employeeData = EMPLOYEEDETAILS.get(employee.getEmployeeId());

            if(employee.getEmployeeName() != null && employee.getSalary() != null && employee.getContactNumber() 
                != null && employee.getEmailId() != null &&  employee.getDateOfBirth() != null) {
                employeeData.setEmployeeName(employee.getEmployeeName());
                employeeData.setSalary(employee.getSalary());
                employeeData.setContactNumber(employee.getContactNumber());
                employeeData.setEmailId(employee.getEmailId());
                employeeData.setDateOfBirth(employee.getDateOfBirth());
            }
	    } else {
            System.out.println("EmployeeId not found");
        }
	}
 }
	

