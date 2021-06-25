package com.casestudy.auth.utilities;

/*
 * This class provides a custom exception in the
 * case that an exception occurs during the program.
 * Exceptions are handled from within the service package
 * so this class is not used frequently.
 */
public class ProgramException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProgramException(String errorMessage) {
		super("You have encountered an error.");
	}

}
