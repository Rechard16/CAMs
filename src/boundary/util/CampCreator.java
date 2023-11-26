package boundary.util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import boundary.reader.BooleanReader;
import boundary.reader.DateReader;
import boundary.reader.IntegerReader;
import entity.model.CampInfo;
import entity.model.Faculty;
import entity.model.User;
import main.Context;

/**
 * CampCreator is a class that is used to create a camp.
 */
public class CampCreator {
	private final CampInfo campInfo = new CampInfo();
	private final Context context;
	private final User user;

	/*
	 * Constructor for CampCreator.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param user The user to be used.
	 */

	public CampCreator(Context context, User user) {
		this.context = context;
		this.user = user;
	}

	/*
	 * Builds a camp.
	 * 
	 * @return The camp that was built.
	 */

	public CampInfo build() {
		Scanner scanner = context.getScanner();
		context.print("What will be the name of your camp?");
		String name = scanner.nextLine();
		campInfo.setName(name);

		context.print("What date will your camp start?");
		Date start = new DateReader(context).readDate();

		context.print("Whate date will your camp end?");
		Date end = new DateReader(context).readDate();

		campInfo.setDates(List.of(start, end));

		context.print("Will your camp be open to the school?");
		boolean open = new BooleanReader(context).readBool();

		campInfo.setEligibility(open ? Faculty.SCHOOL : user.getFaculty());

		context.print("Where will your camp be held?");
		String location = scanner.nextLine();

		campInfo.setLocation(location);

		context.print("How many students may attend the camp?");
		int totalSlots = new IntegerReader(context).readInt();

		campInfo.setTotalSlots(totalSlots);

		context.print("How many committee members may there be in the camp?");
		int committeeSlots = new IntegerReader(context).readInt();

		campInfo.setCommitteeSlots(committeeSlots);

		context.print("What description will the camp have?");
		String description = scanner.nextLine();

		campInfo.setDescription(description);

		context.print("When will registration for the camp close?");
		Date deadline = new DateReader(context).readDate();

		campInfo.setDeadline(deadline);

		campInfo.setStaffID(user.getID());

		return this.campInfo;
	}

	/*
	 * Gets the camp info.
	 * 
	 * @return The camp info.
	 */

	public CampInfo getCampInfo() {
		return this.campInfo;
	}
}
