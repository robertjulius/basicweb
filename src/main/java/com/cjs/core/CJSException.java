package com.cjs.core;

public class CJSException extends Exception {

	private static final long serialVersionUID = 4576612708483963263L;

	public CJSException(String message) {
		super(message);
	}

	public CJSException(Throwable throwable) {
		super(throwable);
	}
}
