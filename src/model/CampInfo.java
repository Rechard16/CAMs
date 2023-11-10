package model;

import java.util.Date;
import java.util.List;

public class CampInfo extends Model {
    public String name;
    public int CampId;
    public List<Date> dates;
    public Eligibility eligibility;
    public String location;
    public int totalSlots;
    public int committeeSlots;
    public String description;
    public Staff staffInCharge;
    public String staff;
    public Date deadline;

    public int getId() {
        return this.CampId;
    }

    public Eligibility getEligibility() {
        return this.eligibility;
    }
}