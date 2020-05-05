package edu.eci.ieti.ecimanager.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface User {

    String getEmail();

    String getPassword();

    Role getRole();
}
