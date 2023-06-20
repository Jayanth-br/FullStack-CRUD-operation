package com.example.demo.exception;

public class IdNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "ID not found!";
	}
}
