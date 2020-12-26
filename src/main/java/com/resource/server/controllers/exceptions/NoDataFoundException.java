package com.resource.server.controllers.exceptions;

public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException(String msg) {
		super(msg);
	}
}
