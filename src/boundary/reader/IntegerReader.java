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

	public int readInt(int minValue) {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter an integer:");
			try {
				int val = Integer.parseInt(scanner.nextLine());
				if (val < minValue) {
					context.print("Value cannot be less than %d!\n", minValue);
					continue;
				}
				return val;
			} catch (Exception e) {
			}
		}
	}
}
