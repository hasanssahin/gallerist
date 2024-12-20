package com.hasansahin.gallerist.exception;

public class BaseException extends RuntimeException{
    public BaseException(ErrorMessage errorMessage){
        super(errorMessage.prepareErrorMessage());
    }
}
