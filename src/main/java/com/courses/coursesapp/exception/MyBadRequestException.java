package com.courses.coursesapp.exception;

public class MyBadRequestException extends Exception {
    public MyBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
