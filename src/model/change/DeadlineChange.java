package model.change;

import main.Context;
import model.CampInfo;

import java.util.Date;

import boundary.reader.DateReader;
import model.Change;

public class DeadlineChange implements Change {
    private Date newDeadline;

    private DeadlineChange(Date newDeadline) {
        this.newDeadline = newDeadline;
    }

    public static DeadlineChange create(Context context) {
        context.print("Enter the new registration deadline for your camp:");
        Date newDeadline = new DateReader(context).readDate();
        return new DeadlineChange(newDeadline);
    }

    @Override
    public void modify(CampInfo campInfo) {
        campInfo.setDeadline(newDeadline);
    }
}
