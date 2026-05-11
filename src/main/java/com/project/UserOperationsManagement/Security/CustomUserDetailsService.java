package com.project.UserOperationsManagement.Security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.project.UserOperationsManagement.Entity.User;
import com.project.UserOperationsManagement.Repository.UserRepository;

@Service
public class CustomUserDetailsService {
	
	  @Autowired
	    private UserRepository userrepository;

//	    @Override
	    public UserDetails loadUserByUsername(String email) {
	        User user = userrepository.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        return new org.springframework.security.core.userdetails.User(
	                user.getEmail(),
	                user.getPassword(),
	                new ArrayList<>()
	        );
	    }
	}

