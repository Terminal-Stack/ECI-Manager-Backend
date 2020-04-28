package edu.eci.ieti.ecimanager.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    STUDENT, EMPLOYEE;

    @Override
    public String getAuthority() {
        return name();
    }

}
