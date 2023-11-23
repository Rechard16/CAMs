package boundary.login;

public class UnsuccessfulLoginException extends Exception {
	public UnsuccessfulLoginException() {
		super("Exceeded maximum login attempts!");
	}
}
