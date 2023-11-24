package model;

import java.util.ArrayList;
import java.util.List;

import exception.UnauthorisedActionException;
import model.interfaces.FacultyMember;
import model.interfaces.Locatable;
import model.interfaces.Nameable;

/**
 * The Camp class represents a camp in the system.
 * It includes information about the camp, lists of registered users, visibility
 * status,
 * and identifiers for committee members and students.
 */

public class Camp extends Model implements Nameable, Locatable, FacultyMember {
    /**
     * Information about the camp.
     */
    private CampInfo information;

    /**
     * Indicates if the camp is visible to users.
     */
    private boolean visibility;

    /**
     * Unique identifier for the camp.
     */
    private int id;

    /**
     * List of IDs of committee members.
     */
    private List<Integer> committeeMembers;

    /**
     * List of IDs of registered students.
     */
    private List<Integer> students;

    /**
     * Total number of registered users.
     */
    private int totalRegistered;

    /**
     * Constructs a Camp with specified camp information.
     * Initializes the lists of registered users, committee members, and students,
     * and sets the camp's ID.
     *
     * @param information The detailed information about the camp.
     */

    public Camp(CampInfo information) {
        this.information = information;
        this.committeeMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.totalRegistered = 0;
        this.visibility = false; // Default visibility is set to false.
        this.id = information.getID(); // Set the ID based on provided information.
    }
    
    public Camp(Camp camp) {
    	this.information = new CampInfo(camp.getInformation());
        this.committeeMembers = new ArrayList<>(camp.getCommitteeMembers());
        this.students = new ArrayList<>(camp.getStudents());
        this.totalRegistered = camp.getTotalRegistered();
        this.visibility = camp.visibility; // Default visibility is set to true.
        this.id = information.getID(); // Set the ID based on provided information.
    }

    /**
     * Retrieves the visibility status of the camp.
     *
     * @return True if the camp is visible, false otherwise.
     */

    public boolean getVisibility() {
        return visibility;
    }

    /**
     * Sets the visibility status of the camp.
     *
     * @param visibility The new visibility status to be set.
     */

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /**
     * Sets the detailed information for the camp.
     *
     * @param information The new CampInfo object to be associated with the camp.
     */

    public void setInformation(CampInfo information) {
        this.information = information;
    }

    /**
     * Adds a student to the camp's registration list.
     * Ensures the student is not already registered before adding.
     *
     * @param student The student to be added to the camp.
     */

    public void addStudent(int id) {
        // Adds a student to the list of registered students and updates the total
        if (!this.students.contains(id)) {
            this.students.add(id);
            this.totalRegistered++;
        }
    }

    /**
     * Removes a student from the camp's registration list.
     *
     * @param student The student to be removed from the camp.
     * @throws UnauthorisedActionException 
     */

    public void removeUser(int id) throws UnauthorisedActionException {
        if (committeeMembers.contains(id))
        	throw new UnauthorisedActionException();
        // Removes a student from the list of registered students and updates the total
        if (this.students.remove((Integer) id)) {
            this.totalRegistered--;
        }
    }

    /**
     * Adds a committee member to the camp's committee list.
     * Ensures the member is not already a part of the committee before adding.
     *
     * @param i The student to be added as a committee member.
     */

    public void addCommitteeMember(int i) {
        // Adds a committee member to the list if they are not already in it
        if (!this.committeeMembers.contains(id)) {
            this.committeeMembers.add(id);
        }
    }

    /**
     * Retrieves the unique identifier of the camp.
     *
     * @return The camp's ID.
     */

    public int getID() {
        return this.id;
    }

    /**
     * Retrieves the detailed information of the camp.
     *
     * @return The CampInfo object associated with the camp.
     */

    public CampInfo getInformation() {
        return this.information;
    }

    /**
     * Retrieves the list of IDs of committee members.
     *
     * @return A list of integers representing the IDs of committee members.
     */

    public List<Integer> getCommitteeMembers() {
        return this.committeeMembers;
    }

    /**
     * Retrieves the list of IDs of students registered for the camp.
     *
     * @return A list of integers representing the IDs of registered students.
     */

    public List<Integer> getStudents() {
        return this.students;
    }

    /**
     * Retrieves the total number of users registered for the camp.
     *
     * @return The total number of registered users.
     */

    public int getTotalRegistered() {
        return this.totalRegistered;
    }

    /**
     * Sets the unique identifier for the camp.
     *
     * @param ID The new unique ID to be set for the camp.
     */

    public void setID(int id) {
        this.id = id;
    }

    /**
     * Sets the list of IDs for committee members.
     *
     * @param committeeMembers The new list of integers to be set as the IDs of
     *                         committee members.
     */

    public void setCommitteeMembers(List<Integer> committeeMembers) {
        this.committeeMembers = committeeMembers;
    }

    /**
     * Sets the list of IDs for students registered for the camp.
     *
     * @param students The new list of integers to be set as the IDs of registered
     *                 students.
     */

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    /**
     * Sets the total number of users registered for the camp.
     *
     * @param totalRegistered The new total number of registered users.
     */

    public void setTotalRegistered(int totalRegistered) {
        this.totalRegistered = totalRegistered;
    }
    
    @Override
    public String getName() {
    	return this.information.getName();
    }

	@Override
	public Faculty getFaculty() {
		return this.getInformation().getEligibility();
	}

	@Override
	public String getLocation() {
		return this.getInformation().getLocation();
	}
}
