package com.ds2technologies.authentication;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/public")
    public String HelloPublic() {

        return "Hello Public!";
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/api/private")
    public String HelloPrivate() {

        return "Hello Private!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/api/admin")
    public String HelloAdmin() {

        return "Hello Admin!";
    }
}
