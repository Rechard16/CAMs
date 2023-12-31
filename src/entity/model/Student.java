/*
Student:
• A student can only view the list of camps that are open to his/her user group (SCSE,
whole NTU etc.) and if their visibility has been toggled “on”.
• A student can view the remaining slots of each camp that is open to his/her.
• A student will be able to register for camps either as a camp attendee or camp
committee.
• A student can submit enquiries regarding a camp.
o Only staff and camp committees in charge of that camp can view it.
• A student can view, edit, and delete their enquiries before it is processed.
• The status of the student as a camp committee will be reflected in their profile.
• A student is only able to be in the camp committee for one camp but can attend
multiple camps.
• A student is not allowed to register for multiple camps if there are clashes in the
dates.
• A student only can register a camp before it is full.
• A student only can register a camp before it’s registration deadline.
• A student can see the camps that his/her has already registered for and his/her roles
(attendees OR camp committee)
• A student is allowed to withdraw from camps that his/her has already registered for.
The remaining slot will be updated automatically. But the student is not allowed to
register the same camp again
*/
package entity.model;

import java.util.ArrayList;
import java.util.List;

import entity.exception.UnauthorisedActionException;

/**
 * The Student class represents a student user in the system. It extends the
 * User class
 * and includes specific attributes and behaviors related to a student, such as
 * registration for camps, managing points, and keeping track of enrolled camps.
 */

public class Student extends User {
    /**
     * Points accumulated by the student.
     */
    private int points = 0;

    /**
     * The ID of the camp the student is currently registered for.
     */
    private int campID = 0;

    /**
     * A list of IDs of camps the student is registered for.
     */
    private List<Integer> camps = new ArrayList<Integer>();

    /**
     * A list of IDs of camps the student has withdrawn from.
     */
    private List<Integer> withdrawn = new ArrayList<Integer>();

    /**
     * Constructs a Student with specified details including ID, userID, faculty,
     * password, and campID.
     *
     * @param id       The student's unique identifier.
     * @param userID   The student's string-based unique ID.
     * @param faculty  The faculty to which the student belongs.
     * @param password The student's password.
     * @param campID   The initial camp ID for the student.
     */

    public Student(int id, String userID, Faculty faculty, String password, int campID) {
        super(id, userID, faculty, password);
        this.campID = campID;
    }

    /**
     * Returns the UserType as STUDENT.
     *
     * @return UserType enum value representing a student.
     */

    @Override
    public UserType getType() {
        return UserType.STUDENT;
    }

    /**
     * Retrieves the points accumulated by the student.
     *
     * @return The total points the student has accumulated.
     */

    public int getPoints() {
        return this.points;
    }

    /**
     * Sets the points for the student.
     *
     * @param points The new points value to be set for the student.
     */

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Adds a point to the student's total points.
     */

    public void addPoint() {
        this.points++;
    }

    /**
     * Retrieves a list of camp IDs the student is registered for.
     *
     * @return A list of integers representing the IDs of the camps.
     */

    public List<Integer> getCamps() {
        return this.camps;
    }

    /**
     * Sets the list of camp IDs for the student.
     *
     * @param camps The new list of camp IDs to be set for the student.
     */

    public void setCamps(List<Integer> camps) {
        this.camps = camps;
    }

    /**
     * Adds a camp to the list of camps the student is registered for.
     *
     * @param camp The camp to be added to the list.
     */

    public void removeCamp(Camp camp) {
        camps.remove((Integer) camp.getID());
    }

    /**
     * Retrieves the ID of the camp the user is currently assigned to.
     *
     * @return The ID of the current camp.
     */

    public int getCampID() {
        return this.campID;
    }

    /**
     * Sets the ID of the assigned camp for the user.
     *
     * @param campID The new camp ID to be assigned to the user.
     */
    public void setCampID(int CampID) {
        this.campID = CampID;
    }

    /**
     * Registers the student for a camp.
     *
     * @param camp The camp to be registered for.
     */

    public void register(Camp camp) {
        camps.add(camp.getID());
    }

    /**
     * Deregisters the student from a camp.
     *
     * @param camp The camp to be deregistered from.
     * @throws UnauthorisedActionException
     */

    public void deregister(Camp camp) throws UnauthorisedActionException {
        if (camp.getID() == this.campID)
            campID = -1;
        removeCamp(camp);
        withdrawn.add(camp.getID());
    }

    /**
     * Checks if the student is registered for a camp.
     *
     * @param camp The camp to be checked.
     * @return True if the student is registered for the camp, false otherwise.
     */

    @Override
    public boolean isRegistered(Camp camp) {
        return camps.contains(camp.getID());
    }

    /**
     * Returns the role of the user for the specified camp.
     *
     * @param camp The camp to check the user's role for.
     * @return The role of the user for the specified camp.
     */

    @Override
    public Role getRole(Camp camp) {
        if (camp.getID() == this.campID)
            return Role.COMMITTEE_MEMBER;
        if (isRegistered(camp))
            return Role.PARTICIPANT;
        if (withdrawn.contains(camp.getID()))
            return Role.WITHDRAWN;
        if (this.campID > -1)
            return Role.VIEWER;
        return Role.FREE_VIEWER;
    }
}
