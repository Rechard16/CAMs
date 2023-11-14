package model;

import java.util.Date;
import java.util.List;

/**
 * The CampInfo class represents information about a camp in the system.
 * It includes details such as the camp's name, ID, dates, eligibility criteria,
 * location,
 * total and committee slots, description, staff in charge, and registration
 * deadline.
 */

public class CampInfo extends Model {
    private String name; // The name of the camp.
    private int CampId; // A unique identifier for the camp.
    private List<Date> dates; // The dates when the camp will take place.
    private Faculty eligibility; // The faculty eligible to participate in the camp.
    private String location; // Location where the camp will be held.
    private int totalSlots; // Total number of slots available for the camp.
    private int committeeSlots; // Number of slots allocated for committee members.
    private String description; // The description of the camp.
    private Staff staffInCharge; // Staff member in charge of the camp.
    public String staff; // Name of Staff in charge
    private Date deadline; // Deadline for camp registration.

    /**
     * Retrieves the name of the camp.
     *
     * @return The name of the camp.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the unique identifier of the camp.
     *
     * @return The camp's ID.
     */

    @Override
    public int getId() {
        return this.CampId;
    }

    /**
     * Retrieves the list of dates for the camp.
     *
     * @return A list of dates.
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

    public Staff getStaffInCharge() {
        return this.staffInCharge;
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
     * @param CampId The new unique ID to be set for the camp.
     */

    public void setId(int CampId) {
        this.CampId = CampId;
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

    public void setStaffInCharge(Staff staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    /**
     * Sets the deadline for camp registration.
     *
     * @param deadline The new registration deadline to be set for the camp.
     */

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * Retrieves additional staff information.
     *
     * @return A string containing additional staff information.
     */

    public String getStaff() {
        return this.staff;
    }

    /**
     * Sets additional staff information.
     *
     * @param staff The additional staff information to set.
     */

    public void setStaff(String staff) {
        this.staff = staff;
    }
}