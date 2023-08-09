package com.pritam.productservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pritam.productservice.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ProductServiceException.class)
	public ResponseEntity<ErrorResponse> handleProductServiceException(ProductServiceException exception) {
		ErrorResponse res = ErrorResponse.builder().errorMessage(exception.getMessage())
				.errorCode(exception.getStatusCode()).build();
		return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
	}
}
