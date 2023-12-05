package com.jacekg.teamfinder.event.exceptions;

public class RemoveEventException extends RuntimeException {

	public RemoveEventException(String message, Throwable cause) {
		super(message, cause);
	}

	public RemoveEventException(String message) {
		super(message);
	}

	public RemoveEventException(Throwable cause) {
		super(cause);
	}
}