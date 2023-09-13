package com.emp.gis.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	/*	
	@ExceptionHandler(DuplicateEmailException.class) 
	public ResponseEntity<AppError> handleDuplicateEmailException()
	

		@ExceptionHandler(EmployeeNotFoundException.class)
		public ResponseEntity<AppError> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
			AppError error = new AppError(404,ex.getMessage(), new Date());
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
	}*/

}
