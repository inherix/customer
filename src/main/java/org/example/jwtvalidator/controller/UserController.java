package org.example.jwtvalidator.controller;

import lombok.RequiredArgsConstructor;
import org.example.jwtvalidator.model.User;
import org.example.jwtvalidator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/profile")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable String id) {
        return ResponseEntity.ok(service.getProfile(id));
    }

    @PostMapping
    public ResponseEntity<User> createProfile(
            @RequestBody User req
    ) {
        return ResponseEntity.ok(service.createProfile(req));
    }
}



