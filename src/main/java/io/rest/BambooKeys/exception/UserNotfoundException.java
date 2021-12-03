package io.rest.BambooKeys.exception;

public class UserNotfoundException extends RuntimeException {
    
    public UserNotfoundException(Long id){
        super("Could not found user");
    }
}
