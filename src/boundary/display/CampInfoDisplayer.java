package boundary.display;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import boundary.IO;
import main.Context;
import model.CampInfo;
import model.User;
/*
 * CampInfoDisplayer is a class that is used to display camp information.
 */

public class CampInfoDisplayer extends Displayer {
	private final CampInfo info;
	/*
	 * Constructor for CampInfoDisplayer.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param info The camp information to be used.
	 */

	public CampInfoDisplayer(Context context, CampInfo info) {
		super(context);
		this.info = info;
	}
	/*
	 * Constructor for CampInfoDisplayer.
	 * 
	 * @param io The IO to be used.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param info The camp information to be used.
	 */

	public CampInfoDisplayer(IO io, Context context, CampInfo info) {
		super(io, context);
		this.info = info;
	}
	/*
	 * Displays the camp information.
	 * 
	 * @throws Exception
	 */

	public void display() throws ClassNotFoundException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		io.print("Camp name: %s\n", info.getName());
		List<Date> dates = info.getDates();
		io.print("Dates: %s to %s\n",
				dateFormat.format(dates.get(0)),
				dateFormat.format(dates.get(1)));
		io.print("Eligibility: %s\n", info.getEligibility().name());
		io.print("Location: %s\n", info.getLocation());
		io.print("Total Slots: %d\n", info.getTotalSlots());
		io.print("Committee Slots: %d\n", info.getCommitteeSlots());
		io.print("Description: %s\n", info.getDescription());

		User user = context.getUserManager().getUserByID(info.getStaffID());
		io.print("Staff-in-charge: %s\n", user.getName());
		io.print("Signup Deadline: %s\n", dateFormat.format(info.getDeadline()));
	}
}
