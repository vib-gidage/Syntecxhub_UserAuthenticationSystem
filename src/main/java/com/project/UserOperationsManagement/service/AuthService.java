package com.project.UserOperationsManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.UserOperationsManagement.DTO.AuthResponce;
import com.project.UserOperationsManagement.DTO.LoginRequest;
import com.project.UserOperationsManagement.Entity.User;
import com.project.UserOperationsManagement.Repository.UserRepository;
import com.project.UserOperationsManagement.Security.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
    private UserRepository userrepository;

    @Autowired
    private PasswordEncoder passwordencoder;

    @Autowired
    private JwtUtil jwtutil;

    public String register(User user) {
        user.setPassword(passwordencoder.encode(user.getPassword()));
        userrepository.save(user);
        return "User registered successfully";
    }

    public AuthResponce login(LoginRequest request) {

        User user = userrepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordencoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtutil.generateToken(user.getEmail());
        
        System.out.println(token);

        return new AuthResponce(token);
    }

	
}
