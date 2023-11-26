package entity.exception;

/**
 * UnauthorisedActionException is an exception that is thrown when a user tries
 * to perform an action that they are not authorised to perform.
 */

public class UnauthorisedActionException extends Exception {
	public UnauthorisedActionException() {
		super("Not allowed to perform action");
	}
}
