package edu.eci.ieti.ecimanager.advice;

import edu.eci.ieti.ecimanager.exception.InvoiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvoiceNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String invoiceNotFoundHandler(InvoiceNotFoundException exception) {
        return exception.getMessage();
    }

}
