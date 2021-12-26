package io.rest.BambooKeys.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.rest.BambooKeys.exception.CartExcpetion;

@ControllerAdvice
public class CartExceptionAdvice {
     
    @ResponseBody
    @ExceptionHandler(CartExcpetion.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(CartExcpetion ex){
        return ex.getMessage();
    }
}
