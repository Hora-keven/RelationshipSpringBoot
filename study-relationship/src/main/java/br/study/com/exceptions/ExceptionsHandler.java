package br.study.com.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MessageResponse> error400UserAlreadyExists(UserException ex, WebRequest request){
		MessageResponse message = new MessageResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(message, new HttpHeaders(), message.getStatus());
		
	}
	

		
}
