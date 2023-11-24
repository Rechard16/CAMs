package boundary.reader;

import java.util.Scanner;

import main.Context;

public class IntegerReader {
	private final Context context;
	
	public IntegerReader(Context context) {
		this.context = context;
	}
	
	public int readInt() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter an integer:");
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {}
		}
	}
}
