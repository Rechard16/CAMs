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

    public int getId() {
        return this.CampId;
    }
}