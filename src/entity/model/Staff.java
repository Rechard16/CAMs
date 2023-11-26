/*
Staff:
• A staff will be able to create, edit and delete camps.
• A staff can toggle the visibility of the camp to be “on” or “off”. This will be reflected
in the camp list that will be visible to students.
• A staff can view all camps.
• A staff can see list of camps that his/her created in a separate menu list so they can
edit the camps they created.
• A staff can view and reply to enquiries from students to the camp(s) his/her has
created.
• A staff can view and approve suggestions to changes to camp details from camp
committee.
• A staff can generate a report of the list of students attending each camp that his/her
has created. The list will include details of the camp as well as the roles of the
participants. There should be filters for how the staff would want to generate the list.
(attendee, camp committee, etc.) (generate in either txt or csv format).
• A staff can also generate a performance report of the camp committee members
*/

package entity.model;

import entity.exception.UnauthorisedActionException;

/**
 * The Staff class represents a staff user in the system. It extends the User
 * class
 * and includes specific functionalities and privileges associated with staff
 * members.
 * Staff users have the capability to manage camps, handle enquiries, and
 * generate reports.
 */

public class Staff extends User {
	/*
	 * Constructs a Staff with specified ID, userID, faculty, and password.
	 */

	public Staff(int id, String userID, Faculty faculty, String password) {
		super(id, userID, faculty, password);
	}

	/**
	 * Returns the UserType as STAFF, indicating this user is a staff member.
	 *
	 * @return UserType enum value representing a staff member.
	 */

	@Override
	public UserType getType() {
		return UserType.STAFF;
	}

	/**
	 * Registers the specified camp to the system.
	 *
	 * @param camp The camp to be registered.
	 * @throws UnauthorisedActionException If the user is not authorized to perform
	 *                                     this action.
	 */

	@Override
	public boolean isRegistered(Camp camp) {
		return camp.getInformation().getStaffID() == this.getID();
	}

	/**
	 * Returns the role of the user for the specified camp.
	 *
	 * @param camp The camp to check the user's role for.
	 * @return The role of the user for the specified camp.
	 */

	@Override
	public Role getRole(Camp camp) {
		if (isRegistered(camp))
			return Role.OWNER;
		return Role.STAFF;
	}

	/**
	 * Registers the specified camp to the system.
	 *
	 * @param camp The camp to be registered.
	 * @throws UnauthorisedActionException If the user is not authorized to perform
	 *                                     this action.
	 */

	@Override
	public void deregister(Camp camp) throws UnauthorisedActionException {
		throw new UnauthorisedActionException();
	}
}