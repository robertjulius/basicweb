package com.cjs.core.exception;

public class AppException extends GaneshaException {

	private static final long serialVersionUID = -9098238364164875570L;

	public AppException(String message) {
		this(new Exception(message));
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}
}
