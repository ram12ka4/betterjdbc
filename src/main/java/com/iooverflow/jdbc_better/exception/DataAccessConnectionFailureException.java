package com.iooverflow.jdbc_better.exception;

public class DataAccessConnectionFailureException extends DataAccessException {
	private static final long serialVersionUID = 1L;

	public DataAccessConnectionFailureException(final Throwable cause) {
		super(cause);
	}
}
