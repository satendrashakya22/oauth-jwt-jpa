package com.resource.server.controllers.exceptions;

public class RequiredFieldException extends RuntimeException {

	public RequiredFieldException(String msg) {
		super(msg);
	}
}