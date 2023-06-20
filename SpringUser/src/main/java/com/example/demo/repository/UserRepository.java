package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.phone=?1 and u.password=?2")
	public Optional<User> verfiyByPhone(long phone, String password);
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public Optional<User> verfiyByEmail(String email, String password);
}
