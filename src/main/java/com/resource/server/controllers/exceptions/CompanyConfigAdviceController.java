package com.resource.server.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CompanyConfigAdviceController {

	@ExceptionHandler(RequiredFieldException.class)
	public ResponseEntity<ResponseMsg> handleRequiredFieldException(RequiredFieldException ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseMsg> handleNotFoundException(NoDataFoundException ex) {
		ResponseMsg responseMsg = new ResponseMsg(ex.getMessage());
		return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
	}
}