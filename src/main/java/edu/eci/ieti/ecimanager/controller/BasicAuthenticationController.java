package edu.eci.ieti.ecimanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthenticationController {

    @GetMapping("/login")
    public AuthenticationBean authenticationBean() {
        System.out.println("test");
        return new AuthenticationBean("You are authenticated");
    }

}
