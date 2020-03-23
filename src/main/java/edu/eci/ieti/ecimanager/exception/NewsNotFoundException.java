package edu.eci.ieti.ecimanager.exception;

public class NewsNotFoundException extends RuntimeException {

    public NewsNotFoundException(String id) {
        super("Could not find news " + id);
    }

}
