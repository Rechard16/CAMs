package boundary.util;

public class NoSlotException extends Exception{
	public NoSlotException() {
		super("Camp has no available slots!");
	}
}
