package com.ontop.account.exception;

public class TransactionBadRequestException extends RuntimeException{

    public TransactionBadRequestException(String message) {
        super(message);
    }

}
