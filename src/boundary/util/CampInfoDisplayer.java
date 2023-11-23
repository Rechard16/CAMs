package boundary.util;

import java.io.IOException;

import main.Context;
import model.CampInfo;
import model.User;

public class CampInfoDisplayer {
	private final Context context;
	private final CampInfo info;
	
	public CampInfoDisplayer(Context context, CampInfo info) {
		this.context = context;
		this.info = info;
	}
	
	public void displayCampInfo() throws ClassNotFoundException, IOException {
		context.print("Camp name: %s\n", info.getName());
		context.print("Dates:");
		context.print(info.getDates());
		context.print("Eligibility: %s\n", info.getEligibility().name());
		context.print("Location: %s\n", info.getLocation());
		context.print("Total Slots: %d\n", info.getTotalSlots());
		context.print("Committee Slots: %d\n", info.getCommitteeSlots());
		context.print("Description: %s\n", info.getDescription());
		
		User user = context.getUserManager().getUserByID(info.getStaffID());
		context.print("Staff-in-charge: %s\n", user.getUserID());
		context.print("Signup Deadline: %s\n", info.getDeadline());
	}
}
