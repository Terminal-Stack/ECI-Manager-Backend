package edu.eci.ieti.ecimanager.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Could not find student " + id);
    }

}
