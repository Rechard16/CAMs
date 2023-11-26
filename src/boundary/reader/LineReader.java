package boundary.reader;

import java.util.Scanner;

import main.Context;

/**
 * LineReader is a class that is used to read Strings.
 */
public class LineReader {
	private final Context context;
	/*
	 * Constructor for BooleanReader.
	 * 
	 * @param context The context to be used.
	 */

	public LineReader(Context context) {
		this.context = context;
	}
	/*
	 * Reads a boolean.
	 * 
	 * @return The boolean that was read.
	 */

	public String readLine() {
		Scanner scanner = context.getScanner();
		while (true) {
			String raw = scanner.nextLine();
			if (raw.isBlank()) continue;
			return raw;
		}
	}

}
