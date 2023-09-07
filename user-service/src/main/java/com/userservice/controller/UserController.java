package com.userservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.dto.UserDto;
import com.userservice.model.entity.UserEntity;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getById(@PathVariable long id) {
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> getAll() {
		return ResponseEntity.ok().body(userService.getAll());
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
		userService.register(userDto);
		return ResponseEntity.status(201).body("User registered");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody UserDto userDto,@RequestParam long id) {
		userService.update(id,userDto);
		return ResponseEntity.ok().body("User updated");
	}
	
	@DeleteMapping("/delete") 
	public ResponseEntity<String> deleteUser(@RequestParam long id) {
		userService.deleteById(id);
		return ResponseEntity.ok().body("User by id " + id + " deleted");
	}
}

