package entity.model;

import java.util.Date;
import java.util.List;

import entity.Nameable;

/**
 * Represents information about a camp in the CAMS. This class includes
 * details such as the camp's name, unique identifier, dates, eligibility
 * criteria,
 * location, available slots (both total and for committee members),
 * description,
 * the staff member in charge, and the registration deadline.
 */

public class CampInfo extends Model implements Nameable {
    /**
     * The name of the camp.
     */
    private String name;

    /**
     * A unique identifier for the camp.
     */
    private int campID;

    /**
     * The start date and end date of the camp duration.
     */
    private List<Date> dates;

    /**
     * The faculty eligible user to participate in the camp.
     */

    private Faculty eligibility;

    /**
     * Location where the camp will be held.
     */

    private String location;

    /**
     * Total number of slots available for the camp.
     */

    private int totalSlots;

    /**
     * Number of slots allocated for committee members.
     */

    private int committeeSlots;

    /**
     * The description of the camp.
     */

    private String description;

    /**
     * Id of Staff in charge of this camp.
     */

    public int staffID;

    /**
     * Deadline for camp registration.
     */

    private Date deadline;

    /**
     * Retrieves the name of the camp.
     *
     * @return The camp's name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Default constructor
     */

    public CampInfo() {
    }

    /**
     * Constructs a new CampInfo instance by copying the details from an existing
     * CampInfo object.
     * This includes copying the camp's name, unique identifier, dates, eligibility
     * criteria,
     * location, total slots, committee slots, description, registration deadline,
     * and staff ID.
     * 
     * @param info The CampInfo instance from which to copy the details.
     *             Should not be {@code null}.
     */

    public CampInfo(CampInfo info) {
        this.name = info.getName();
        this.campID = info.getID();
        this.dates = info.getDates();
        this.eligibility = info.getEligibility();
        this.location = info.getLocation();
        this.totalSlots = info.getTotalSlots();
        this.committeeSlots = info.getCommitteeSlots();
        this.description = info.getDescription();
        this.deadline = info.getDeadline();
        this.staffID = info.getStaffID();
    }

    /**
     * Retrieves the unique identifier of the camp.
     *
     * @return The camp's ID.
     */

    @Override
    public int getID() {
        return this.campID;
    }

    /**
     * Retrieves the list of dates for the camp.
     *
     * @return The start and end date of class.
     */

    public List<Date> getDates() {
        return this.dates;
    }

    /**
     * Retrieves the eligibility criteria for the camp.
     *
     * @return The faculty that is eligible for the camp.
     */

    public Faculty getEligibility() {
        return this.eligibility;
    }

    /**
     * Retrieves the location of the camp.
     *
     * @return The location where the camp will be held.
     */

    public String getLocation() {
        return this.location;
    }

    /**
     * Retrieves the total number of slots available for the camp.
     *
     * @return The total number of slots.
     */

    public int getTotalSlots() {
        return this.totalSlots;
    }

    /**
     * Retrieves the number of slots allocated for committee members in the camp.
     *
     * @return The number of committee slots.
     */

    public int getCommitteeSlots() {
        return this.committeeSlots;
    }

    /**
     * Retrieves the description of the camp.
     *
     * @return The camp's description.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves the staff member in charge of the camp.
     *
     * @return The staff in charge.
     */

    public int getStaffID() {
        return this.staffID;
    }

    /**
     * Retrieves the deadline for camp registration.
     *
     * @return The registration deadline.
     */

    public Date getDeadline() {
        return this.deadline;
    }

    /**
     * Sets the name of the camp.
     *
     * @param name The new name to be set for the camp.
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the unique identifier for the camp.
     *
     * @param CampID The new unique ID to be set for the camp.
     */

    public void setID(int CampID) {
        this.campID = CampID;
    }

    /**
     * Sets the list of dates for the camp.
     *
     * @param dates The new list of dates to be set for the camp.
     */

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    /**
     * Sets the eligibility criteria for the camp.
     *
     * @param eligibility The new eligibility criteria to be set for the camp.
     */

    public void setEligibility(Faculty eligibility) {
        this.eligibility = eligibility;
    }

    /**
     * Sets the location of the camp.
     *
     * @param location The new location to be set for the camp.
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the total number of slots available for the camp.
     *
     * @param totalSlots The new total number of slots to be set for the camp.
     */

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    /**
     * Sets the number of slots allocated for committee members in the camp.
     *
     * @param committeeSlots The new number of committee slots to be set for the
     *                       camp.
     */

    public void setCommitteeSlots(int committeeSlots) {
        this.committeeSlots = committeeSlots;
    }

    /**
     * Sets the description of the camp.
     *
     * @param description The new description to be set for the camp.
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the staff member in charge of the camp.
     *
     * @param staffInCharge The new staff member to be set as in charge of the camp.
     */

    public void setStaffID(int id) {
        this.staffID = id;
    }

    /**
     * Sets the deadline for camp registration.
     *
     * @param deadline The new registration deadline to be set for the camp.
     */

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}