package com.TetzPotz.bank.Exceptions;

public class LowBalanceException extends Exception{
    public LowBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
