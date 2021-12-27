package io.rest.BambooKeys.exception;

public class QuestionNotfoundException extends RuntimeException {

    public QuestionNotfoundException() {
    }

    public QuestionNotfoundException(String message) {
        super(message);
    }

    public QuestionNotfoundException(Long id) {
        super("Could not Fonund Request with id" + id);
    }

    public QuestionNotfoundException(Throwable cause) {
        super(cause);
    }

    public QuestionNotfoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotfoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
