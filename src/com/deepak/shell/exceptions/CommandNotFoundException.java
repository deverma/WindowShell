package com.deepak.shell.exceptions;

public class CommandNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException(String cmdName) {
		super("Command ["+cmdName+"] not exist.");
	}

}
