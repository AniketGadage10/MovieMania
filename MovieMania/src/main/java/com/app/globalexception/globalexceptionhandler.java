package com.app.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.DTO.apiresponseDTO;
import com.app.exception.customexception;

@RestControllerAdvice
public class globalexceptionhandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodargumentnotvalidexception(MethodArgumentNotValidException m) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new apiresponseDTO(m.getFieldError().getDefaultMessage()));
	}

	@ExceptionHandler(customexception.class)
	public ResponseEntity<?> customexception(customexception c) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new apiresponseDTO(c.getMessage()));
	}
}
