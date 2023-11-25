package exception;

/**
 * RegistrationPeriodExpiredException is an exception that is thrown when a user
 * tries to register for a camp after the registration period is over.
 */
public class RegistrationPeriodExpiredException extends Exception {
	public RegistrationPeriodExpiredException() {
		super("Registration period is already over");
	}

}
