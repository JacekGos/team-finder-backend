package com.jacekg.teamfinder.event.exceptions;

public class CreateEventException extends RuntimeException {

	public CreateEventException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateEventException(String message) {
		super(message);
	}

	public CreateEventException(Throwable cause) {
		super(cause);
	}
}