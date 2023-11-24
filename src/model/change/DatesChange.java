package model.change;

import boundary.util.DateReader;
import main.Context;
import model.CampInfo;

import java.util.Date;
import java.util.List;
import model.Change;

public class DatesChange implements Change {
    private Date newStartDate;
    private Date newEndDate;

    private DatesChange(Date newStartDate, Date newEndDate) {
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
    }

    public static DatesChange create(Context context) {
        context.print("Enter the new start date for your camp:");
        Date newStartDate = new DateReader(context).readDate();

        context.print("Enter the new end date for your camp:");
        Date newEndDate = new DateReader(context).readDate();

        return new DatesChange(newStartDate, newEndDate);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDates(List.of(newStartDate, newEndDate));
    }
}
