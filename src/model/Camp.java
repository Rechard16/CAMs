package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Camp class represents a camp in the system.
 * It includes information about the camp, lists of registered users, visibility
 * status,
 * and identifiers for committee members and students.
 */

public class Camp extends Model {
    /**
     * Information about the camp.
     */
    private CampInfo information;

    /**
     * List of users registered for the camp.
     */
    private List<User> registered;

    /**
     * Indicates if the camp is visible to users.
     */
    private boolean visibility;

    /**
     * Unique identifier for the camp.
     */
    private int Id;

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
        this.registered = new ArrayList<>();
        this.committeeMembers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.totalRegistered = 0;
        this.visibility = true; // Default visibility is set to true.
        this.Id = information.getId(); // Set the ID based on provided information.
    }

    /**
     * Retrieves the visibility status of the camp.
     *
     * @return True if the camp is visible, false otherwise.
     */

    public boolean isVisible() {
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

    public void addStudent(Student student) {
        // Adds a student to the list of registered students and updates the total
        if (student != null && !this.students.contains(student.getId())) {
            this.students.add(student.getId());
            this.registered.add(student);
            this.totalRegistered++;
        }
    }

    /**
     * Removes a student from the camp's registration list.
     *
     * @param student The student to be removed from the camp.
     */

    public void removeStudent(Student student) {
        // Removes a student from the list of registered students and updates the total
        if (student != null && this.students.remove(Integer.valueOf(student.getId()))) {
            this.registered.remove(student);
            this.totalRegistered--;
        }
    }

    /**
     * Adds a committee member to the camp's committee list.
     * Ensures the member is not already a part of the committee before adding.
     *
     * @param member The student to be added as a committee member.
     */

    public void addCommitteeMember(Student member) {
        // Adds a committee member to the list if they are not already in it
        if (member != null && !this.committeeMembers.contains(member.getId())) {
            this.committeeMembers.add(member.getId());
        }
    }

    /**
     * Removes a committee member from the camp's committee list.
     *
     * @param member The committee member to be removed.
     */

    public void removeCommitteeMember(Student member) {
        // Removes a committee member from the list
        if (member != null) {
            this.committeeMembers.remove(Integer.valueOf(member.getId()));
        }
    }

    /**
     * Retrieves the unique identifier of the camp.
     *
     * @return The camp's ID.
     */

    public int getId() {
        return this.Id;
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
     * Retrieves the list of users registered for the camp.
     *
     * @return A list of User objects representing registered users.
     */

    public List<User> getRegistered() {
        return this.registered;
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
     * Sets the list of users registered for the camp.
     *
     * @param registered The new list of User objects to be set as registered users.
     */

    public void setRegistered(List<User> registered) {
        this.registered = registered;
    }

    /**
     * Sets the unique identifier for the camp.
     *
     * @param Id The new unique ID to be set for the camp.
     */

    public void setId(int Id) {
        this.Id = Id;
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

    /**
     * Retrieves the current visibility status of the camp.
     *
     * @return The visibility status of the camp.
     */

    public boolean getVisibility() {
        return this.visibility;
    }
}
