package com.springboot.flightserviceexample.exception;

public class InsufficentAmountException extends RuntimeException{

    public InsufficentAmountException(String msg){
        super(msg);
    }
}
