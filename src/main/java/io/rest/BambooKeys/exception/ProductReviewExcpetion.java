package io.rest.BambooKeys.exception;

public class ProductReviewExcpetion extends RuntimeException {

    public ProductReviewExcpetion() {
    }
    
    public ProductReviewExcpetion(Long reviewId) {
        super("thr review does not exisit"+ reviewId);
    }

    public ProductReviewExcpetion(String message) {
        super(message);
    }

    public ProductReviewExcpetion(Throwable cause) {
        super(cause);
    }

    public ProductReviewExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductReviewExcpetion(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
