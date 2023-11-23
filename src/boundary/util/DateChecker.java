package boundary.util;

import java.util.Date;
import java.util.List;

import model.Camp;

public class DateChecker {
	private final Date[] dates;
	
	public DateChecker(Camp camp) {
		List<Date> d = camp.getInformation().getDates();
		this.dates = new Date[] {d.get(0), d.get(1)};
	}
	
	public boolean checkViable(Camp camp) {
		List<Date> d = camp.getInformation().getDates();
		Date[] check = new Date[] {d.get(0), d.get(1)};
		
		return (dates[1].before(check[0]) || dates[0].after(check[1]));
	}
}
