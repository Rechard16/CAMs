package boundary.reader;

import java.util.Scanner;

import main.Context;

/**
 * BooleanReader is a class that is used to read booleans.
 */
public class BooleanReader {
	private final Context context;
	/*
	 * Constructor for BooleanReader.
	 * 
	 * @param context The context to be used.
	 */

	public BooleanReader(Context context) {
		this.context = context;
	}
	/*
	 * Reads a boolean.
	 * 
	 * @return The boolean that was read.
	 */

	public boolean readBool() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter y/n");
			String raw = scanner.nextLine();
			if (raw.equals("y"))
				return true;
			if (raw.equals("n"))
				return false;
		}
	}
}
