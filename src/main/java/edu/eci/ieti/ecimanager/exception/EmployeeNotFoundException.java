package edu.eci.ieti.ecimanager.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

    public EmployeeNotFoundException(String email) {
        super("Could not find employee with email " + email);
    }

}
