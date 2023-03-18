package com.movement.app.exceptions;

public class CannotAuthenticateException extends RuntimeException{

	public CannotAuthenticateException(String actorname) {
		super("The actor " + actorname + " does not ahve the ability to signin to the application (System under test)");
	}
}
