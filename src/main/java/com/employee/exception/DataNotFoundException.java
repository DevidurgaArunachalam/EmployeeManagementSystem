package com.employee.exception;

public class DataNotFoundException  extends Exception {
  
    public DataNotFoundException(String IdNotFound) {
      super(IdNotFound);
  }


public class ConenctionNotFoundException extends DataNotFoundException {

    public ConenctionNotFoundException(String ConnectionIsNull) {
        super(ConnectionIsNull);
    }
    
}
public class IdAlreadyExistsException extends DataNotFoundException {

    public IdAlreadyExistsException(String IdAlreadyExists) {
        super(IdAlreadyExists);
    }
    
}
}