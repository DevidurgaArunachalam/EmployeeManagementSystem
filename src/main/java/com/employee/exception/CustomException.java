package com.employee.exception;

public class CustomException extends Exception {
  
    public CustomException(String message) {
      super(message);
  }

/**
 * <h> ConnectionNotFoundException class extends CustomException </h>   
 */
public static class ConenctionNotFoundException extends CustomException {

    public ConenctionNotFoundException(String message) {
        super(message);
    }  
}

/**
 * <h> IdAlreadyExistsException extends CustomException </h>
 */
public static class IdAlreadyExistsException extends CustomException {

    public IdAlreadyExistsException(String message) {
        super(message);
    } 
}

/**
 * <h> DataNotFoundException extends CustomException </h>
 */
public static class DataNotFoundException extends CustomException {
    
    public DataNotFoundException(String message) {
        super(message); 
     }
}

/**
 * <h> IdNotFoundException extends CustomException </h>
 */
public static class IdNotFoundException extends CustomException {

    public IdNotFoundException(String message) {
        super(message);
    } 
}
}