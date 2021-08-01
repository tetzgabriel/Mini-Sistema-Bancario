package com.TetzPotz.bank.Exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
