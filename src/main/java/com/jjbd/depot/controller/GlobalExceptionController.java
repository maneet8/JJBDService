
package com.jjbd.depot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.jjbd.depot.dto.ErrorDetailsDTO;
import com.jjbd.depot.exception.ContentNotFoundException;
import com.jjbd.depot.exception.InvalidInputException;

/**
 * 
 * Global Exception Controller for handling HTTP Status
 */
@RestControllerAdvice
public class GlobalExceptionController {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);
	
	@ExceptionHandler(value = { ContentNotFoundException.class})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public final ResponseEntity<ErrorDetailsDTO> handleContentNotFoundException(ContentNotFoundException e, WebRequest request) {
		logger.error("CONTENT NOT FOUND EXCEPTION {}", e);
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(e.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
	}
	
	
	@ExceptionHandler(value = { InvalidInputException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<ErrorDetailsDTO> handleInvalidInputException(InvalidInputException e, WebRequest request) {
		logger.error("INVALID INPUT EXCEPTION {}", e);
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(e.getMessage(),
		        request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
