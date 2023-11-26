package boundary.reader;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import main.Context;

/**
 * DateReader is a class that is used to read dates.
 */

public class DateReader {
	private final Context context;
	/*
	 * Constructor for DateReader.
	 * 
	 * @param context The context to be used.
	 */

	public DateReader(Context context) {
		this.context = context;
	}
	/*
	 * Reads a date.
	 * 
	 * @return The date that was read.
	 */

	public Date readDate(Date notBefore, Date notAfter) {
		Scanner scanner = context.getScanner();
		while (true) {
			context.print("Enter a date (eg. 2023-12-03, 2024-05-05)");
			String raw = scanner.nextLine();
			try {
				LocalDate date = LocalDate.parse(raw);
				Date res = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
				if (notBefore != null && res.before(notBefore)) {
					context.print("Date cannot be before %s!\n", notBefore.toString());
					continue;
				}
				if (notAfter != null && res.after(notAfter)) {
					context.print("Date cannot be after %s!\n", notAfter.toString());
					continue;
				}
				return res;
			} catch (Exception e) {}
		}
	}
}
