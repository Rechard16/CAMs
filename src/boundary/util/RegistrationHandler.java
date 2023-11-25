package boundary.util;

import java.util.Date;

import exception.NoSlotException;
import exception.RegistrationPeriodExpiredException;
import exception.TimePeriodClashException;
import main.Context;
import model.Camp;
import model.CampInfo;
import model.Student;
import model.User;

/**
 * RegistrationHandler is a class that is used to handle registrations.
 */
public class RegistrationHandler {
	private final Context context;
	private final Student student;
	private final Camp camp;
	private final boolean committee;
	/*
	 * Constructor for RegistrationHandler.
	 * 
	 * @param context The context to be used.
	 * 
	 * @param user The user to be used.
	 * 
	 * @param camp The camp to be used.
	 * 
	 * @param committee The boolean value of whether the user is a committee
	 * member.
	 */

	public RegistrationHandler(Context context, User user, Camp camp, boolean committee) {
		this.context = context;
		this.student = (Student) user;
		this.camp = camp;
		this.committee = committee;
	}
	/*
	 * Registers the user for the camp.
	 * 
	 * @return The boolean value of whether the user was registered.
	 * 
	 * @throws Exception
	 */

	public boolean register() throws Exception {
		this.check();
		student.register(camp);
		camp.addStudent(student.getID());

		if (committee) {
			student.setCampID(camp.getID());
			camp.addCommitteeMember(student.getID());
		}

		context.getUserManager().save();
		context.getCampManager().save();
		return true;
	}
	/*
	 * Checks if the user can register for the camp.
	 * 
	 * @throws Exception
	 */

	private void check() throws Exception {

		CampInfo info = camp.getInformation();

		if (info.getTotalSlots() == camp.getTotalRegistered())
			throw new NoSlotException();

		if (committee && info.getCommitteeSlots() == camp.getCommitteeMembers().size())
			throw new NoSlotException();

		Date now = new Date();
		if (now.after(info.getDeadline()))
			throw new RegistrationPeriodExpiredException();

		DateChecker checker = new DateChecker(camp);

		for (int campID : student.getCamps()) {
			Camp other = context.getCampManager().getCampByID(campID);

			if (!checker.checkViable(other))
				throw new TimePeriodClashException(other.getInformation().getName());
		}
	}
}
