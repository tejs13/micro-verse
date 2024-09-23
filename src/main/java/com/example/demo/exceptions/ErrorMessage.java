package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
	private HttpStatus statusCode;
	private String message;
	
	
	
	public ErrorMessage() {
		super();
	}

	public ErrorMessage(HttpStatus notFound, String message) {
		super();
		this.statusCode = notFound;
		this.message = message;
	}
	
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
