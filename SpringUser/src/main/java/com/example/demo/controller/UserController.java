package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.dto.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable int id) {
		return service.getUser(id);
	}

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		return service.getAllUser();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}

	@PostMapping("/user/verfiy-phone")
	public ResponseEntity<ResponseStructure<User>> verfiyUserByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return service.verfiyUserByPhone(phone, password);
	}

	@PostMapping("/user/verfiy-email")
	public ResponseEntity<ResponseStructure<User>> verfiyUserByEmail(@RequestParam String email,
			@RequestParam String password) {
		return service.verfiyUserByEmail(email, password);
	}
}
