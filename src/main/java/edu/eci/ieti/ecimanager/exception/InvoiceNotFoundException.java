package edu.eci.ieti.ecimanager.exception;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(String id) {
        super("Could not find invoice " + id);
    }

}
