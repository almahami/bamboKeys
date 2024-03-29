package io.rest.BambooKeys.exception;

public class ProductException extends RuntimeException {

    public ProductException() {
    }

    public ProductException(Long productId) {
        super("COULD NOT FOUND THE PRODUCT WITH ID" + productId);
    }
    public ProductException(String message) {
        super(message);
    }

    public ProductException(Throwable cause) {
        super(cause);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
