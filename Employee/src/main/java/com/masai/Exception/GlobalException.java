package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalException 
{

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> EmployeeExceptionHandler(Exception ex ,  WebRequest req)
	{
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ErrorDetails> EmployeeException(EmployeeException ex ,  WebRequest req)
	{
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> NoDataFoundExceptionHandler(NoHandlerFoundException ex ,  WebRequest req)
	{
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> MethodArgumentNotValidException(Exception ex ,  WebRequest req)

	{
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
}
