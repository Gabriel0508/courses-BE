package com.courses.coursesapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public @ResponseBody ErrorResponse handleException(BusinessException ex) {
        ex.printStackTrace();
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(value = MyBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleException(MyBadRequestException ex) {
        ex.printStackTrace();
        return new ErrorResponse(
                ex.getMessage());
    }
}
