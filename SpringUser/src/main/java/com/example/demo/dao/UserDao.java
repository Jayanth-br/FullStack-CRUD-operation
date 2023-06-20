package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;
import com.example.demo.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User updateUser(User user) {
		return repo.save(user);
	}

	public Optional<User> getUser(int id) {
		return repo.findById(id);
	}

	public List<User> getAllUser() {
		return repo.findAll();
	}

	public void deleteUser(User user) {
		repo.delete(user);
	}

	public Optional<User> verfiyUserByPhone(long phone, String password) {
		return repo.verfiyByPhone(phone, password);
	}

	public Optional<User> verfiyUserByEmail(String email, String password) {
		return repo.verfiyByEmail(email, password);
	}
}
