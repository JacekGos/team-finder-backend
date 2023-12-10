package com.jacekg.teamfinder.venue.geocoding.exceptions;

public class LocationException extends RuntimeException {

	public LocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public LocationException(String message) {
		super(message);
	}

	public LocationException(Throwable cause) {
		super(cause);
	}
}