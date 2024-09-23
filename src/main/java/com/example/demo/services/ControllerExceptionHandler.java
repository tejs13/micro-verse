package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exceptions.ErrorMessage;
import com.example.demo.exceptions.ResourceNotFoundException;



// Controller level expcetion handler, handling exception and returning resoponse enityt

@ControllerAdvice  // controller layer exception handle, applicalble to all @controller classes, by default, can be custom
@ResponseStatus //will send the rsponse status
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
	// create methods to handle the particular types of exception for ex.: ResourceNotFouDExcetion
	
	
	@ExceptionHandler(ResourceNotFoundException.class) // bind to particular exception
	public ResponseEntity<ErrorMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException exec, WebRequest webreq ) {
		ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, exec.getMessage());
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
		
	}

}
