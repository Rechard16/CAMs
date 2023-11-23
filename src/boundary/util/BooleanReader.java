package boundary.util;

import java.util.Scanner;

import main.Context;

public class BooleanReader {
	private final Context context;
	
	public BooleanReader(Context context) {
		this.context = context;
	}
	
	public boolean readBool() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter y/n");
			String raw = scanner.nextLine();
			if (raw.equals("y")) return true;
			if (raw.equals("n")) return false;
		}
	}
}
