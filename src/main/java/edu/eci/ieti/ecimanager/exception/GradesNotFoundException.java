package edu.eci.ieti.ecimanager.exception;

public class GradesNotFoundException extends RuntimeException {

    public GradesNotFoundException(String id) {
        super("Could not find grades " + id);
    }

}
