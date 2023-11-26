package boundary.reader;

import java.util.Scanner;

import main.Context;

/**
 * EnumReader is a class that is used to read enums.
 */
public class EnumReader<T extends Enum<T>> {
	private final Context context;
	private final Class<T> type;
	/*
	 * Constructor for EnumReader.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param type The type of enum to be read.
	 */

	public EnumReader(Context context, Class<T> type) {
		this.context = context;
		this.type = type;
	}
	/*
	 * Reads an enum.
	 * 
	 * @return The enum that was read.
	 */

	public T readEnum() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter a " + type.getSimpleName());
			String raw = scanner.nextLine();
			try {
				T res = Enum.valueOf(type, raw.toUpperCase());
				return res;
			} catch (Exception e) {
			}
		}
	}
}
