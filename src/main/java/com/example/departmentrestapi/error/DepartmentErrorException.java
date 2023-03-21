package com.example.departmentrestapi.error;

public class DepartmentErrorException extends RuntimeException{
    private String message;
    public DepartmentErrorException(String message) {
        super(message);
    }
}
