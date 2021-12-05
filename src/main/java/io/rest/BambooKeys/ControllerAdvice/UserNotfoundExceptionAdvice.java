package io.rest.BambooKeys.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.rest.BambooKeys.exception.UserNotfoundException;

@ControllerAdvice
public class UserNotfoundExceptionAdvice {
    
    @ResponseBody
    @ExceptionHandler(UserNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotfoundException exception){
        return exception.getMessage();
    }
}
