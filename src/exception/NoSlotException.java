package exception;

/**
 * NoSlotException is an exception that is thrown when a camp has no available
 * slots.
 */
public class NoSlotException extends Exception {

	public NoSlotException() {
		super("Camp has no available slots!");
	}
}
