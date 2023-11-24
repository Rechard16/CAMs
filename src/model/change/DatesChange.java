package model.change;

import boundary.util.DateReader;
import main.Context;
import model.CampInfo;

import java.util.Date;
import java.util.List;
import model.Change;

public class DatesChange implements Change {
    private Date newStartDate;

    private DatesChange(Date newStartDate) {
        this.newStartDate = newStartDate;
    }

    public static DatesChange create(Context context) {
        context.print("Enter the new start date for your camp:");
        Date newStartDate = new DateReader(context).readDate();

        return new DatesChange(newStartDate);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDates(List.of(newStartDate));
    }
}
