package entity.exception;

/**
 * TimePeriodClashException is an exception that is thrown when a camp has no
 * available
 * slots.
 */

public class TimePeriodClashException extends Exception {
	public TimePeriodClashException(String name) {
		super(String.format("Clashes with existing camp: %s", name));
	}
}
