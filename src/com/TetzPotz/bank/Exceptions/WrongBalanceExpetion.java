package com.TetzPotz.bank.Exceptions;

public class WrongBalanceExpetion extends Exception{
    public WrongBalanceExpetion(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
