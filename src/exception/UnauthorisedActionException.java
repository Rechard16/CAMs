package exception;

public class UnauthorisedActionException extends Exception {
	public UnauthorisedActionException() {
		super("Not allowed to perform action");
	}
}
