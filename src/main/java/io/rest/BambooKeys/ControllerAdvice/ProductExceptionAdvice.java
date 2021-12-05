package io.rest.BambooKeys.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.rest.BambooKeys.exception.ProductException;

@ControllerAdvice
public class ProductExceptionAdvice {
    
    @ResponseBody
    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(ProductException ex){
        return ex.getMessage();
    }
}
