package edu.eci.ieti.ecimanager.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String name) {
        super("Could not find product with name: " + name);
    }

}
