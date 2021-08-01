package com.TetzPotz.bank.Exceptions;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
