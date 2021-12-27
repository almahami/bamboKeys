package io.rest.BambooKeys.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.rest.BambooKeys.exception.QuestionNotfoundException;

@ControllerAdvice
public class QuestionNotfoundExceptionAdvice {
    
      
    @ResponseBody
    @ExceptionHandler(QuestionNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(QuestionNotfoundException ex){
        return ex.getMessage();
    }
}
