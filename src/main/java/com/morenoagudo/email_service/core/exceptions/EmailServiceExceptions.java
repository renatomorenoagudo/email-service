package com.morenoagudo.email_service.core.exceptions;

public class EmailServiceExceptions extends RuntimeException{
    public EmailServiceExceptions(String message){
        super (message);
    }

    public EmailServiceExceptions(String message, throwable cause){
        super(message,cause);
    }
}
