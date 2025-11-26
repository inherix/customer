package org.example.jwtvalidator.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is public endpoint";
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "subject",jwt.getSubject(),
                "claims",jwt.getClaims()
        );
    }

    @GetMapping("/secure")
    public String secure(){
        return "This is secure endpoint";
    }

}
