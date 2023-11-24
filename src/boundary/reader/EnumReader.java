package boundary.reader;

import java.util.Scanner;

import main.Context;

public class EnumReader<T extends Enum<T>> {
	private final Context context;
	private final Class<T> type;
	
	public EnumReader(Context context, Class<T> type) {
		this.context = context;
		this.type = type;
	}

	public T readEnum() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter a " + type.getSimpleName());
			String raw = scanner.nextLine();
			try {
				T res = Enum.valueOf(type, raw.toUpperCase());
				return res;
			} catch (Exception e) {}
		}
	}
}
