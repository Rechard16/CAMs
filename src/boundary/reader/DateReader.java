package boundary.reader;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import main.Context;

public class DateReader {
	private final Context context;
	
	public DateReader(Context context) {
		this.context = context;
	}

	public Date readDate() {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter a date (eg. 2023-12-03, 2024-05-05)");
			String raw = scanner.nextLine();
			try {
				LocalDate date = LocalDate.parse(raw);
				return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
			} catch (Exception e) {}
		}
	}
}
