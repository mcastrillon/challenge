package com.ontop.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TransactionExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<TransactionError> handleExceptions(Exception ex, WebRequest request) {

        TransactionError transactionError =
            new TransactionError(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(transactionError, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(TransactionBadRequestException.class)
    public final ResponseEntity<TransactionError> handleBadRequestException(Exception ex, WebRequest request) {

        TransactionError transactionError =
            new TransactionError(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(transactionError, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(TransactionGenericException.class)
    public final ResponseEntity<TransactionError> handleGenericException(Exception ex, WebRequest request) {

        TransactionError transactionError =
            new TransactionError(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(transactionError, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(TransactionBalanceException.class)
    public final ResponseEntity<TransactionError> handleBalanceException(Exception ex, WebRequest request) {

        TransactionError transactionError =
                new TransactionError(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(transactionError, HttpStatus.PAYMENT_REQUIRED);

    }
}
