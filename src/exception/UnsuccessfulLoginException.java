package exception;

/**
 * UnsuccessfulLoginException is an exception that is thrown when a user
 * tries to login after exceeding the maximum number of login attempts.
 */
public class UnsuccessfulLoginException extends Exception {
	public UnsuccessfulLoginException() {
		super("Exceeded maximum login attempts!");
	}
}
