package edu.eci.ieti.ecimanager.exception;

public class SubjectNotFoundInStudentException extends RuntimeException {

    public SubjectNotFoundInStudentException(Long studentId, String subject) {
        super("The student " + studentId + " has not taken the subject " + subject);
    }

}
