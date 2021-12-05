package io.rest.BambooKeys.exception;

public class UserNotfoundException extends RuntimeException {
    
    public UserNotfoundException(Long id){
        super("Could not found user");
    }

    public UserNotfoundException() {
    }

    public UserNotfoundException(String message) {
        super(message);
    }

    public UserNotfoundException(Throwable cause) {
        super(cause);
    }

    public UserNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotfoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
