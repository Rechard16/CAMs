package model;

import java.util.Date;
import java.util.List;

public class CampInfo extends Model {
    private String name;
    private int CampId;
    private List<Date> dates;
    private Eligibility eligibility;
    private String location;
    private int totalSlots;
    private int committeeSlots;
    private String description;
    private Staff staffInCharge;
    public String staff;
    private Date deadline;

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.CampId;
    }

    public List<Date> getDates() {
        return this.dates;
    }

    public Eligibility getEligibility() {
        return this.eligibility;
    }

    public String getLocation() {
        return this.location;
    }

    public int getTotalSlots() {
        return this.totalSlots;
    }

    public int getCommitteeSlots() {
        return this.committeeSlots;
    }

    public String getDescription() {
        return this.description;
    }

    public Staff getStaffInCharge() {
        return this.staffInCharge;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int CampId) {
        this.CampId = CampId;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public void setEligibility(Eligibility eligibility) {
        this.eligibility = eligibility;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void setCommitteeSlots(int committeeSlots) {
        this.committeeSlots = committeeSlots;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStaffInCharge(Staff staffInCharge) {
        this.staffInCharge = staffInCharge;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

}