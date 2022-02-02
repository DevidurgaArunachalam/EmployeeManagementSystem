package com.employee.exception;
/**
* Created custom exception
*/
public class DataNotFoundException  extends Exception {
  
  /**
  * Method it show the custom exception
  */
  public DataNotFoundException(String message) {
      super(message);
  }
}
