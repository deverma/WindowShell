package com.deepak.shell.exceptions;


public class InvalidArgumentsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidArgumentsException(String errorMsg) {
		super(errorMsg);
	}
}
