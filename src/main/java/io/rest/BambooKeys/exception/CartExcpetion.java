package io.rest.BambooKeys.exception;



public class CartExcpetion extends RuntimeException {

  

    public CartExcpetion() {
    }

    public CartExcpetion(String message) {
        super(message);
    }

    public CartExcpetion(Throwable cause) {
        super(cause);
    }

    public CartExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public CartExcpetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

  
    
    
}
