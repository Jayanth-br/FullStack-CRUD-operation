package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.dto.User;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.InvalidCredentialsException;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User registered successfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User updated successfully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> getUser(int id) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.getUser(id);
		if (recUser.isPresent()) {
			structure.setMessage("User found");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> getAllUser() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setMessage("All users are printed");
		structure.setBody(dao.getAllUser());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.getUser(id);
		if (recUser.isPresent()) {
			dao.deleteUser(recUser.get());
			structure.setMessage("User deleted");
			structure.setBody("User found");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setMessage("User not deleted");
		structure.setBody("User not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> verfiyUserByPhone(long phone, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verfiyUserByPhone(phone, password);
		if (recUser.isPresent()) {
			structure.setMessage("User Verfiyed");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<User>> verfiyUserByEmail(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verfiyUserByEmail(email, password);
		if (recUser.isPresent()) {
			structure.setMessage("User verfiyed");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
}
