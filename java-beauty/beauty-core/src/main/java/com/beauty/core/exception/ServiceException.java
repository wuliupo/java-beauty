package com.beauty.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 6518259693218733100L;
	
	final Logger logger = LoggerFactory.getLogger(ServiceException.class);
	
	public ServiceException() {
		super();
	}

	private String message;

	public ServiceException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
