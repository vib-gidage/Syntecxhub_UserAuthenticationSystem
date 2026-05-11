package com.project.UserOperationsManagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.UserOperationsManagement.DTO.LoginRequest;
import com.project.UserOperationsManagement.Entity.User;
import com.project.UserOperationsManagement.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authservice;
	
	@PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        return ResponseEntity.ok(authservice.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authservice.login(request));
    }
}


