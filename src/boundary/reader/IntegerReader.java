package boundary.reader;

import java.util.Scanner;

import main.Context;

/**
 * IntegerReader is a class that is used to read integers.
 */
public class IntegerReader {
	private final Context context;
	/*
	 * Constructor for IntegerReader.
	 * 
	 * @param context The context to be used.
	 */

	public IntegerReader(Context context) {
		this.context = context;
	}
	/*
	 * Reads an integer.
	 * 
	 * @return The integer that was read.
	 */

	public int readInt() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter an integer:");
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
			}
		}
	}
}
