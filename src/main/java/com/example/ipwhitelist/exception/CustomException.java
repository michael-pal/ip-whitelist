package com.example.ipwhitelist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public static final String INVALID_REQUEST = "ERROR: Invalid Request";
	
	public static final String ALREADY_EXISTS = "Record already exists";
	
	public static final String DOES_NOT_EXISTS = "Record does not exists";

	public CustomException(String e) {
		super(e);
	}

	public CustomException(String exe, Throwable throwExc) {
		super(exe, throwExc);
	}

}
