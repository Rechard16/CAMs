package boundary.util;

public class RegistrationPeriodExpiredException extends Exception{
	public RegistrationPeriodExpiredException() {
		super("Registration period is already over");
	}

}
