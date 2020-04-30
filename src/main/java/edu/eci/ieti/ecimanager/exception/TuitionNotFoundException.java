package edu.eci.ieti.ecimanager.exception;

public class TuitionNotFoundException extends RuntimeException {

    public TuitionNotFoundException(Long studentCollegeId) {
        super("Could not find tuition for student: " + studentCollegeId);
    }

}
