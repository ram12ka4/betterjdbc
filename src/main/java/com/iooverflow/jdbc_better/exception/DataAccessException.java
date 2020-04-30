package com.iooverflow.jdbc_better.exception;

public class DataAccessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataAccessException() {
	}

	public DataAccessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DataAccessException(final String message) {
		super(message);
	}

	public DataAccessException(final Throwable cause) {
		super(cause);
	}
}