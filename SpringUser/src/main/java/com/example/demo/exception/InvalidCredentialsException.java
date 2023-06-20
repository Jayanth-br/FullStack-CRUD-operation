package com.example.demo.exception;

public class InvalidCredentialsException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Invalid Phone or Password or Email";
	}
}
