package entity.filter;

import java.io.IOException;

import entity.model.Camp;
import entity.model.User;
import main.Context;

public class StaffParameter extends FilterParameter<Camp> {
	/**
	 * The staff ID.
	 */
	private String staffID = "";

	@Override
	/**
	 * Checks if the camp is valid.
	 * 
	 * @param context The context to be used.
	 * @param obj     The camp to be used.
	 * @return True if the camp is valid, false otherwise.
	 */
	public boolean isValid(Context context, Camp obj) throws ClassNotFoundException, IOException {
		int id = obj.getInformation().getStaffID();
		User user = context.getUserManager().getUserByID(id);
		return user.getName().toUpperCase().contains(staffID.toUpperCase());
	}

	@Override
	/**
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Camp"
	 */
	public void build(Context context) throws Exception {
		context.print("What is the name of the staff you are searching for?");
		staffID = context.getScanner().nextLine();
	}

	@Override
	/**
	 * Gets the name of the filter parameter.
	 * 
	 * @return "Camp"
	 */
	public String getName() {
		return String.format("Staff: %s", staffID);
	}
}
