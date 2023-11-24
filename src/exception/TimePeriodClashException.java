package exception;

public class TimePeriodClashException extends Exception {
	public TimePeriodClashException(String name) {
		super(String.format("Clashes with existing camp: %s", name));
	}
}
