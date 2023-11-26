package control.event;

import java.util.Date;
import java.util.List;

import entity.model.Camp;

/**
 * DateChecker is a class that is used to check if a camp is viable.
 */
public class DateChecker {
	private final Date[] dates;

	/*
	 * Constructor for DateChecker.
	 * 
	 * @param camp The camp to be used.
	 */

	public DateChecker(Camp camp) {
		List<Date> d = camp.getInformation().getDates();
		this.dates = new Date[] { d.get(0), d.get(1) };
	}

	/*
	 * Checks if a camp is viable.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @return The boolean value of whether the camp is viable.
	 */

	public boolean checkViable(Camp camp) {
		List<Date> d = camp.getInformation().getDates();
		Date[] check = new Date[] { d.get(0), d.get(1) };

		return (dates[1].before(check[0]) || dates[0].after(check[1]));
	}
}
