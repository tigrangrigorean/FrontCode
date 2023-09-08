package com.apigateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.service.GetUsername;

@RestController
@RequestMapping("/getdata")
public class PrincipalController {
	
	private final GetUsername getUsername;
	
	public PrincipalController(GetUsername getUsername) {
		this.getUsername = getUsername;
	}
	
	@GetMapping("/get/username")
	public ResponseEntity<String> getUsername() {
	    String username = getUsername.getUsername();
	    return ResponseEntity.ok(username);
	}

}
